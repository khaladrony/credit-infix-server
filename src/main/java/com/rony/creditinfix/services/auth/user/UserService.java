package com.rony.creditinfix.services.auth.user;

import com.rony.creditinfix.models.auth.UserDTO;
import com.rony.creditinfix.services.AbstractService;

public interface UserService extends AbstractService<UserDTO> {

    UserDTO findByUsername(String username);
}
