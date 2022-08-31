if (location.pathname.substr(0, 5) == "/hcms/kd" && localStorage.getItem("token") == null) {
    location.href = "/";
}

if (location.pathname.substr(0, 5) == "/hcms/kd" && localStorage.getItem("role") != "KADEPT") {
    location.href = "/";
}


