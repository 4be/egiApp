package com.egiapp.demo.model.response.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NilakuResponse {
    private String id;

    private String nikpenilai;

    private String jabatan;

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
