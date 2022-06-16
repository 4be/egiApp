package com.egiapp.demo.services;

import com.egiapp.demo.model.request.RoleRequest;

public interface RoleService {

    Object getAllRole();

    Object createRole(RoleRequest roleRequest);

    Object getRole(Integer id);

    Object updateRole(Integer id, RoleRequest roleRequest);

    Object deleteRole(Integer id);

}
