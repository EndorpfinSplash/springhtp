package com.htp.repository.impl;

import com.htp.domain.Department;
import com.htp.repository.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    private static final String DEP_ID = "dep_id";
    private static final String DEP_NAME = "dep_name";
    private static final String DEP_CAPACITY = "dep_capacity";
    private static final String FACTORY_ID = "factory_id";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private Department getDepartmentFromResSet(ResultSet resultSet, final int i) throws SQLException {
        Department department = new Department();
        department.setDepId(resultSet.getLong(DEP_ID));
        department.setDepName(resultSet.getString(DEP_NAME));
        department.setDepCapacity(resultSet.getInt(DEP_CAPACITY));
        department.setFactoryId(resultSet.getLong(FACTORY_ID));
        return department;
    }

    @Override
    public List<Department> findAll() {
        final String findAllDept = "select * from department";
        return namedParameterJdbcTemplate.query(findAllDept, this::getDepartmentFromResSet);
    }

    @Override
    public Department findById(Long id) {
        final String findAllById = "select * from department where dep_id = :dep_id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("dep_id", id);
        return namedParameterJdbcTemplate.queryForObject(findAllById, params, this::getDepartmentFromResSet);
    }

    @Override
    public void delete(Long id) {
        final String delete = "delete from department where dep_id = :depId";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("depId", id);
        namedParameterJdbcTemplate.update(delete, params);
    }

    @Override
    public Department save(Department entity) {
        final String createQuery =
                "insert into department(dep_id, dep_name,dep_capacity, factory_id) " +
                        "value (:depId, :dep_name,:dep_capacity, :factory_id)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("depId", entity.getDepId())
                .addValue("dep_name", entity.getDepName())
                .addValue("dep_capacity", entity.getDepCapacity())
                .addValue("factory_id", entity.getFactoryId());

        namedParameterJdbcTemplate.update(createQuery, parameterSource, keyHolder);
        long createdDepId = Objects.requireNonNull(keyHolder.getKey()).longValue();
        return findById(createdDepId);
    }

    @Override
    public Department update(final Department entity) {
        final String updateQuerry ="update department set dep_name=:dep_name, dep_capacity=:dep_capacity,factory_id =:factory_id " +
                "where dep_id = :depId";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("depId", entity.getDepId())
                .addValue("dep_name", entity.getDepName())
                .addValue("dep_capacity", entity.getDepCapacity())
                .addValue("factory_id", entity.getFactoryId());
        namedParameterJdbcTemplate.update(updateQuerry,params);
        return findById(entity.getDepId());
    }
}
