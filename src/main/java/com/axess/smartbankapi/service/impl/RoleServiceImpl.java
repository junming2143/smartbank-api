package com.axess.smartbankapi.service.impl;

import com.axess.smartbankapi.exception.RecordExistException;
import com.axess.smartbankapi.exception.RecordNotCreatedException;
import com.axess.smartbankapi.model.CCUser;
import com.axess.smartbankapi.model.Role;
import com.axess.smartbankapi.repository.RoleRepository;
import com.axess.smartbankapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public String saveAllRole(List<Role> role) throws  RecordNotCreatedException {
        String message = "";
        try {
            this.roleRepository.saveAll(role);
            return "Saved Roles - "+role.size();
        }catch(DataAccessException e) {
            message = "Failed to save roles - "+0;
            throw new RecordNotCreatedException(message,e);
        }

    }

}
