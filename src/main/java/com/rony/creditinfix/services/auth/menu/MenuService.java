package com.rony.creditinfix.services.auth.menu;

import com.rony.creditinfix.models.auth.MenuDTO;
import com.rony.creditinfix.services.AbstractService;

public interface MenuService extends AbstractService<MenuDTO> {
    MenuDTO findByName(String name);
}
