package com.egiapp.demo.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
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
}
