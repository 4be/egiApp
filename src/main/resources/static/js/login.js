$(document).ready(function () {
    $("#sigagal1").hide();
    $("#sigagal2").hide();
});

$("#login").click(function () {
    var user = "{" +
        "\"username\" : \"" + $("#username").val() + "\"," +
        "\"password\" : \"" + $("#password").val() + "\"" +
        "}";

    $.ajax({
        url: '/api/login/',
        type: 'POST',
        data: user,
        dataType: 'json',
        contentType: 'application/json',
        success: function (result) {

            if (result.status != 200) {
                $("#sigagal1").show();
                setTimeout(function () {
                    location.reload();
                }, 2000)
            }

            if (result.status == 200) {
                if (result.data.role == "PENINJAU") {
                    localStorage.setItem("token", result.data.token);
                    localStorage.setItem("nik", result.data.nik);
                    localStorage.setItem("nama", result.data.nama);
                    localStorage.setItem("role", result.data.role);
                    localStorage.setItem("nikmanager", result.data.nikmanager);
                    localStorage.setItem("user_id", result.data.id);
                    location.href = "/hcms/";

                } else if (result.data.role == "KADEPT") {
                    localStorage.setItem("token", result.data.token);
                    localStorage.setItem("nik", result.data.nik);
                    localStorage.setItem("nama", result.data.nama);
                    localStorage.setItem("role", result.data.role);
                    localStorage.setItem("nikmanager", result.data.nikmanager);
                    localStorage.setItem("user_id", result.data.id);
                    location.href = "/hcms/kd";

                } else if (result.data.role == "HRD") {
                    localStorage.setItem("token", result.data.token);
                    localStorage.setItem("nama", result.data.nama);
                    localStorage.setItem("role", result.data.role);
                    location.href = "/hcms/hrd/";
                    let json = result.data;
                    json.forEach((nilai) => {
                        let keys = Object.keys(nilai);
                        keys.forEach((isi) => {
                            console.log(isi);
                        })
                        console.log(nilai)
                    })
                } else if (result.data.role == 'GL' || 'SPV' || 'PEGAWAI') {
                    localStorage.setItem("token", result.data.token);
                    localStorage.setItem("nik", result.data.nik);
                    localStorage.setItem("nama", result.data.nama);
                    localStorage.setItem("role", result.data.role);
                    localStorage.setItem("nikmanager", result.data.nikmanager);
                    localStorage.setItem("user_id", result.data.id);
                    location.href = "/hcms/user/";


                    let json = result.data;
                    json.forEach((nilai) => {
                        let keys = Object.keys(nilai);
                        keys.forEach((isi) => {
                            console.log(isi);
                        })
                        console.log(nilai)
                    })

                } else {
                    $("#sigagal2").show();
                    setTimeout(function () {
                        location.reload();
                    }, 2000)
                }
            } else {
                $("#sigagal1").show();
                setTimeout(function () {
                    location.reload();
                }, 2000)
            }
        }
        ,
        error: function (result) {
            if (result.status == 401) {
                location.href = "/";
            }
        }
    });
})
;
