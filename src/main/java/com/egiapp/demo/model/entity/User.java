package com.egiapp.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String username;

    @Column(length = 100)
    private String nama;

    @Column(length = 20)
    private String regno;

    @Column(length = 20)
    private String dept;

    @Column(length = 100)
    private String alamat;

    @Column(length = 20)
    private String tanggalLahir;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String password;

    @Column(length = 100)
    private String divisi;

    @Column(length = 100)
    private String nikManager;

    private Boolean isaktif;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tbl_user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public User(String username, String nama, String regno, String dept, String alamat, String tanggalLahir, String email, String password, String divisi, String nikManager, Boolean isaktif, Set<Role> roles) {
        this.username = username;
        this.nama = nama;
        this.regno = regno;
        this.dept = dept;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.email = email;
        this.password = password;
        this.divisi = divisi;
        this.nikManager = nikManager;
        this.isaktif = isaktif;
        this.roles = roles;
    }

}
