const userid = localStorage.getItem("user_id");
$(document).ready(function () {
    $("#sisukses").hide();
    $("#sigagal").hide();
});

$("#btnSubmit").click(function () {
    var data = new FormData();
    data.append("user_id", "" + $("#user_id").val() + "\"");
    data.append("leadership", "" + $("#leadership").val() + "\"");
    data.append("motivasi", "" + $("#motivasi").val() + "\"");
    data.append("benchmarking", "" + $("#benchmarking").val() + "\"");
    data.append("managementStrategi", "" + $("#managementStrategi").val() + "\"");
    data.append("PFF", "" + $("#PFF").val() + "\"");
    data.append("PFSF", "" + $("#PFSF").val() + "\"");
    data.append("AISO9001", "" + $("#AISO9001").val() + "\"");
    data.append("AISO140001", "" + $("#AISO140001").val() + "\"");
    data.append("AOHSAS180001", "" + $("#AOHSAS180001").val() + "\"");
    data.append("APPE", "" + $("#APPE").val() + "\"");
    data.append("bpjsInHealth", "" + $("#bpjsInHealth").val() + "\"");
    data.append("AISO220000", "" + $("#AISO220000").val() + "\"");
    data.append("BST", "" + $("#BST").val() + "\"");
    data.append("STAR5", "" + $("#STAR5").val() + "\"");
    data.append("niktujuan", "" + $("#niktujuan").val() + "\"");

    $.ajax({
        url: '/api/penilaian/add',
        type: 'POST',
        data: data,
        headers: {Authorization: localStorage.getItem("token")},
        success: function (data) {
            if (data.status == 200) {
                $("#sisukses").show();
                setTimeout(function () {
                    location.href = "/";
                }, 1000);
            }
        },
        error: function (result) {
            if (result.status == 401) {
                alert(result.responseJSON.message);
                localStorage.removeItem("token");
                location.href = "/";
            }
        }
    });
});


$("#submit").click(function () {
    var confir = confirm("Apakah anda yakin akan melakukan submit ?");
    if (confir == true) {
        var user = "{" +
            "\"user_id\" : \"" + $("#user_id").val() + "\"," +
            "\"leadership\" : \"" + $("#leadership").val() + "\"," +
            "\"motivasi\" : \"" + $("#motivasi").val() + "\"," +
            "\"benchmarking\" : \"" + $("#benchmarking").val() + "\"," +
            "\"managementStrategi\" : \"" + $("#managementStrategi").val() + "\"," +
            "\"PFF\" : \"" + $("#PFF").val() + "\"," +
            "\"PFSF\" : \"" + $("#PFSF").val() + "\"," +
            "\"AISO9001\" : \"" + $("#AISO9001").val() + "\"," +
            "\"AISO220000\": \"" + $("#AISO220000").val() + "\"," +
            "\"BST\" : \"" + $("#BST").val() + "\"" +
            "\"STAR5\" : \"" + $("#STAR5").val() + "\"" +
            "\"niktujuan\" : \"" + $("#niktujuan").val() + "\"" +
            "}";

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/api/penilaian/add",
            data: user,
            cache: false,
            contentType: false,
            timeout: 800000,
            headers: {Authorization: localStorage.getItem("token")},
            success: function (result) {
                if (result.status == 200) {
                    $("#sisukses").show();
                    setTimeout(function () {
                        location.href = "/hcms/user/penilaian";
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

