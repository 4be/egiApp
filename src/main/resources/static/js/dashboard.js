//Terbaik tahun ini
var data = null;
$(document).ready(function () {
    $('#sihapus').hide();
    $('#siubah').hide();
    var table = $('#dataPenilaian2').DataTable({
        searching: false,
        paging: false,
        info: false,
        sort: false,
        dom: "<'row'<'col-md-3'l><'col-md-5 text-left'B><'col-md-4'f>>" +
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
                return 'AppraisalIndorama - Rekap Data Penilaian (dibuat pada ' + formatDate(date, false, 'mdy') + ')';
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
            url: "/api/penilaian/list/best/",
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
            orderable: true,
            targets: [0, 9, 10]
        }],
        ScrollX: false,
        order: [[0, 'asc']],
        columnDefs: [
            {"width": "20%", "targets": 0}
        ],
        columns: [
            {data: "id", class: "tbl-center d-none"},
            {data: "nikpenilai", class: "tbl-center d-none"},
            {data: "niktujuan", class: "tbl-center "},
            {data: "nama", class: "tbl-center "},
            {data: "divisi", class: "tbl-center"},
            {data: "tanggungJawab", class: "tbl-center d-none"},
            {data: "inisiatif", class: "tbl-center d-none"},
            {data: "etikaKomunikasi", class: "tbl-center d-none"},
            {data: "displinKehadiran", class: "tbl-center d-none"},
            {data: "kerapihan", class: "tbl-center d-none"},
            {data: "kualitasPekerjaan", class: "tbl-center d-none"},
            {data: "kecepatanKerja", class: "tbl-center d-none"},
            {data: "mengetahuiPekerjaan", class: "tbl-center d-none"},
            {data: "totalNilai", class: "tbl-center "},
            {data: "kerjaSama", class: "tbl-center d-none"},
        ],
    });
    // table.on('draw.dt', function () {
    //     var PageInfo = $('#dataPenilaian').DataTable().page.info();
    //     table.column(0, {page: 'current'}).nodes().each(function (cell, i) {
    //         cell.innerHTML = i + 1 + PageInfo.start;
    //     });
    // });
});


