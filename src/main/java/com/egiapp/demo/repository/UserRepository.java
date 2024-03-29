package com.egiapp.demo.repository;

import com.egiapp.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUsersByIsaktif(Boolean bool);

    Optional<User> findByUsernameOrEmail(String username, String email);

    User findUserByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User findUserByRegno(String regno);

    List<User> findUserByNikManager(String nikManager);


}
