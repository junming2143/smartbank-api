package com.axess.smartbankapi.service;

import com.axess.smartbankapi.exception.RecordExistException;
import com.axess.smartbankapi.exception.RecordNotCreatedException;
import com.axess.smartbankapi.model.Role;

import java.util.List;

public interface RoleService {

    String saveAllRole(List<Role> role) throws  RecordNotCreatedException;
}
