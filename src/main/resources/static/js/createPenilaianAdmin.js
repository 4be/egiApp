const userid = localStorage.getItem("user_id");
$(document).ready(function () {
    $("#sisukses").hide();
    $("#sigagal").hide();
});


$("#submit").click(function () {
    var confir = confirm("Apakah anda yakin akan melakukan submit ?");
    if (confir == true) {
        var form = new FormData();
        form.append("user_id", userid);
        form.append("tanggungJawab", $("#tanggungJawab").val());
        form.append("inisiatif", $("#inisiatif").val());
        form.append("KerjaSama", $("#KerjaSama").val());
        form.append("etikaKomunikasi", $("#etikaKomunikasi").val());
        form.append("displinKehadiran", $("#displinKehadiran").val());
        form.append("kerapihan", $("#kerapihan").val());
        form.append("kualitasPekerjaan", $("#kualitasPekerjaan").val());
        form.append("kecepatanKerja", $("#kecepatanKerja").val());
        form.append("keterampilan", $("#keterampilan").val());
        form.append("mengetahuiPekerjaan", $("#mengetahuiPekerjaan").val());
        form.append("niktujuan", $("#niktujuan").val());

        $.ajax({
            url: '/api/penilaian/add/',
            method: "POST",
            timeout: 0,
            headers: {Authorization: localStorage.getItem("token")},
            processData: false,
            mimeType: "multipart/form-data",
            contentType: false,
            data: form,
            success: function (result) {
                $("#sisukses").show();
                setTimeout(function () {
                    location.reload();
                }, 1000);
            },
            error: function (result) {
                $("#sigagal").show();
                setTimeout(function () {
                    location.reload();
                }, 1000);
            }
        });
    }
});

