package com.egiapp.demo.model.response.payload;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ResponseBest {
    private Long id;

    private String nikpenilai;

    private String niktujuan;

    private String nama;

    private String divisi;

    private Long tanggungJawab;

    private Long inisiatif;

    private Long KerjaSama;

    private Long etikaKomunikasi;

    private Long displinKehadiran;

    private Long kerapihan;

    private Long kualitasPekerjaan;

    private Long kecepatanKerja;

    private Long mengetahuiPekerjaan;

    private Double totalNilai;

}
