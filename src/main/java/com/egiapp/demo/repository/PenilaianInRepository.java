package com.egiapp.demo.repository;

import com.egiapp.demo.model.entity.Penilaian;
import com.egiapp.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PenilaianInRepository extends JpaRepository<Penilaian, Long> {

    @Query(value = "select * from tbl_penilaian GROUP BY tbl_penilaian.niktujuan,tbl_penilaian.id ORDER BY tbl_penilaian.total_nilai DESC LIMIT 10", nativeQuery = true)
    List<Penilaian> carinilaiterbaik();

    @Query(value = "select * from tbl_penilaian GROUP BY tbl_penilaian.niktujuan,tbl_penilaian.id ORDER BY tbl_penilaian.total_nilai ASC LIMIT 10", nativeQuery = true)
    List<Penilaian> carinilaiterendah();

    List<Penilaian> findPenilaianByIdNotNull();
//
//    @Query(value = "SELECT * FROM tbl_penilaian where user_id_id =:nik", nativeQuery = true)
//    List<Penilaian> findNilaiByNik(String nik);

}
