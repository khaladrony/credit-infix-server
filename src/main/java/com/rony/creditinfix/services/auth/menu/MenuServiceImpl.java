package com.rony.creditinfix.services.auth.menu;

import com.rony.creditinfix.entity.auth.Menu;
import com.rony.creditinfix.exception.GeneralException;
import com.rony.creditinfix.exception.NotFoundException;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.auth.MenuDTO;
import com.rony.creditinfix.repository.auth.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuRepository menuRepository;


    @Override
    public MenuDTO create(MenuDTO menuDTO) throws ServiceException {
        Menu menu = new Menu(menuDTO);

        this.duplicateCheck(menuDTO, "save");
        return new MenuDTO(menuRepository.save(menu));
    }

    @Override
    public MenuDTO update(Long id, MenuDTO menuDTO) throws ServiceException {
        MenuDTO _menuDTO = this.findById(id);
        if (_menuDTO == null) throw new NotFoundException();

        this.duplicateCheck(menuDTO, "");

        _menuDTO.setName(menuDTO.getName());
        _menuDTO.setDescription(menuDTO.getDescription());
        _menuDTO.setStatus(menuDTO.getStatus());
        Menu menu = new Menu(_menuDTO);

        return new MenuDTO(menuRepository.save(menu));
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        MenuDTO menuDTO = this.findById(id);
        if (menuDTO == null) throw new NotFoundException();

        menuRepository.deleteById(id);
        return true;
    }

    @Override
    public MenuDTO findById(Long id) throws ServiceException {
        Optional<Menu> menuData = menuRepository.findById(id);
        return menuData.isEmpty() ? null : new MenuDTO(menuData.get());
    }

    @Override
    public MenuDTO findByName(String name) {
        Optional<Menu> menuData = menuRepository.findByName(name);
        return menuData.isEmpty() ? null : new MenuDTO(menuData.get());
    }


    @Override
    public Page<MenuDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<MenuDTO> findAll() {
        List<MenuDTO> menuDTOS = new ArrayList<>();
        List<Menu> menus = menuRepository.findAll();
        for (Menu menu: menus) {
            MenuDTO menuDTO= new MenuDTO(menu);
            menuDTOS.add(menuDTO);
        }
        return menuDTOS;
    }

    private void duplicateCheck(MenuDTO menuDTO, String type) throws ServiceException {
        MenuDTO menuDTOObj = this.findByName(menuDTO.getName());
        if (menuDTOObj == null) return;

        if (type.equalsIgnoreCase("save")) {
            throw new GeneralException("The role exists");
        } else {
            int count = menuRepository.countByName(menuDTO.getId(), menuDTO.getName());
            if (count >= 1) {
                throw new GeneralException("The role exists");
            }
        }

    }
}
