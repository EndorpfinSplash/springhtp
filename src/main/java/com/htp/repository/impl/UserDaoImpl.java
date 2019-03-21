package com.htp.repository.impl;

import com.htp.domain.User;
import com.htp.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements UserDao {

    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_SURNAME = "user_surname";
    public static final String BIRTH_DATE = "birth_date";
    public static final String DEP_ID = "dep_id";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /*Read from Result Set by column name*/
    private User getUserRowMapper(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getLong(USER_ID));
        user.setUserName(resultSet.getString(USER_NAME));
        user.setUserSurname(resultSet.getString(USER_SURNAME));
        user.setBirthDate(resultSet.getTimestamp(BIRTH_DATE));
        user.setDepartmentId(resultSet.getLong(DEP_ID));
        return user;
    }

    @Override
    public List<User> findAll() {
        final String findAllQuery = "select * from user";
//        return jdbcTemplate.query(findAllQuery, this::getUserRowMapper);
        return namedParameterJdbcTemplate.query(findAllQuery, this::getUserRowMapper);
    }

    @Override
    public User findById(Long id) {
//        final String findById = "select * from user where user_id = ?";
////        return jdbcTemplate.queryForObject(findById, new Object[]{id}, this::getUserRowMapper);
        final String findById = "select * from user where user_id = :userId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", id);

        return namedParameterJdbcTemplate.queryForObject(findById, params, this::getUserRowMapper);
    }

    @Override
    public void delete(Long id) {
        final String delete = "delete from user where user_id = :userId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", id);

        namedParameterJdbcTemplate.update(delete, params);
    }

    @Override
    public User save(User entity) {
        final String createQuery = "INSERT INTO user (user_name, user_surname, birth_date, dep_id) " +
                "VALUES (:userName, :userSurname, :birthDate, :depId);";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userName", entity.getUserName());
        params.addValue("userSurname", entity.getUserSurname());
        params.addValue("birthDate", entity.getBirthDate());
        params.addValue("depId", entity.getDepartmentId());

        namedParameterJdbcTemplate.update(createQuery, params, keyHolder);

        long createdUserId = Objects.requireNonNull(keyHolder.getKey()).longValue();

        return findById(createdUserId);
    }

    @Override
    public User update(User entity) {
        final String createQuery = "UPDATE user set user_name = :userName, user_surname = :userSurname, " +
                "birth_date = :birthDate, dep_id = :depId where user_id = :userId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userName", entity.getUserName());
        params.addValue("userSurname", entity.getUserSurname());
        params.addValue("birthDate", entity.getBirthDate());
        params.addValue("depId", entity.getDepartmentId());
        params.addValue("userId", entity.getUserId());

        namedParameterJdbcTemplate.update(createQuery, params);
        return findById(entity.getUserId());
    }

    @Override
    public List<Long> batchUpdate(List<User> users) {
        final String createQuery = "UPDATE user set user_name = :userName, user_surname = :userSurname, " +
                "birth_date = :birthDate, dep_id = :depId where user_id = :userId";

        List<SqlParameterSource> batch = new ArrayList<>();
        for (User user : users) {
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("userName", user.getUserName());
            params.addValue("userSurname", user.getUserSurname());
            params.addValue("birthDate", user.getBirthDate());
            params.addValue("depId", user.getDepartmentId());
            params.addValue("userId", user.getUserId());
            batch.add(params);
        }

        namedParameterJdbcTemplate.batchUpdate(createQuery, batch.toArray(new SqlParameterSource[batch.size()]));
        return users.stream().map(User::getUserId).collect(Collectors.toList());
    }
}
