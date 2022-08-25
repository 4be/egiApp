if (location.pathname.substr(0, 5) == "/hcms/hrd" && localStorage.getItem("token") == null) {
    location.href = "/";
}

if (location.pathname.substr(0, 5) == "/hcms/hrd" && localStorage.getItem("role") != "HRD") {
    location.href = "/";
}


