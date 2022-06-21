package com.egiapp.demo.model.response.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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


    public PenilaianResponse() {

    }

}
