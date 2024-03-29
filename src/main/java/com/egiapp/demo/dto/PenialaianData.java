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

    private Long tanggungJawab;

    private Long inisiatif;

    private Long KerjaSama; //loyalitas

    private Long etikaKomunikasi;

    private Long displinKehadiran;

    private Long kerapihan;

    private Long kualitasPekerjaan;

    private Long kecepatanKerja;

    private Long mengetahuiPekerjaan;

    private Long bobot;

    private Double totalNilai;

    private User user_id;

    private String niktujuan;


}
