package com.egiapp.demo.services.impl;

import com.egiapp.demo.model.entity.Penilaian;
import com.egiapp.demo.model.response.FailedResponse;
import com.egiapp.demo.model.response.SuccessResponse;
import com.egiapp.demo.model.response.payload.PenilaianResponse;
import com.egiapp.demo.repository.PenilaianInRepository;
import com.egiapp.demo.services.PenilaianInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PenilaianServiceImpl implements PenilaianInService {

    @Autowired
    PenilaianInRepository penilaianInRepository;


    @Override
    public Object getAllPenilaian() {
        try {
            List<Penilaian> penilaianList = penilaianInRepository.findPenilaianByIdNotNull();
            List<PenilaianResponse> penilaianResponseList = new ArrayList<>();

            for (Penilaian penilaian : penilaianList) {
                PenilaianResponse penilaianResponse = getUserResponse(penilaian);
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


    public PenilaianResponse getUserResponse(Penilaian penilaian) {
        PenilaianResponse penilaianResponse = new PenilaianResponse(
            penilaian.getId(),
            penilaian.getPemecahanMasalah(),
            penilaian.getInisiatif(),
            penilaian.getLoyalitas(),
            penilaian.getMotivasi(),
            penilaian.getEtikaKomunikasi(),
            penilaian.getDisplinKehadiran(),
            penilaian.getKerapihan(),
            penilaian.getTanggungJawab(),
            penilaian.getKualitasPekerjaan(),
            penilaian.getKeterampilan(),
            penilaian.getKecepatanKerja(),
            penilaian.getMengetahuiPekerjaan(),
            penilaian.getCategoryname(),
            penilaian.getUser_id().getNik(),
            penilaian.getNiktujuan()
        );
        return penilaianResponse;
    }
}
