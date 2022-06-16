package com.egiapp.demo.security.service;

import com.egiapp.demo.repository.UserRepository;
import com.egiapp.demo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(username, username).orElseThrow(() ->
            new UsernameNotFoundException("User " + username + " tidak ditemukan")
        );
        return UserDetailsImpl.build(user);
    }

}
