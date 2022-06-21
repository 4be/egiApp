if (location.pathname.substr(0, 5) == "/hcms/user" && localStorage.getItem("token") == null) {
    location.href = "/";
}

if (location.pathname.substr(0, 5) == "/hcms" && localStorage.getItem("role") != "PEGAWAI" || "SPV" || "GL") {
    location.href = "/";
}
