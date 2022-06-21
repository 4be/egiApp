package com.egiapp.demo.controller;


import com.egiapp.demo.model.entity.Penilaian;
import com.egiapp.demo.model.entity.User;
import com.egiapp.demo.model.response.payload.PenilaianResponse;
import com.egiapp.demo.model.response.payload.UserResponse;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/penilaian/")
public class PenilaianController {


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


        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.setMessages(error.getDefaultMessage());
            }
            responseData.setStatus(200);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        penilaian.setPemecahanMasalah(keteranganData.getPemecahanMasalah());
        penilaian.setMotivasi(keteranganData.getMotivasi());
        penilaian.setInisiatif(keteranganData.getInisiatif());
        penilaian.setLoyalitas(keteranganData.getLoyalitas());
        penilaian.setMotivasi(keteranganData.getMotivasi());
        penilaian.setEtikaKomunikasi(keteranganData.getEtikaKomunikasi());
        penilaian.setDisplinKehadiran(keteranganData.getDisplinKehadiran());
        penilaian.setKerapihan(keteranganData.getKerapihan());
        penilaian.setTanggungJawab(keteranganData.getTanggungJawab());
        penilaian.setKualitasPekerjaan(keteranganData.getKualitasPekerjaan());
        penilaian.setKeterampilan(keteranganData.getKeterampilan());
        penilaian.setKecepatanKerja(keteranganData.getKecepatanKerja());
        penilaian.setMengetahuiPekerjaan(keteranganData.getMengetahuiPekerjaan());
        penilaian.setCategoryname(keteranganData.getCategoryname());
        penilaian.setNiktujuan(keteranganData.getNiktujuan());
        penilaian.setUser_id(keteranganData.getUser_id());
        penilaian.setCategoryname(keteranganData.getCategoryname());

        keteranganService.create(penilaian);
        penilaianResponse.setId(penilaian.getId());
        penilaianResponse.setPemecahanMasalah(keteranganData.getPemecahanMasalah());
        penilaianResponse.setMotivasi(keteranganData.getMotivasi());
        penilaianResponse.setInisiatif(keteranganData.getInisiatif());
        penilaianResponse.setLoyalitas(keteranganData.getLoyalitas());
        penilaianResponse.setMotivasi(keteranganData.getMotivasi());
        penilaianResponse.setEtikaKomunikasi(keteranganData.getEtikaKomunikasi());
        penilaianResponse.setDisplinKehadiran(keteranganData.getDisplinKehadiran());
        penilaianResponse.setKerapihan(keteranganData.getKerapihan());
        penilaianResponse.setTanggungJawab(keteranganData.getTanggungJawab());
        penilaianResponse.setKualitasPekerjaan(keteranganData.getKualitasPekerjaan());
        penilaianResponse.setKeterampilan(keteranganData.getKeterampilan());
        penilaianResponse.setKecepatanKerja(keteranganData.getKecepatanKerja());
        penilaianResponse.setMengetahuiPekerjaan(keteranganData.getMengetahuiPekerjaan());
        penilaianResponse.setCategoryname(keteranganData.getCategoryname());
        penilaianResponse.setNiktujuan(keteranganData.getNiktujuan());
        penilaianResponse.setUser_id(keteranganData.getUser_id().getNik());
        penilaianResponse.setCategoryname(keteranganData.getCategoryname());

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


}
