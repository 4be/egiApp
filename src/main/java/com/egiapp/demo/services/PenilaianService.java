package com.egiapp.demo.services;


import com.egiapp.demo.model.entity.Penilaian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenilaianService {


    @Autowired
    private PenilaianRepo userRepository;


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

    public List<Penilaian> findKesByIdDesc(Long id){
        return penilaianRepo.findKesByIdDesc(id);
    }

    public List<Penilaian>findKesByTeam(String team){
        return penilaianRepo.findKesByTeam(team);
    }

    public List<String>findTotalKesMonth(Long month){
        return penilaianRepo.findTotalKesMonth(month);
    }


}
