package com.egiapp.demo.controller;

import com.egiapp.demo.repository.UserRepository;
import com.egiapp.demo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

    @GetMapping("/hcms")
    public String index(Model model) {
        model.addAttribute("title", "Dashboard");
        return "dashboard";
    }

    @GetMapping("/hcms/datapenilaian")
    public String dataPenilaian(Model model) {
        model.addAttribute("title", "Data Penilaian");
        return "rekap_nilai/index";
    }


    @GetMapping("/hcms/dataclock")
    public String index2(Model model) {
        model.addAttribute("title", "Data Clock");
        return "dataClock/index";
    }


    @GetMapping("/hcms/datauser")
    public String dataUser(Model model) {
        model.addAttribute("title", "Data User");
        return "user/data_user";
    }

    @GetMapping("/hcms/hrd")
    public String indexHrd(Model model) {
        model.addAttribute("title", "Dashboard hrd");
        return "dashboard_hrd";
    }

    @GetMapping("/hcms/hrd/rekap_user")
    public String rekapuserHrd(Model model) {
        model.addAttribute("title", "Rekap User");
        return "hrd/rekap_user";
    }

    @GetMapping("/hcms/hrd/create_user")
    public String createUser(Model model) {
        model.addAttribute("title", "Rekap User");
        return "hrd/create_user";
    }


    @GetMapping("/hcms/update/{nik}")
    public String updateUser(Model model, @PathVariable String nik) {
        model.addAttribute("title", "Ubah User");
        User user = userRepository.findUserByRegno(nik);
        model.addAttribute("user", user);
        return "hrd/ubah_user";
    }

    @GetMapping("/hcms/hrd/rekap_nilai")
    public String rekapnilaiHrd(Model model) {
        model.addAttribute("title", "Rekap Nilai");
        return "hrd/rekap_nilai";
    }


    @GetMapping("/hcms/user")
    public String indexUser(Model model) {
        model.addAttribute("title", "Dashboard");
        return "dashboard_user";
    }

    @GetMapping("/hcms/user/penilaian")
    public String penilanan(Model model) {
        model.addAttribute("title", "Penilaian");
        return "penilaian/penilaian";
    }

    @GetMapping("/hcms/penilaian")
    public String penilaianAdmin(Model model) {
        model.addAttribute("title", "Penilaian");
        return "penilaian";
    }

    @GetMapping("/hcms/user/datanilai")
    public String datanilai(Model model) {
        model.addAttribute("title", "Data Nilai");
        return "penilaian/data_penilaian";
    }
}
