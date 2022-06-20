package com.egiapp.demo.model.response.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PenilaianResponse {


    private Long id;

    private String nikpenilai;

    private String leadership;

    private String motivasi;

    private String benchmarking;

    private String managementStrategi;

    private String PFF;

    private String PFSF;

    private String AISO9001;

    private String AISO140001;

    private String AOHSAS180001;

    private String APPE;

    private String bpjsInHealth;

    private String AISO220000;

    private String BST;

    private String STAR5;

    private String niktujuan;


    public PenilaianResponse(Long id, String nikpenilai,String leadership, String motivasi, String benchmarking, String managementStrategi, String PFF, String PFSF, String AISO9001, String AISO140001, String AOHSAS180001, String APPE, String bpjsInHealth, String AISO220000, String BST, String STAR5, String niktujuan) {
        this.id = id;
        this.nikpenilai = nikpenilai;
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
        this.niktujuan = niktujuan;
    }

    public PenilaianResponse() {

    }
}
