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

    @PostMapping(value = "/add", consumes = "multipart/form-data")
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

        penilaian.setLeadership(keteranganData.getLeadership());
        penilaian.setMotivasi(keteranganData.getMotivasi());
        penilaian.setBenchmarking(keteranganData.getBenchmarking());
        penilaian.setManagementStrategi(keteranganData.getManagementStrategi());
        penilaian.setPFF(keteranganData.getPFF());
        penilaian.setPFSF(keteranganData.getPFSF());
        penilaian.setAISO9001(keteranganData.getAISO9001());
        penilaian.setAISO140001(keteranganData.getAISO140001());
        penilaian.setAOHSAS180001(keteranganData.getAOHSAS180001());
        penilaian.setAPPE(keteranganData.getAPPE());
        penilaian.setBpjsInHealth(keteranganData.getBpjsInHealth());
        penilaian.setAISO220000(keteranganData.getAISO220000());
        penilaian.setBST(keteranganData.getBST());
        penilaian.setSTAR5(keteranganData.getSTAR5());
        penilaian.setNiktujuan(keteranganData.getNiktujuan());
        penilaian.setUser_id(keteranganData.getUser_id());

        keteranganService.create(penilaian);
        penilaianResponse.setLeadership(keteranganData.getLeadership());
//        penilaianResponse.setNikpenilai(keteranganData.getUser_id().getNik());
        penilaianResponse.setMotivasi(keteranganData.getMotivasi());
        penilaianResponse.setBenchmarking(keteranganData.getBenchmarking());
        penilaianResponse.setManagementStrategi(keteranganData.getManagementStrategi());
        penilaianResponse.setPFF(keteranganData.getPFF());
        penilaianResponse.setPFSF(keteranganData.getPFSF());
        penilaianResponse.setAISO9001(keteranganData.getAISO9001());
        penilaianResponse.setAISO140001(keteranganData.getAISO140001());
        penilaianResponse.setAOHSAS180001(keteranganData.getAOHSAS180001());
        penilaianResponse.setAPPE(keteranganData.getAPPE());
        penilaianResponse.setBpjsInHealth(keteranganData.getBpjsInHealth());
        penilaianResponse.setAISO220000(keteranganData.getAISO220000());
        penilaianResponse.setBST(keteranganData.getBST());
        penilaianResponse.setSTAR5(keteranganData.getSTAR5());
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
