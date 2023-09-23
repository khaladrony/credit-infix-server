package com.rony.creditinfix.services.auth.role;


import com.rony.creditinfix.models.auth.RoleDTO;
import com.rony.creditinfix.services.AbstractService;

public interface RoleService extends AbstractService<RoleDTO> {
    RoleDTO findByName(String name);
}
