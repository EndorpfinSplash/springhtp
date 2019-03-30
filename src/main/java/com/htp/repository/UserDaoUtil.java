package com.htp.repository;

import com.htp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

@Component
@Transactional(rollbackFor = DataIntegrityViolationException.class)
public class UserDaoUtil {

    @Autowired
    private UserDao userDao;

    public void testOperations() {
        userDao.save(new User(100L, "test", "test", new Timestamp(new Date().getTime()), 1L));

        User second = userDao.findById(2L);
        second.setUserSurname("testTransaction");
        User third = userDao.findById(3L);
        third.setUserSurname("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

        userDao.batchUpdate(Arrays.asList(second, third));
    }
}
