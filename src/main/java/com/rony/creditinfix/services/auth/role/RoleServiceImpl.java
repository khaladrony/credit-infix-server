package com.rony.creditinfix.services.auth.role;

import com.rony.creditinfix.entity.auth.Role;
import com.rony.creditinfix.exception.GeneralException;
import com.rony.creditinfix.exception.NotFoundException;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.auth.RoleDTO;
import com.rony.creditinfix.repository.auth.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public RoleDTO create(RoleDTO roleDTO) throws ServiceException {
        Role role = new Role(roleDTO);

        this.duplicateCheck(roleDTO, "save");
        return new RoleDTO(roleRepository.save(role));
    }

    @Override
    public RoleDTO update(Long id, RoleDTO roleDTO) throws ServiceException {
        RoleDTO _roleDTO = this.findById(id);
        if (_roleDTO == null) throw new NotFoundException();

        this.duplicateCheck(roleDTO, "");

        _roleDTO.setName(roleDTO.getName());
        _roleDTO.setDescription(roleDTO.getDescription());
        _roleDTO.setStatus(roleDTO.getStatus());
        Role role = new Role(_roleDTO);

        return new RoleDTO(roleRepository.save(role));
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        RoleDTO roleDTO = this.findById(id);
        if (roleDTO == null) throw new NotFoundException();

        roleRepository.deleteById(id);
        return true;
    }

    @Override
    public RoleDTO findById(Long id) {
        Optional<Role> roleData = roleRepository.findById(id);
        return roleData.isPresent() ? new RoleDTO(roleData.orElse(null)) : null;
    }

    @Override
    public RoleDTO findByName(String name) {
        Optional<Role> roleData = roleRepository.findByName(name);
        return roleData.isPresent() ? new RoleDTO(roleData.orElse(null)) : null;
    }

    @Override
    public Page<RoleDTO> findAll(int page, int size) {
        List<RoleDTO> roleDTOS = new ArrayList<>();
        Pageable paging = PageRequest.of(page, size);
        Page<Role> roles = roleRepository.findAll(paging);

        Iterator var4 = roles.iterator();
        while (var4.hasNext()) {
            Role role = (Role) var4.next();
            RoleDTO roleDTO = new RoleDTO(role);
            roleDTOS.add(roleDTO);
        }

//        return roleRepository.findAll(paging);
        return (Page<RoleDTO>) roleDTOS;
    }

    @Override
    public List<RoleDTO> findAll() {
        List<RoleDTO> roleDTOS = new ArrayList<>();
        List<Role> roles = roleRepository.findAll();
        for (Role role : roles) {
            RoleDTO roleDTO = new RoleDTO(role);
            roleDTOS.add(roleDTO);
        }
        return roleDTOS;
    }

    private void duplicateCheck(RoleDTO roleDTO, String type) throws ServiceException {
        RoleDTO roleDTOObj = this.findByName(roleDTO.getName());
        if (roleDTOObj == null) return;

        if (type.equalsIgnoreCase("save")) {
            throw new GeneralException("The role exists");
        } else {
            int count = roleRepository.countByName(roleDTO.getId(), roleDTO.getName());
            if (count >= 1) {
                throw new GeneralException("The role exists");
            }
        }

    }
}
