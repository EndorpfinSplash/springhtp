package com.htp.repository.impl;

import com.htp.domain.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

public class UserDaoUtil {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Transactional
    public void testMethod() {
/*
        userDao.save(new User(100L,"Slava", "Kalevich", null, 1L));

        User tstUser = new User(111L, "Ivanov", "Ivan",null, 1L);

        userDao.batchUpdate(Arrays.asList(tstUser));*/
    }
}
