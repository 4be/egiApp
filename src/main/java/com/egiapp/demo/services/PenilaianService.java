package com.egiapp.demo.services;


import com.egiapp.demo.model.entity.Penilaian;
import com.egiapp.demo.repository.PenilaianHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenilaianService {

    @Autowired
    private PenilaianHelper penilaianRepo;
//
//    @Autowired
//    private UserRepository userRepository;


    public Penilaian create(Penilaian penilaian){

        return penilaianRepo.save(penilaian);
    }

    public Iterable<Penilaian> findAll(){
        return penilaianRepo.findAll();
    }

    public Penilaian findByid(Long id){
        return penilaianRepo.findById(id).get();
    }

    public void removeOne(Long id){
        penilaianRepo.deleteById(id);
    }


}
