package com.egiapp.demo.controller;


import com.egiapp.demo.model.entity.Penilaian;
import com.egiapp.demo.services.PenilaianService;
import com.egiapp.demo.dto.KeteranganData;
import com.egiapp.demo.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/penilaian/")
public class PenilaianController {

    @Autowired
    private PenilaianService keteranganService;

    @PostMapping("/add")
    public ResponseEntity<ResponseData<Penilaian>> addket(@Valid @ModelAttribute @RequestBody KeteranganData keteranganData, Errors errors) {

        ResponseData<Penilaian> responseData = new ResponseData<>();
        Penilaian penilaian = new Penilaian();
        Date date = new Date();


        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
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

        responseData.setStatus(true);
        responseData.setMessages(responseData.getMessages());
        responseData.setPayload(keteranganService.create(penilaian));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

    @GetMapping("/list")
    public Iterable<Penilaian> findAll() {
        return keteranganService.findAll();
    }

    @GetMapping("/list/id/{id}")
    public Penilaian findOne(@PathVariable("id") Long id) {
        return keteranganService.findByid(id);
    }

    @DeleteMapping("/delete/id/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        keteranganService.removeOne(id);
    }

    @GetMapping("/list/desc/{id}")
    public List<Penilaian> getKetDesc(@PathVariable("id") Long id){
        return keteranganService.findKesByIdDesc(id);
    }

    @GetMapping("/team/{team}")
    public List<Penilaian> getKetTeam(@PathVariable("team")String team){
        return keteranganService.findKesByTeam(team);
    }

    @GetMapping("/total/month/{month}")
    public List<String> getTotalKesMonth(@PathVariable("month")Long month){
        return keteranganService.findTotalKesMonth(month);
    }

}
