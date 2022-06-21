var data = null;
$(document).ready(function () {
    $('#sihapus').hide();
    $('#siubah').hide();
    var table = $('#dataUser').DataTable({
        info: false,
        dom: "<'row'<'col-md-5 text-left'B><'col-md-3'l><'col-md-4'f>>" +
            "<'row'<'col-md-12'tr>>" +
            "<'row'<'col-md-5'i><'col-md-7'p>>",
        buttons: [{
            text: "<i class=\"fas fa-download\"></i> Export CSV",
            extend: 'csv',
            exportOptions: {
                columns: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
            }
        }, {
            text: "<i class=\"fas fa-download\"></i> Export Excel",
            extend: 'excel',
            exportOptions: {
                columns: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
            },
            title: function () {
                let date = new Date().toLocaleDateString();
                return 'SIKEO - Rekap Data Penilaian (dibuat pada ' + formatDate(date, false, 'mdy') + ')';
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
            targets: [0, 9, 10]
        }],
        ScrollX: true,
        order: [[1, 'asc']],
        columns: [
            {data: null},
            {data: "nikpenilai", class: "tbl-center"},
            {data: "niktujuan", class: "tbl-center d-none"},
            {data: "leadership", class: "tbl-center"},
            {data: "motivasi", class: "tbl-center"},
            {data: "benchmarking", class: "tbl-center"},
            {data: "managementStrategi", class: "tbl-center"},
            {data: "bpjsInHealth", class: "tbl-center"},
            {data: "pff", class: "tbl-center"},
            {data: "pfsf", class: "tbl-center"},
            {data: "aiso9001", class: "tbl-center"},
            {data: "aiso140001", class: "tbl-center"},
            {data: "aohsas180001", class: "tbl-center"},
            {data: "bst", class: "tbl-center"},
            {data: "appe", class: "tbl-center"},
            {data: "aiso220000", class: "tbl-center"},
            {data: "star5", class: "tbl-center"}
        ],
    });
    table.on('draw.dt', function () {
        var PageInfo = $('#dataUser').DataTable().page.info();
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
            url: "/api/penilaian/list" + nik,
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