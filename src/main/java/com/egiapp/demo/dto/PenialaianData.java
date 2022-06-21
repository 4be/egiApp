package com.egiapp.demo.dto;


import com.egiapp.demo.model.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.ManyToOne;


@Getter
@Setter
public class PenialaianData {

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

    private User user_id;

    private String niktujuan;


}
