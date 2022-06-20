var data = null;
$(document).ready(function () {
    $('#sihapus').hide();
    $('#siubah').hide();
    var table = $('#dataKeteranganTable').DataTable({
        dom: "<'row'<'col-md-3'l><'col-md-5 text-left'B><'col-md-4'f>>" +
            "<'row'<'col-md-12'tr>>" +
            "<'row'<'col-md-5'i><'col-md-7'p>>",
        buttons: [{
            text: "<i class=\"fas fa-download\"></i> Export CSV",
            extend: 'csv',
            exportOptions: {
                columns: [1, 2, 3, 4, 5, 6, 7]
            }
        }, {
            text: "<i class=\"fas fa-download\"></i> Export Excel",
            extend: 'excel',
            exportOptions: {
                columns: [1, 2, 3, 4, 5, 6, 7]
            },
            title: function () {
                let date = new Date().toLocaleDateString();
                return 'SIKASEP - Rekap Data User (dibuat pada ' + formatDate(date,false,'mdy') + ')';
            },
            messageTop: function () {
                return ' ';
            }
        }],
        lengthMenu: [
            [10, 25, 50, -1],
            ['10 rows', '25 rows', '50 rows', 'Show all']
        ],
        ajax: {
            url: "/api/penilaian/list/",
            type: "GET",
            data: "data",
            headers: {Authorization: localStorage.getItem("token")},
            error: function (result) {
                if (result.status == 401) {
                    alert(result.responseJSON.message);
                    localStorage.removeItem("token");
                    location.href = "/";
                }
            }
        },
        columnDefs: [{
            searchable: false,
            orderable: false,
            targets: [0,9,10]
        }],
        ScrollX: true,
        order: [[1, 'asc']],
        columns: [
            {data: null},
            {data: "id", class: "tbl-center"},
            {data: "leadership", class: "tbl-center"},
            {data: "motivasi", class: "tbl-center"},
            {data: "benchmarking", class: "tbl-center"},
            {data: "managementStrategi", class: "tbl-center"},
            {data: "bpjsInHealth", class: "tbl-center"},
            {data: "nik_manager", class: "tbl-center"},
            {data: "niktujuan", class: "tbl-center"},
            {
                data: "nik",
                render: function (data) {
                    return '<a href="/hcms/update/' + data + '"><button id="' + data + '" class="btn btn-info"><span class="fas fa-edit"></span> Ubah</button></a>'
                }
            },
            {
                data: "nik",
                render: function (data) {
                    return '<button id="' + data + '" onclick="deleteUser(this)" class="btn btn-danger"><span class="fas fa-trash"></span> Hapus</button>'
                }
            }
        ],
    });
    table.on('draw.dt', function () {
        var PageInfo = $('#dataKeteranganTable').DataTable().page.info();
        table.column(0, {page: 'current'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1 + PageInfo.start;
        });
    });
});

function deleteUser(obj) {
    var nik = $(obj).attr('id');
    var confir = confirm("Apakah anda yakin akan menghapus data user ?");
    if (confir == true) {
        $.ajax({
            url: "/api/user/nik/" + nik,
            type: "DELETE",
            headers: {Authorization: localStorage.getItem("token")},
            success: function (result) {
                if (result.status == 200) {
                    window.scrollTo(0, 0);
                    $("#sihapus").show();
                    setTimeout(function () {
                        location.reload();
                    }, 1500);
                }
            },
            error: function (result) {
                if (result.status == 401) {
                    location.href = "/";
                }
            }
        });
    }
}
