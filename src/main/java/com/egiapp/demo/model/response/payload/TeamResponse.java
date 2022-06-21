package com.egiapp.demo.model.response.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TeamResponse {

    private Long id;
    private String nama;
    private String nik;
    private String alamat;
    private String tanggal_lahir;
    private String email;
    private String divisi;
    private String nikmanager;
    private Boolean isaktif;
    private String role;

}
