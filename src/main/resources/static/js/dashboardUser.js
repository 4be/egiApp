// //Terbaik tahun ini
// var data = null;
// $(document).ready(function () {
//     $('#sihapus').hide();
//     $('#siubah').hide();
//     var table = $('#dataPenilaian2').DataTable({
//         searching: false,
//         paging: false,
//         info: false,
//         dom: "<'row'<'col-md-3'l><'col-md-5 text-left'B><'col-md-4'f>>" +
//             "<'row'<'col-md-12'tr>>" +
//             "<'row'<'col-md-5'i><'col-md-7'p>>",
//         buttons: [{
//             text: "<i class=\"fas fa-download\"></i> Export CSV",
//             extend: 'csv',
//             exportOptions: {
//                 columns: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
//             }
//         }, {
//             text: "<i class=\"fas fa-download\"></i> Export Excel",
//             extend: 'excel',
//             exportOptions: {
//                 columns: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
//             },
//             title: function () {
//                 let date = new Date().toLocaleDateString();
//                 return 'SIKEO - Rekap Data Penilaian (dibuat pada ' + formatDate(date, false, 'mdy') + ')';
//             },
//             messageTop: function () {
//                 return ' ';
//             }
//         }],
//         lengthMenu: [
//             [10, 25, 50, -1],
//             ['10 rows', '25 rows', '50 rows', 'Show all']
//         ],
//         ajax: {
//             url: "/api/penilaian/list/",
//             type: "GET",
//             data: "data",
//             headers: {Authorization: localStorage.getItem("token")},
//             error: function (result) {
//                 if (result.status == 401) {
//                     alert(result.responseJSON.message);
//                     localStorage.removeItem("token");
//                     location.href = "/";
//                 }
//             }
//         },
//         columnDefs: [{
//             searchable: false,
//             orderable: true,
//             targets: [0, 9, 10]
//         }],
//         ScrollX: false,
//         order: [[16, 'desc']],
//         columnDefs: [
//             {"width": "20%", "targets": 0}
//         ],
//         columns: [
//             {data: "id", class: "tbl-center d-none"},
//             {data: "nikpenilai", class: "tbl-center d-none"},
//             {data: "niktujuan", class: "tbl-center"},
//             {data: "leadership", class: "tbl-center d-none"},
//             {data: "motivasi", class: "tbl-center d-none"},
//             {data: "benchmarking", class: "tbl-center d-none"},
//             {data: "managementStrategi", class: "tbl-center d-none"},
//             {data: "bpjsInHealth", class: "tbl-center d-none"},
//             {data: "pff", class: "tbl-center d-none"},
//             {data: "pfsf", class: "tbl-center d-none"},
//             {data: "aiso9001", class: "tbl-center d-none"},
//             {data: "aiso140001", class: "tbl-center d-none"},
//             {data: "aohsas180001", class: "tbl-center d-none"},
//             {data: "bst", class: "tbl-center d-none"},
//             {data: "appe", class: "tbl-center d-none"},
//             {data: "aiso220000", class: "tbl-center d-none"},
//             {data: "star5", class: "tbl-center"}
//         ],
//     });
//     // table.on('draw.dt', function () {
//     //     var PageInfo = $('#dataPenilaian').DataTable().page.info();
//     //     table.column(0, {page: 'current'}).nodes().each(function (cell, i) {
//     //         cell.innerHTML = i + 1 + PageInfo.start;
//     //     });
//     // });
// });
//
//
// //last penilaian
// var data = null;
// $(document).ready(function () {
//     $('#sihapus').hide();
//     $('#siubah').hide();
//     var table = $('#dataPenilaian').DataTable({
//         searching: false,
//         paging: false,
//         info: false,
//         dom: "<'row'<'col-md-3'l><'col-md-5 text-left'B><'col-md-4'f>>" +
//             "<'row'<'col-md-12'tr>>" +
//             "<'row'<'col-md-5'i><'col-md-7'p>>",
//         buttons: [{
//             text: "<i class=\"fas fa-download\"></i> Export CSV",
//             extend: 'csv',
//             exportOptions: {
//                 columns: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
//             }
//         }, {
//             text: "<i class=\"fas fa-download\"></i> Export Excel",
//             extend: 'excel',
//             exportOptions: {
//                 columns: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
//             },
//             title: function () {
//                 let date = new Date().toLocaleDateString();
//                 return 'SIKEO - Rekap Data Penilaian (dibuat pada ' + formatDate(date, false, 'mdy') + ')';
//             },
//             messageTop: function () {
//                 return ' ';
//             }
//         }],
//         lengthMenu: [
//             [10, 25, 50, -1],
//             ['10 rows', '25 rows', '50 rows', 'Show all']
//         ],
//         ajax: {
//             url: "/api/penilaian/list/",
//             type: "GET",
//             data: "data",
//             headers: {Authorization: localStorage.getItem("token")},
//             error: function (result) {
//                 if (result.status == 401) {
//                     alert(result.responseJSON.message);
//                     localStorage.removeItem("token");
//                     location.href = "/";
//                 }
//             }
//         },
//         columnDefs: [{
//             searchable: false,
//             orderable: true,
//             targets: [0, 9, 10]
//         }],
//         ScrollX: false,
//         order: [[0, 'desc']],
//         columnDefs: [
//             {"width": "20%", "targets": 0}
//         ],
//         columns: [
//             {data: "id", class: "tbl-center d-none"},
//             {data: "nikpenilai", class: "tbl-center"},
//             {data: "niktujuan", class: "tbl-center"},
//             {data: "leadership", class: "tbl-center d-none"},
//             {data: "motivasi", class: "tbl-center d-none"},
//             {data: "benchmarking", class: "tbl-center d-none"},
//             {data: "managementStrategi", class: "tbl-center d-none"},
//             {data: "bpjsInHealth", class: "tbl-center d-none"},
//             {data: "pff", class: "tbl-center d-none"},
//             {data: "pfsf", class: "tbl-center d-none"},
//             {data: "aiso9001", class: "tbl-center d-none"},
//             {data: "aiso140001", class: "tbl-center d-none"},
//             {data: "aohsas180001", class: "tbl-center d-none"},
//             {data: "bst", class: "tbl-center d-none"},
//             {data: "appe", class: "tbl-center d-none"},
//             {data: "aiso220000", class: "tbl-center d-none"},
//             {data: "star5", class: "tbl-center d-none"}
//         ],
//     });
//     // table.on('draw.dt', function () {
//     //     var PageInfo = $('#dataPenilaian').DataTable().page.info();
//     //     table.column(0, {page: 'current'}).nodes().each(function (cell, i) {
//     //         cell.innerHTML = i + 1 + PageInfo.start;
//     //     });
//     // });
// });

//yesterday date
function handleDate() {
    let today = new Date();
    let yesterday = new Date();
    yesterday.setDate(today.getDate() - 1);
    let todayDate = formatDate(today.toLocaleDateString(), false, 'mdy');
    let yesterdayDate = formatDate(yesterday.toLocaleDateString(), false, 'mdy');
    $('#todayDate').html(todayDate);
    $('#yesterdayDate').html(yesterdayDate);
}

handleDate();

// user count
$.ajax({
    url: "/api/user/",
    type: "GET",
    headers: {Authorization: localStorage.getItem("token")},
    success: function (result) {
        $('.userCount').html(result.data.length);
        $('.userName').html(localStorage.getItem("nama"));
    },
    error: function (result) {
        if (result.status == 401) {
            alert(result.responseJSON.message);
            localStorage.removeItem("token");
            location.href = "/";
        }
    }
});

$.ajax({
    url: "/api/penilaian/list/",
    type: "GET",
    headers: {Authorization: localStorage.getItem("token")},
    data: "data",
    success: function (result) {

    },
    error: function (result) {
        if (result.status == 401) {
            alert(result.responseJSON.message);
            localStorage.removeItem("token");
            location.href = "/";
        }
    }
})
;
