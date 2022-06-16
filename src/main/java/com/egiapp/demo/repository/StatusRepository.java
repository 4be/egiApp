package com.egiapp.demo.repository;

import com.egiapp.demo.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    Status findByUserId(Long userId);

    List<Status> findByUserStatus(Boolean statusUser);

    void deleteByUserId(Long userId);

}
