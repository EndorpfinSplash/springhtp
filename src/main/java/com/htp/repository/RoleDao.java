package com.htp.repository;

import com.htp.domain.Role;

import java.util.List;

public interface RoleDao extends GenericDao<Role, Long> {
    List<Role> getRolesByUserId(Long userId);
}
