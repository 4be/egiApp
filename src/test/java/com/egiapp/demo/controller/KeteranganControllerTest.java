package com.egiapp.demo.controller;

import com.egiapp.demo.model.entity.Penilaian;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.egiapp.demo.model.repos.KeteranganRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class KeteranganControllerTest {

    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KeteranganRepo ketRepo;

    @Test
    @WithMockUser(authorities = "EMPLOYEE")
    @DisplayName("GET /api/keterangan/list ambil data keterangan")
    public void findAll() throws Exception {
        List<Penilaian> listKet = new ArrayList();
        listKet.add(new Penilaian());
        listKet.add(new Penilaian());
        Mockito.when(ketRepo.findAll()).thenReturn(listKet);
        String url = "/api/keterangan/list";
        mockMvc.perform(get(url)).andExpect(status().isOk());
    }
}



