package com.egiapp.demo.dto;


import com.egiapp.demo.model.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;


@Getter
@Setter
public class KeteranganData {

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

    private User user_id;


}
