package com.egiapp.demo.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
    private String pemecahanMasalah;

    @Column(length = 300)
    private String inisiatif;

    @Column(length = 300)
    private String loyalitas;

    @Column(length = 300)
    private String motivasi;

    @Column(length = 300)
    private String etikaKomunikasi;

    @Column(length = 300)
    private String displinKehadiran;

    @Column(length = 300)
    private String kerapihan;

    @Column(length = 300)
    private String tanggungJawab;

    @Column(length = 300)
    private String kualitasPekerjaan;

    @Column(length = 300)
    private String keterampilan;

    @Column(length = 300)
    private String kecepatanKerja;

    @Column(length = 300)
    private String mengetahuiPekerjaan;

    @Column(length = 40)
    private String categoryname;

    @ManyToOne
    private User user_id;

    private String niktujuan;

    public Penilaian(Long id, String pemecahanMasalah, String inisiatif, String loyalitas, String motivasi, String etikaKomunikasi, String displinKehadiran, String kerapihan, String tanggungJawab, String kualitasPekerjaan, String keterampilan, String kecepatanKerja, String mengetahuiPekerjaan, String categoryname, User user_id, String niktujuan) {
        this.id = id;
        this.pemecahanMasalah = pemecahanMasalah;
        this.inisiatif = inisiatif;
        this.loyalitas = loyalitas;
        this.motivasi = motivasi;
        this.etikaKomunikasi = etikaKomunikasi;
        this.displinKehadiran = displinKehadiran;
        this.kerapihan = kerapihan;
        this.tanggungJawab = tanggungJawab;
        this.kualitasPekerjaan = kualitasPekerjaan;
        this.keterampilan = keterampilan;
        this.kecepatanKerja = kecepatanKerja;
        this.mengetahuiPekerjaan = mengetahuiPekerjaan;
        this.categoryname = categoryname;
        this.user_id = user_id;
        this.niktujuan = niktujuan;
    }
}
