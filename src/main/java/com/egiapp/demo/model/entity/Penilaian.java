package com.egiapp.demo.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "tbl_penilaian")
public class Penilaian implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String leadership;

    @Column(length = 300)
    private String motivasi;

    @Column(length = 300)
    private String benchmarking;

    @Column(length = 300)
    private String managementStrategi;

    @Column(length = 300)
    private String PFF;

    @Column(length = 300)
    private String PFSF;

    @Column(length = 300)
    private String AISO9001;

    @Column(length = 300)
    private String AISO140001;

    @Column(length = 300)
    private String AOHSAS180001;

    @Column(length = 300)
    private String APPE;

    @Column(length = 300)
    private String bpjsInHealth;

    @Column(length = 300)
    private String AISO220000;

    @Column(length = 300)
    private String BST;

    @Column(length = 300)
    private String STAR5;


    @ManyToOne
    private User user_id;

    private String niktujuan;

    public Penilaian(Long id, String leadership, String motivasi, String benchmarking, String managementStrategi, String PFF, String PFSF, String AISO9001, String AISO140001, String AOHSAS180001, String APPE, String bpjsInHealth, String AISO220000, String BST, String STAR5, User user_id, String niktujuan) {
        this.id = id;
        this.leadership = leadership;
        this.motivasi = motivasi;
        this.benchmarking = benchmarking;
        this.managementStrategi = managementStrategi;
        this.PFF = PFF;
        this.PFSF = PFSF;
        this.AISO9001 = AISO9001;
        this.AISO140001 = AISO140001;
        this.AOHSAS180001 = AOHSAS180001;
        this.APPE = APPE;
        this.bpjsInHealth = bpjsInHealth;
        this.AISO220000 = AISO220000;
        this.BST = BST;
        this.STAR5 = STAR5;
        this.user_id = user_id;
        this.niktujuan = niktujuan;
    }
}
