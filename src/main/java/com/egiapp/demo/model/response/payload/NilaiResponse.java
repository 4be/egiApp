package com.egiapp.demo.model.response.payload;

import com.egiapp.demo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NilaiResponse {

    private Long id;

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

    private String nikpenilai;

    private String niktujuan;

}
