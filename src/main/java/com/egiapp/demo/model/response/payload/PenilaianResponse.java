package com.egiapp.demo.model.response.payload;

import com.egiapp.demo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
public class PenilaianResponse {


    private Long id;

    private String pemecahanMasalah;

    private String inisiatif;

    private String loyalitas;

    private String motivasi;

    private String etikaKomunikasi;

    private String displinKehadiran;

    private String kerapihan;

    private String tanggungJawab;

    private String kualitasPekerjaan;

    private String keterampilan;

    private String kecepatanKerja;

    private String mengetahuiPekerjaan;

    private String categoryname;

    private String user_id;

    private String niktujuan;


    public PenilaianResponse() {

    }

}
