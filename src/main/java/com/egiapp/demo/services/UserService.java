package com.egiapp.demo.services;

import com.egiapp.demo.model.request.UserRequest;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    Object getAllUser();

    Object createUser(UserRequest userRequest);

    Object createUserByUpload(MultipartFile fileRequest);

    Object getUserById(Long id);
    
    Object getUserByNik(String nik);

    Object getUserByNikManager(String nikManager);

    Object updateUserByNik(UserRequest userRequest, String nik);

    Object deleteUser(Long id);

    Object deleteUserByNik(String nik);


}
