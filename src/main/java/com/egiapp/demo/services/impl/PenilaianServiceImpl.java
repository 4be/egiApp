package com.egiapp.demo.services.impl;

import com.egiapp.demo.model.entity.Penilaian;
import com.egiapp.demo.model.response.FailedResponse;
import com.egiapp.demo.model.response.SuccessResponse;
import com.egiapp.demo.model.response.payload.LoginResponse;
import com.egiapp.demo.model.response.payload.NilaiResponse;
import com.egiapp.demo.model.response.payload.PenilaianResponse;
import com.egiapp.demo.model.response.payload.ResponseBest;
import com.egiapp.demo.repository.PenilaianInRepository;
import com.egiapp.demo.services.PenilaianInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PenilaianServiceImpl implements PenilaianInService {

    @Autowired
    PenilaianInRepository penilaianInRepository;


    @Override
    public Object getAllPenilaian() {
        try {
            List<Penilaian> penilaianList = penilaianInRepository.findPenilaianByIdNotNull();
            List<NilaiResponse> penilaianResponseList = new ArrayList<>();

            for (Penilaian penilaian : penilaianList) {
                NilaiResponse penilaianResponse = getUserResponse(penilaian);
                penilaianResponseList.add(penilaianResponse);
            }


//            NilaiResponse nilaiResponse = new NilaiResponse(
//                penilaianList.getId(),
//                penilaianList.getTanggungJawab(),
//                penilaianList.getInisiatif(),
//                penilaianList.getKerjaSama(),
//                penilaianList.getEtikaKomunikasi(),
//                penilaianList.getDisplinKehadiran(),
//                penilaianList.getKerapihan(),
//                penilaianList.getKualitasPekerjaan(),
//                penilaianList.getKecepatanKerja(),
//                penilaianList.getMengetahuiPekerjaan(),
//                penilaianList.getTotalNilai(),
//                penilaianList.getUser_id().getNik(),
//                penilaianList.getNiktujuan()
//            );
            return new SuccessResponse(HttpStatus.OK, "Success", penilaianResponseList);
        } catch (Exception e) {
            return new FailedResponse(HttpStatus.MULTI_STATUS, e.getMessage());
        }
    }


    @Override
    @Transactional
    public Object getbestNilai() {
        try {
            List<Penilaian> penilaianList = penilaianInRepository.carinilaiterbaik();
            List<ResponseBest> penilaianResponseList = new ArrayList<>();

            for (Penilaian penilaian : penilaianList) {
                ResponseBest penilaianResponse = getUserBest(penilaian);
                penilaianResponseList.add(penilaianResponse);
            }

            return new SuccessResponse(HttpStatus.OK, "Success", penilaianResponseList);
        } catch (Exception e) {
            return new FailedResponse(HttpStatus.MULTI_STATUS, e.getMessage());
        }
    }

    @Override
    @Transactional
    public Object getworstNilai() {
        try {
            List<Penilaian> penilaianList = penilaianInRepository.carinilaiterendah();
            List<ResponseBest> penilaianResponseList = new ArrayList<>();

            for (Penilaian penilaian : penilaianList) {
                ResponseBest penilaianResponse = getUserBest(penilaian);
                penilaianResponseList.add(penilaianResponse);
            }

            return new SuccessResponse(HttpStatus.OK, "Success", penilaianResponseList);
        } catch (Exception e) {
            return new FailedResponse(HttpStatus.MULTI_STATUS, e.getMessage());
        }
    }

//    @Override
//    public Object findNilaiByNik(String nik) {
//        try {
//            List<Penilaian> penilaianList = penilaianInRepository.findNilaiByNik(nik);
//
//            List<PenilaianResponse> penilaianResponseList = new ArrayList<>();
//
//            for (Penilaian penilaian : penilaianList) {
//                PenilaianResponse penilaianResponse = new PenilaianResponse(
//                    penilaian.getId(),
//                    penilaian.getUser_id().getNik(),
//                    penilaian.getLeadership(),
//                    penilaian.getMotivasi(),
//                    penilaian.getBenchmarking(),
//                    penilaian.getManagementStrategi(),
//                    penilaian.getPFF(),
//                    penilaian.getAISO9001(),
//                    penilaian.getAISO140001(),
//                    penilaian.getAISO220000(),
//                    penilaian.getAPPE(),
//                    penilaian.getBpjsInHealth(),
//                    penilaian.getBST(),
//                    penilaian.getAOHSAS180001(),
//                    penilaian.getPFSF(),
//                    penilaian.getSTAR5(),
//                    penilaian.getNiktujuan()
//                );
//                penilaianResponseList.add(penilaianResponse);
//            }
//            return new SuccessResponse(HttpStatus.OK, "Success", penilaianResponseList);
//        } catch (Exception e) {
//            return new FailedResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//    }


    public NilaiResponse getUserResponse(Penilaian penilaian) {
        NilaiResponse penilaianResponse = new NilaiResponse(
            penilaian.getId(),
            penilaian.getTanggungJawab(),
            penilaian.getInisiatif(),
            penilaian.getKerjaSama(),
            penilaian.getEtikaKomunikasi(),
            penilaian.getDisplinKehadiran(),
            penilaian.getKerapihan(),
            penilaian.getKualitasPekerjaan(),
            penilaian.getKecepatanKerja(),
            penilaian.getMengetahuiPekerjaan(),
            penilaian.getTotalNilai(),
            penilaian.getUser_id().getNik(),
            penilaian.getNiktujuan()
        );
        return penilaianResponse;
    }

    public ResponseBest getUserBest(Penilaian penilaian) {
        ResponseBest penilaianBestResponse = new ResponseBest(
            penilaian.getId(),
            penilaian.getUser_id().getNik(),
            penilaian.getNiktujuan(),
            penilaian.getUser_id().getDivisi(),
            penilaian.getTanggungJawab(),
            penilaian.getInisiatif(),
            penilaian.getKerjaSama(),
            penilaian.getEtikaKomunikasi(),
            penilaian.getDisplinKehadiran(),
            penilaian.getKerapihan(),
            penilaian.getKualitasPekerjaan(),
            penilaian.getKecepatanKerja(),
            penilaian.getMengetahuiPekerjaan(),
            penilaian.getTotalNilai()
        );
        return penilaianBestResponse;
    }

}
