package com.egiapp.demo.model.response.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginResponse {

    private Long id;
    private String nama;
    private String nik;
    private String nikmanager;
    private String alamat;
    private String tanggalLahir;
    private String email;
    private String role;
    private String token;

}
