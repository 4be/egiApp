package com.egiapp.demo.model.response.payload;

import com.egiapp.demo.model.entity.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RoleResponse {

    private Integer id;
    private ERole rolename;

}
