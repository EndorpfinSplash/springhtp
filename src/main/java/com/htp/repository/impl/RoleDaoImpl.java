package com.htp.repository.impl;

import com.htp.domain.Role;
import com.htp.domain.User;
import com.htp.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;


@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    public static final String ROLE_ID = "role_id";
    public static final String ROLE_NAME = "role_name";
    public static final String ROLE_USER_ID = "role_user_id";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private Role getRoleRowMapper(ResultSet resultSet, int i) throws SQLException {
        Role role = new Role();
        role.setRoleId(resultSet.getLong(ROLE_ID));
        role.setRoleName(resultSet.getString(ROLE_NAME));
        role.setUserId(resultSet.getLong(ROLE_USER_ID));
        return role;
    }

    @Override
    public List<Role> getRolesByUserId(Long userId) {
        final String getRolesByUserId = "select * from roles where role_user_id = ?";
        return jdbcTemplate.query(getRolesByUserId, new Object[]{userId}, this::getRoleRowMapper);
    }

    @Override
    public List<Role> findAll() {
        final String findAllQuery = "select * from roles";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getRoleRowMapper);
    }

    @Override
    public Role findById(Long id) {
        final String findById = "select * from roles where role_id = :role_id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("roleId", id);

        return namedParameterJdbcTemplate.queryForObject(findById, params, this::getRoleRowMapper);

    }

    @Override
    public void delete(Long id) {
        final String delete = "delete from roles where role_id = :roleId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("roleId", id);

        namedParameterJdbcTemplate.update(delete, params);
    }

    @Override
    public Role save(Role entity) {
        final String createQuery = "INSERT INTO roles (role_id, role_name, role_user_id) " +
                "VALUES (:roleId, :roleNmae, :userId);";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("roleId", entity.getRoleId());
        params.addValue("roleName", entity.getRoleName());
        params.addValue("userId", entity.getUserId());


        namedParameterJdbcTemplate.update(createQuery, params, keyHolder);

        long createdRoleId = Objects.requireNonNull(keyHolder.getKey()).longValue();

        return findById(createdRoleId);
    }

    @Override
    public Role update(Role entity) {
        return null;
    }
}