//last penilaian
var data = null;
$(document).ready(function () {
    $('#sihapus').hide();
    $('#siubah').hide();
    var table = $('#dataPenilaian').DataTable({
        searching: false,
        paging: false,
        info: false,
        sort: false,
        dom: "<'row'<'col-md-3'l><'col-md-5 text-left'B><'col-md-4'f>>" +
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
                return 'AppraisalIndorama - Rekap Data Penilaian (dibuat pada ' + formatDate(date, false, 'mdy') + ')';
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
            url: "/api/penilaian/list/worst/",
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
            orderable: true,
            targets: [0, 9, 10]
        }],
        ScrollX: false,
        order: [[2, 'asc']],
        columnDefs: [
            {"width": "20%", "targets": 0}
        ],
        columns: [
            {data: "id", class: "tbl-center d-none"},
            {data: "nikpenilai", class: "tbl-center d-none"},
            {data: "niktujuan", class: "tbl-center "},
            {data: "nama", class: "tbl-center "},
            {data: "divisi", class: "tbl-center"},
            {data: "tanggungJawab", class: "tbl-center d-none"},
            {data: "inisiatif", class: "tbl-center d-none"},
            {data: "etikaKomunikasi", class: "tbl-center d-none"},
            {data: "displinKehadiran", class: "tbl-center d-none"},
            {data: "kerapihan", class: "tbl-center d-none"},
            {data: "kualitasPekerjaan", class: "tbl-center d-none"},
            {data: "kecepatanKerja", class: "tbl-center d-none"},
            {data: "mengetahuiPekerjaan", class: "tbl-center d-none"},
            {data: "totalNilai", class: "tbl-center "},
            {data: "kerjaSama", class: "tbl-center d-none"},
        ],
    });
    // table.on('draw.dt', function () {
    //     var PageInfo = $('#dataPenilaian').DataTable().page.info();
    //     table.column(0, {page: 'current'}).nodes().each(function (cell, i) {
    //         cell.innerHTML = i + 1 + PageInfo.start;
    //     });
    // });
});

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
        $('.nik').html(result.data);
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
//
// // clock in count
// $.ajax({
//     url: "/api/status/result/1",
//     type: "GET",
//     headers: {Authorization: localStorage.getItem("token")},
//     success: function (result) {
//         $('#clockInCount').html(result.data);
//     },
//     error: function (result) {
//         if (result.status == 401) {
//             alert(result.responseJSON.message);
//             localStorage.removeItem("token");
//             location.href = "/";
//         }
//     }
// });
// // clock out count
// $.ajax({
//     url: "/api/status/result/0",
//     type: "GET",
//     headers: {Authorization: localStorage.getItem("token")},
//     success: function (result) {
//         $('#clockOutCount').html(result.data);
//     },
//     error: function (result) {
//         if (result.status == 401) {
//             console.log(result);
//         }
//     }
// });
//
// //chart
// function generateRGBA(r, g, b, a) {
//     return 'rgba(' + r.toString() + ',' + g.toString() + ',' + b.toString() + ',' + a.toString() + ')';
// }
//
// Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
// Chart.defaults.global.defaultFontColor = '#3da54a';
//
// // function cvs_pie(cvsid, xlabel, val) {
// //     var ctx = $(cvsid);
// //     var myPieChart = new Chart(ctx, {
// //         type: 'pie',
// //         data: {
// //             labels: xlabel,
// //             datasets: [{
// //                 data: val,
// //                 backgroundColor: [generateRGBA(49, 247, 66, 0.7), generateRGBA(230, 42, 9, 0.7)],
// //                 hoverBackgroundColor: [generateRGBA(49, 247, 66, 0.9), generateRGBA(230, 42, 9, 0.9)],
// //                 hoverBorderColor: "rgba(234, 236, 244, 1)",
// //             }],
// //         },
// //         radius: 0.1,
// //         options: {
// //             maintainAspectRatio: false,
// //             tooltips: {
// //                 backgroundColor: "rgb(255,255,255)",
// //                 bodyFontColor: "#858796",
// //                 borderColor: '#dddfeb',
// //                 borderWidth: 1,
// //                 xPadding: 15,
// //                 yPadding: 15,
// //                 displayColors: false,
// //                 caretPadding: 10,
// //             },
// //             legend: {
// //                 display: true
// //             }
// //         },
// //     });
// // }
//
// function cvs_bar(cvsid, labels, data, xlabel, ylabel, yMax) {
//     let otherTitle = ''
//     let ctx = $(cvsid)[0].getContext('2d');
//     let myBarChart = new Chart(ctx, {
//         type: 'bar',
//         data: {
//             labels: labels,
//             datasets: data,
//         },
//         options: {
//             maintainAspectRatio: false,
//             scales: {
//                 yAxes: [{
//                     position: "left",
//                     ticks: {
//                         beginAtZero: true,
//                         max: yMax,
//                         callback: function (value) {
//                             if (value % 1 === 0) {
//                                 return value;
//                             }
//                         }
//                     },
//                     scaleLabel: {
//                         display: true,
//                         labelString: ylabel
//                     },
//                     type: 'linear'
//                 }],
//                 xAxes: [{
//                     position: "bottom",
//                     ticks: {
//                         beginAtZero: true
//                     },
//                     scaleLabel: {
//                         display: true,
//                         labelString: xlabel
//                     },
//                 }]
//             },
//             responsive: true,
//             legend: {
//                 display: true
//             },
//             tooltips: {
//                 mode: 'index',
//                 titleMarginBottom: 10,
//                 titleFontColor: '#6e707e',
//                 titleFontSize: 14,
//                 backgroundColor: "rgb(255,255,255)",
//                 bodyFontColor: "#3da54a",
//                 borderColor: '#dddfeb',
//                 borderWidth: 1,
//                 xPadding: 15,
//                 yPadding: 15,
//                 displayColors: false,
//                 caretPadding: 10,
//                 callbacks: {
//                     title: function (tooltipItems, data) {
//                         let title = tooltipItems[0].xLabel;
//                         if (title.substr(3, 2) == "00") {
//                             otherTitle = " - " + title.substr(0, 2) + ":59";
//                         }
//                         return tooltipItems[0].xLabel + otherTitle;
//                     }
//                 }
//             },
//         }
//     });
// }
//
// // data clock Yesterday
// async function clockYesterday() {
//     let valClockIn = [], valClockOut = [], labels = [];
//     let url = "/api/clock/totalclockyesterday/hour/";
//     let ajaxData, clockPromise;
//     for (let i = 0; i < 24; i++) {
//         clockPromise = new Promise(resolve => {
//             $.ajax({
//                 url: url + i.toString(),
//                 type: "GET",
//                 headers: {Authorization: localStorage.getItem("token")},
//                 success: function (result) {
//                     resolve(result);
//                 },
//                 error: function (result) {
//                     if (result.status == 401) {
//                         console.log(result);
//                     }
//                 }
//             });
//         });
//         ajaxData = await clockPromise;
//         valClockIn[i] = parseInt(ajaxData[0].split(",")[0]);
//         valClockOut[i] = parseInt(ajaxData[0].split(",")[1]);
//         if (i < 10) {
//             labels[i] = "0" + i + ".00";
//         } else {
//             labels[i] = i + ".00";
//         }
//     }
//     let max = Math.max.apply(null, valClockIn.concat(valClockOut));
//     let yMax = max + Math.ceil(0.1 * max);
//     let output = [{
//         label: "Clock In",
//         backgroundColor: generateRGBA(49, 247, 66, 0.7),
//         hoverBackgroundColor: generateRGBA(49, 247, 66, 0.9),
//         borderColor: generateRGBA(49, 247, 66, 0.9),
//         data: valClockIn,
//     }, {
//         label: "Clock Out",
//         backgroundColor: generateRGBA(230, 42, 9, 0.7),
//         hoverBackgroundColor: generateRGBA(230, 42, 9, 0.9),
//         borderColor: generateRGBA(230, 42, 9, 0.9),
//         data: valClockOut,
//     }];
//     cvs_bar('#clockYesterday', labels, output, 'Jam', 'Total Clock', yMax, ' - ');
// }
//
// clockYesterday();
//
// // data clock today
// async function clockToday() {
//     let valClockIn = [], valClockOut = [], labels = [];
//     let url = "/api/clock/totalclock/hour/";
//     let ajaxData, clockPromise;
//     for (let i = 0; i < 24; i++) {
//         clockPromise = new Promise(resolve => {
//             $.ajax({
//                 url: url + i.toString(),
//                 type: "GET",
//                 headers: {Authorization: localStorage.getItem("token")},
//                 success: function (result) {
//                     resolve(result);
//                 },
//                 error: function (result) {
//                     if (result.status == 401) {
//                         console.log(result);
//                     }
//                 }
//             });
//         });
//         ajaxData = await clockPromise;
//         valClockIn[i] = parseInt(ajaxData[0].split(",")[0]);
//         valClockOut[i] = parseInt(ajaxData[0].split(",")[1]);
//         if (i < 10) {
//             labels[i] = "0" + i + ":00";
//         } else {
//             labels[i] = i + ":00";
//         }
//     }
//     let max = Math.max.apply(null, valClockIn.concat(valClockOut));
//     let yMax = max + Math.ceil(0.1 * max);
//     let output = [{
//         label: "Clock In",
//         backgroundColor: generateRGBA(49, 247, 66, 0.7),
//         hoverBackgroundColor: generateRGBA(49, 247, 66, 0.9),
//         borderColor: generateRGBA(49, 247, 66, 0.9),
//         data: valClockIn,
//     }, {
//         label: "Clock Out",
//         backgroundColor: generateRGBA(230, 42, 9, 0.7),
//         hoverBackgroundColor: generateRGBA(230, 42, 9, 0.9),
//         borderColor: generateRGBA(230, 42, 9, 0.9),
//         data: valClockOut,
//     }];
//     cvs_bar('#clockToday', labels, output, 'Jam', 'Total Clock', yMax);
// }
//
// clockToday();
//
// // data clock this year
// async function clockThisYear() {
//     let valClockIn = [], valClockOut = [];
//     let labels = ["Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sep", "Okt", "Nov", "Des"];
//     let url = "/api/clock/total/month/";
//     let ajaxData, clockPromise;
//     for (let i = 1; i <= 12; i++) {
//         clockPromise = new Promise(resolve => {
//             $.ajax({
//                 url: url + i.toString(),
//                 type: "GET",
//                 headers: {Authorization: localStorage.getItem("token")},
//                 success: function (result) {
//                     resolve(result);
//                 },
//                 error: function (result) {
//                     if (result.status == 401) {
//                         console.log(result);
//                     }
//                 }
//             });
//         });
//         ajaxData = await clockPromise;
//         valClockIn[i - 1] = parseInt(ajaxData[0].split(",")[0]);
//         valClockOut[i - 1] = parseInt(ajaxData[0].split(",")[1]);
//     }
//     let max = Math.max.apply(null, valClockIn.concat(valClockOut));
//     let yMax = max + Math.ceil(0.1 * max);
//     let output = [{
//         label: "Clock In",
//         backgroundColor: generateRGBA(49, 247, 66, 0.7),
//         hoverBackgroundColor: generateRGBA(49, 247, 66, 0.9),
//         borderColor: generateRGBA(49, 247, 66, 0.9),
//         data: valClockIn,
//     }, {
//         label: "Clock Out",
//         backgroundColor: generateRGBA(230, 42, 9, 0.7),
//         hoverBackgroundColor: generateRGBA(230, 42, 9, 0.9),
//         borderColor: generateRGBA(230, 42, 9, 0.9),
//         data: valClockOut,
//     }];
//     cvs_bar('#clockThisYear', labels, output, 'Bulan', 'Total Clock', yMax);
// }
//
// clockThisYear();
//
// // keterangan this year
// async function keteranganThisYear() {
//     let valKeterangan = [];
//     let labels = ["Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sep", "Okt", "Nov", "Des"];
//     let url = "/api/keterangan/total/month/";
//     let ajaxData, keteranganPromise;
//     for (let i = 1; i <= 12; i++) {
//         keteranganPromise = new Promise(resolve => {
//             $.ajax({
//                 url: url + i.toString(),
//                 type: "GET",
//                 headers: {Authorization: localStorage.getItem("token")},
//                 success: function (result) {
//                     resolve(result);
//                 },
//                 error: function (result) {
//                     if (result.status == 401) {
//                         console.log(result);
//                     }
//                 }
//             });
//         });
//         ajaxData = await keteranganPromise;
//         valKeterangan[i - 1] = parseInt(ajaxData[0]);
//     }
//     let max = Math.max.apply(null, valKeterangan);
//     let yMax = max + Math.ceil(0.1 * max);
//     let output = [{
//         label: "Keterangan Sakit",
//         backgroundColor: generateRGBA(252, 236, 0, 0.7),
//         hoverBackgroundColor: generateRGBA(252, 236, 0, 0.9),
//         borderColor: generateRGBA(252, 236, 0, 0.9),
//         data: valKeterangan,
//     }];
//     cvs_bar('#keteranganThisYear', labels, output, 'Bulan', 'Total Keterangan', yMax);
// }
//
// keteranganThisYear();
//
//
