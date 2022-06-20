package com.egiapp.demo.services;


import com.egiapp.demo.model.entity.Penilaian;
import com.egiapp.demo.model.repos.KeteranganRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PenilaianService {

    @Autowired
    private KeteranganRepo keteranganRepo;
//
//    @Autowired
//    private UserRepository userRepository;


    public Penilaian create(Penilaian penilaian){

        return keteranganRepo.save(penilaian);
    }

    public Iterable<Penilaian> findAll(){
        return keteranganRepo.findAll();
    }

    public Penilaian findByid(Long id){
        return keteranganRepo.findById(id).get();
    }

    public void removeOne(Long id){
        keteranganRepo.deleteById(id);
    }

    public List<Penilaian> findKesByIdDesc(Long id){
        return keteranganRepo.findKesByIdDesc(id);
    }

    public List<Penilaian>findKesByTeam(String team){
        return keteranganRepo.findKesByTeam(team);
    }

    public List<String>findTotalKesMonth(Long month){
        return keteranganRepo.findTotalKesMonth(month);
    }


}
