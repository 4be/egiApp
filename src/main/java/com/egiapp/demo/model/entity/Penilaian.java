package com.egiapp.demo.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "tbl_penilaian")
public class Penilaian implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long id;

    @Column(length = 300)
    private Long tanggungJawab;

    @Column(length = 300)
    private Long inisiatif;

    @Column(length = 300)
    private Long KerjaSama;

    @Column(length = 300)
    private Long etikaKomunikasi;

    @Column(length = 300)
    private Long displinKehadiran;

    @Column(length = 300)
    private Long kerapihan;

    @Column(length = 300)
    private Long kualitasPekerjaan;

    @Column(length = 300)
    private Long kecepatanKerja;

    @Column(length = 300)
    private Long mengetahuiPekerjaan;

    @Column(length = 300)
    private Long bobot;

    @Column(length = 40)
    private Double totalNilai;


    @ManyToOne
    private User user_id;

    private String niktujuan;


    public Penilaian(Long id, Long tanggungJawab, Long inisiatif, Long kerjaSama, Long etikaKomunikasi, Long displinKehadiran, Long kerapihan, Long kualitasPekerjaan, Long kecepatanKerja, Long mengetahuiPekerjaan, Long bobot, Double totalNilai, User user_id, String niktujuan) {
        this.id = id;
        this.tanggungJawab = tanggungJawab;
        this.inisiatif = inisiatif;
        this.KerjaSama = kerjaSama;
        this.etikaKomunikasi = etikaKomunikasi;
        this.displinKehadiran = displinKehadiran;
        this.kerapihan = kerapihan;
        this.kualitasPekerjaan = kualitasPekerjaan;
        this.kecepatanKerja = kecepatanKerja;
        this.mengetahuiPekerjaan = mengetahuiPekerjaan;
        this.bobot = bobot;
        this.totalNilai = totalNilai;
        this.user_id = user_id;
        this.niktujuan = niktujuan;
    }
}
