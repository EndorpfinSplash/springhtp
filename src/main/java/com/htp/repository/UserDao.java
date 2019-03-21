package com.htp.repository;

import com.htp.domain.User;

import java.util.List;

public interface UserDao extends GenericDao<User, Long> {
    List<Long> batchUpdate(List<User> users);
}
