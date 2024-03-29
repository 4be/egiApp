package com.egiapp.demo.services.impl;

import com.egiapp.demo.model.entity.*;
import com.egiapp.demo.model.request.UserRequest;
import com.egiapp.demo.model.response.FailedResponse;
import com.egiapp.demo.model.response.SuccessResponse;
import com.egiapp.demo.model.response.payload.PenilaianResponse;
import com.egiapp.demo.model.response.payload.TeamResponse;
import com.egiapp.demo.model.response.payload.UserResponse;
import com.egiapp.demo.repository.PenilaianInRepository;
import com.egiapp.demo.repository.RoleRepository;
import com.egiapp.demo.repository.UserRepository;
import com.egiapp.demo.services.PenilaianInService;
import com.egiapp.demo.services.UserService;
import com.egiapp.demo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PenilaianInRepository penilaianInRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public Object getAllUser() {
        try {
            List<User> userList = userRepository.findUsersByIsaktif(Boolean.TRUE);
            List<UserResponse> UserResponseList = new ArrayList<>();

            for (User user : userList) {
                UserResponse userResponse = getUserResponse(user);
                UserResponseList.add(userResponse);
            }

            return new SuccessResponse(HttpStatus.OK, "Success", UserResponseList);
        } catch (Exception e) {
            return new FailedResponse(HttpStatus.MULTI_STATUS, e.getMessage());
        }
    }

    @Override
    public Object createUser(UserRequest userRequest) {

        if (userRepository.existsByUsername(userRequest.getNik())) {
            return new FailedResponse(
                HttpStatus.BAD_REQUEST, "NIK sudah terdaftar!"
            );
        }

        if (userRepository.existsByEmail(userRequest.getEmail())) {
            return new FailedResponse(
                HttpStatus.BAD_REQUEST, "Email sudah terdaftar"
            );
        }

        Set<Role> roles = getRole(userRequest.getRole().toUpperCase());

        User user = new User(
            userRequest.getNik(),
            userRequest.getNama(),
            userRequest.getNik(),
            userRequest.getNik_manager(),
            userRequest.getAlamat(),
            userRequest.getTanggal_lahir(),
            userRequest.getEmail(),
            encoder.encode(
                userRequest.getPassword()
            ),
            userRequest.getDivisi(),
            userRequest.getNik_manager().isEmpty() ? "-" : userRequest.getNik_manager(),
            Boolean.TRUE,
            roles
        );

        User save = userRepository.save(user);

        Status status = getStatus(save);
        statusRepository.save(status);

        UserResponse userResponse = getUserResponse(save);
        return new SuccessResponse(HttpStatus.OK, "Success", userResponse);
    }

    @Override
    public Object createUserByUpload(MultipartFile fileRequest) {
        try {
            InputStream inputStream = fileRequest.getInputStream();
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            List<UserResponse> userResponseList = new ArrayList<UserResponse>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                if (userRepository.existsByUsername(csvRecord.get("NOREG"))) {
                    continue;
                }

                if (userRepository.existsByEmail(csvRecord.get("email"))) {
                    continue;
                }

                Set<Role> roles = getRole(csvRecord.get("role").toUpperCase());


                User user = new User(
                    csvRecord.get("NOREG"),
                    csvRecord.get("nama"),
                    csvRecord.get("NOREG"),
                    csvRecord.get("dept"),
                    csvRecord.get("alamat"),
                    csvRecord.get("tanggal_lahir"),
                    csvRecord.get("email"),
                    encoder.encode(
                        csvRecord.get("NOREG")
                    ),
                    csvRecord.get("divisi"),
                    csvRecord.get("nik_manager").isEmpty() ? "-" : csvRecord.get("nik_manager"),
                    Boolean.TRUE,
                    roles
                );


                User save = userRepository.save(user);

                Status status = getStatus(save);
                statusRepository.save(status);

                UserResponse userResponse = getUserResponse(save);
                userResponseList.add(userResponse);
            }
            return new SuccessResponse(HttpStatus.OK, "Success", userResponseList);
        } catch (IOException e) {
            return new FailedResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public Object getUserById(Long id) {
        try {
            User user = userRepository.findById(id).get();
            UserResponse userResponse = getUserResponse(user);
            return new SuccessResponse(HttpStatus.OK, "Success", userResponse);
        } catch (Exception e) {
            return new FailedResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public Object getUserByNik(String nik) {
        try {
            List<User> userList = Collections.singletonList(userRepository.findUserByRegno(nik));

            List<UserResponse> UserResponseList = new ArrayList<>();

            for (User user : userList) {
                UserResponse userResponse = getUserResponse(user);
                UserResponseList.add(userResponse);
            }
            return new SuccessResponse(HttpStatus.OK, "Success", UserResponseList);
        } catch (Exception e) {
            return new FailedResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


    @Override
    public Object getUserByNikManager(String nikManager) {
        try {
            List<User> userList = userRepository.findUserByNikManager(nikManager);
            List<TeamResponse> teamResponseList = new ArrayList<>();

            for (User user : userList) {
//                Boolean working = clockRepo.findStatusByIdDesc(user.getId());
                TeamResponse teamResponse = new TeamResponse(
                    user.getId(),
                    user.getNama(),
                    user.getRegno(),
                    user.getAlamat(),
                    user.getTanggalLahir(),
                    user.getEmail(),
                    user.getDivisi(),
                    user.getNikManager(),
                    user.getIsaktif(),
                    user.getRoles().iterator().next().getRolename().toString()
                );
                teamResponseList.add(teamResponse);
            }

            return new SuccessResponse(HttpStatus.OK, "Success", teamResponseList);
        } catch (Exception e) {
            return new FailedResponse(HttpStatus.MULTI_STATUS, e.getMessage());
        }
    }

    @Override
    public Object updateUserByNik(UserRequest userRequest, String nik) {
        try {
            User user = userRepository.findUserByRegno(nik);
            Set<Role> roles = getRole(userRequest.getRole().toUpperCase());

            user.setNama(userRequest.getNama());
            user.setAlamat(userRequest.getAlamat());
            user.setTanggalLahir(userRequest.getTanggal_lahir());
            user.setEmail(userRequest.getEmail());
            user.setDivisi(userRequest.getDivisi());
            user.setNikManager(userRequest.getNik_manager().isEmpty() ? "-" : userRequest.getNik_manager());
            user.setRoles(roles);
            User save = userRepository.save(user);

            UserResponse userResponse = getUserResponse(save);
            return new SuccessResponse(HttpStatus.OK, "Updated", userResponse);
        } catch (Exception e) {
            return new FailedResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public Object deleteUser(Long id) {
        try {
            User user = userRepository.findById(id).get();
            user.setIsaktif(Boolean.FALSE);
            userRepository.save(user);
            return new SuccessResponse(HttpStatus.OK, "Deleted", "");
        } catch (Exception e) {
            return new FailedResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public Object deleteUserByNik(String nik) {
        try {
            User user = userRepository.findUserByRegno(nik);
            user.setIsaktif(Boolean.FALSE);
            userRepository.save(user);
            return new SuccessResponse(HttpStatus.OK, "Deleted", "");
        } catch (Exception e) {
            return new FailedResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    // HELPER
    public Set<Role> getRole(String role) {
        Set<Role> roles = new HashSet<>();
        switch (role) {
            case "PENINJAU":
                Role adminRole = roleRepository.findByRolename(ERole.PENINJAU);
                roles.add(adminRole);
                break;
            case "GL":
                Role GLRole = roleRepository.findByRolename(ERole.GL);
                roles.add(GLRole);
                break;
            case "KADEPT":
                Role KDRole = roleRepository.findByRolename(ERole.KADEPT);
                roles.add(KDRole);
                break;
            case "HRD":
                Role HRDRole = roleRepository.findByRolename(ERole.HRD);
                roles.add(HRDRole);
                break;
            default:
                Role defRole = roleRepository.findByRolename(ERole.PEGAWAI);
                roles.add(defRole);
        }
        return roles;
    }

    public UserResponse getUserResponse(User user) {
        UserResponse userResponse = new UserResponse(
            user.getId(),
            user.getNama(),
            user.getRegno(),
            user.getAlamat(),
            user.getTanggalLahir(),
            user.getEmail(),
            user.getDivisi(),
            user.getNikManager(),
            user.getIsaktif(),
            user.getRoles().iterator().next().getRolename().toString()
        );
        return userResponse;
    }

    public Status getStatus(User user) {
        Status status = new Status(
            user.getId(),
            user.getRegno(),
            user.getNama(),
            Boolean.FALSE
        );
        return status;
    }

}
