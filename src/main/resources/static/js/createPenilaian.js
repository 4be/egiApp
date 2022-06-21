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
        form.append("leadership", $("#leadership").val());
        form.append("motivasi", $("#motivasi").val());
        form.append("benchmarking", $("#benchmarking").val());
        form.append("managementStrategi", $("#managementStrategi").val());
        form.append("PFF", $("#PFF").val());
        form.append("PFSF", $("#PFSF").val());
        form.append("AISO9001", $("#AISO9001").val());
        form.append("AISO140001", $("#AISO140001").val());
        form.append("AOHSAS180001", $("#AOHSAS180001").val());
        form.append("APPE", $("#APPE").val());
        form.append("bpjsInHealth", $("#bpjsInHealth").val());
        form.append("AISO220000", $("#AISO220000").val());
        form.append("BST", $("#BST").val());
        form.append("STAR5", $("#STAR5").val());
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
                if (result.status == 200) {
                    $("#sisukses").show();
                    setTimeout(function () {
                        location.href = "/";
                    }, 1000);
                } else {
                    $("#sigagal").show();
                    setTimeout(function () {
                        location.reload();
                    }, 1000)
                }
            },
            error: function (result) {
                if (result.status == 401) {
                    location.href = "/";
                }
            }
        });
    }
});

