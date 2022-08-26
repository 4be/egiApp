package com.egiapp.demo.controller;


import com.egiapp.demo.model.entity.ERole;
import com.egiapp.demo.model.entity.Penilaian;
import com.egiapp.demo.model.entity.Role;
import com.egiapp.demo.model.entity.User;
import com.egiapp.demo.model.response.payload.PenilaianResponse;
import com.egiapp.demo.repository.RoleRepository;
import com.egiapp.demo.repository.UserRepository;
import com.egiapp.demo.services.PenilaianInService;
import com.egiapp.demo.services.PenilaianService;
import com.egiapp.demo.dto.PenialaianData;
import com.egiapp.demo.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("api/penilaian/")
public class PenilaianController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private PenilaianService keteranganService;
    @Autowired
    private PenilaianInService penilaianInService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseData<PenilaianResponse>> addket(@Valid PenialaianData keteranganData, Errors errors) {

        ResponseData<PenilaianResponse> responseData = new ResponseData<>();
        Penilaian penilaian = new Penilaian();
        PenilaianResponse penilaianResponse = new PenilaianResponse();
        Date date = new Date();

        Integer total = null;

        User user = userRepository.findUserByNik(keteranganData.getUser_id().getNik());

        String jabatan = user.getRoles().iterator().next().getRolename().toString();


        Long satsetTanggungJawab = keteranganData.getTanggungJawab();
        Long satsetInisiatif = keteranganData.getInisiatif();
        Long satsetKerjaSama = keteranganData.getKerjaSama();
        Long satsetEtikaKomunikasi = keteranganData.getEtikaKomunikasi();
        Long satsetDisplinKehadiran = keteranganData.getDisplinKehadiran();
        Long satsetKerapihan = keteranganData.getKerapihan();
        Long satsetKualitasPekerjaan = keteranganData.getKualitasPekerjaan();
        Long satsetKecepatanKerja = keteranganData.getKecepatanKerja();
        Long satsetMengetahuiPekerjaan = keteranganData.getMengetahuiPekerjaan();
//        Long satsetBobot = keteranganData.getBobot();
//        Long satsetTotalNilai = keteranganData.getTotalNilai();

        double bobotTanggungJawab = 0.08;
        double bobotInisiatif = 0.12;
        double bobotKerjaSama = 0.08;
        double bobotEtikaKomunikasi = 0.10;
        double bobotDisplinKehadiran = 0.12;
        double bobotKerapihan = 0.12;
        double bobotKualitasPekerjaan = 0.10;
        double bobotKecepatanKerja = 0.12;
        double bobotMengetahuiPekerjaan = 0.16;


        Double NilaiAkhir =
            (satsetTanggungJawab * bobotTanggungJawab) +
                (satsetInisiatif * bobotInisiatif) +
                (satsetKerjaSama * bobotKerjaSama) +
                (satsetEtikaKomunikasi * bobotEtikaKomunikasi) +
                (satsetDisplinKehadiran * bobotDisplinKehadiran) +
                (satsetKerapihan * bobotKerapihan) +
                (satsetKualitasPekerjaan * bobotKualitasPekerjaan) +
                (satsetKecepatanKerja * bobotKecepatanKerja) +
                (satsetMengetahuiPekerjaan * bobotMengetahuiPekerjaan);

        String finalscore = String.format("%.2f", NilaiAkhir);

        System.out.println("hasil nilai = " + finalscore);
        System.out.println("hasil nilai = " + Double.valueOf(finalscore));

        penilaian.setTanggungJawab(keteranganData.getTanggungJawab());
        penilaian.setInisiatif(keteranganData.getInisiatif());
        penilaian.setKerjaSama(keteranganData.getKerjaSama());
        penilaian.setEtikaKomunikasi(keteranganData.getEtikaKomunikasi());
        penilaian.setDisplinKehadiran(keteranganData.getDisplinKehadiran());
        penilaian.setKerapihan(keteranganData.getKerapihan());
        penilaian.setKualitasPekerjaan(keteranganData.getKualitasPekerjaan());
        penilaian.setKecepatanKerja(keteranganData.getKecepatanKerja());
        penilaian.setMengetahuiPekerjaan(keteranganData.getMengetahuiPekerjaan());
        penilaian.setTotalNilai(Double.valueOf(finalscore));
        penilaian.setUser_id(keteranganData.getUser_id());
        penilaian.setNiktujuan(keteranganData.getNiktujuan());

        keteranganService.create(penilaian);


        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.setMessages(error.getDefaultMessage());
            }
            responseData.setStatus(200);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }


        penilaianResponse.setId(penilaian.getId());
        penilaianResponse.setTanggungJawab(keteranganData.getTanggungJawab());
        penilaianResponse.setInisiatif(keteranganData.getInisiatif());
        penilaianResponse.setKerjaSama(keteranganData.getKerjaSama());
        penilaianResponse.setEtikaKomunikasi(keteranganData.getEtikaKomunikasi());
        penilaianResponse.setDisplinKehadiran(keteranganData.getDisplinKehadiran());
        penilaianResponse.setKerapihan(keteranganData.getKerapihan());
        penilaianResponse.setKualitasPekerjaan(keteranganData.getKualitasPekerjaan());
        penilaianResponse.setKecepatanKerja(keteranganData.getKecepatanKerja());
        penilaianResponse.setMengetahuiPekerjaan(keteranganData.getMengetahuiPekerjaan());
        penilaianResponse.setTotalNilai(Double.valueOf(finalscore));
        penilaianResponse.setNikPenilai(user.getNik());
        penilaianResponse.setNiktujuan(keteranganData.getNiktujuan());
        responseData.setStatus(200);
        responseData.setMessages("success");
        responseData.setData(penilaianResponse);
        return ResponseEntity.ok().body(responseData);
    }

    @GetMapping("/list/")
    public ResponseEntity<Object> getAllPenilaian() {
        Object data = penilaianInService.getAllPenilaian();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/list/best/")
    public ResponseEntity<Object> getbestnilai() {
        Object data = penilaianInService.getbestNilai();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/list/worst/")
    public ResponseEntity<Object> getworstNilai() {
        Object data = penilaianInService.getworstNilai();
        return ResponseEntity.ok(data);
    }
//
//    @GetMapping("/nik/{nik}")
//    public ResponseEntity<Object> getPenilaianByNik(@PathVariable String nik) {
//        Object data = penilaianInService.findNilaiByNik(nik);
//        return ResponseEntity.ok(data);
//    }


    @GetMapping("/list/id/{id}")
    public Penilaian findOne(@PathVariable("id") Long id) {
        return keteranganService.findByid(id);
    }

    @DeleteMapping("/delete/id/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        keteranganService.removeOne(id);
    }


    public Set<Role> getRole(String role) {
        Set<Role> roles = new HashSet<>();
        switch (role) {
            case "PENINJAU":
                Role adminRole = roleRepository.findByRolename(ERole.PENINJAU);
                roles.add(adminRole);
                break;
            case "GL":
                Role GLRole = roleRepository.findByRolename(ERole.GL);
                roles.add(GLRole);
                break;
            case "KADEPT":
                Role KDRole = roleRepository.findByRolename(ERole.KADEPT);
                roles.add(KDRole);
                break;
            case "HRD":
                Role HRDRole = roleRepository.findByRolename(ERole.HRD);
                roles.add(HRDRole);
                break;
            default:
                Role defRole = roleRepository.findByRolename(ERole.PEGAWAI);
                roles.add(defRole);
        }
        return roles;
    }

}
