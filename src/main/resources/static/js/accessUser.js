if (location.pathname.substr(0, 5) == "/user" && localStorage.getItem("token") == null) {
    location.href = "/";
}
