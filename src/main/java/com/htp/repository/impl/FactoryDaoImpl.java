package com.htp.repository.impl;

import com.htp.domain.Factory;
import com.htp.repository.FactoryDao;
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
import java.util.List;
import java.util.Objects;

@Repository
public class FactoryDaoImpl implements FactoryDao {

    public static String FACTORY_ID = "factory_id";
    public static String FACTORY_NAME = "factory_name";
    public static String FACTORY_OPEN_YEAR = "factory_open_year";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Factory getFactoryFromResultSet(ResultSet resultSet, int id) throws SQLException {
        Factory factory = new Factory();
        factory.setFactory_id(resultSet.getLong(FACTORY_ID));
        factory.setFactory_name(resultSet.getString(FACTORY_NAME));
        factory.setFactory_open_year(resultSet.getTimestamp(FACTORY_OPEN_YEAR));

        return factory;
    }

    @Override
    public List<Factory> findAll() {
        final String getAllQuery = "select * from factory";

        return namedParameterJdbcTemplate.query(getAllQuery, this::getFactoryFromResultSet);
    }

    @Override
    public Factory findById(Long id) {
        final String getByIdQuery = "select * from factory where factory_id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        return namedParameterJdbcTemplate.queryForObject(getByIdQuery, params, this::getFactoryFromResultSet);
    }

    @Override
    public void delete(Long id) {
        final String deleteQuery = "delete from factory where factory_id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        namedParameterJdbcTemplate.update(deleteQuery, params);
    }

    @Override
    public Factory save(Factory entity) {
        final String createQuery = "insert into factory ( factory_name, factory_open_year)" +
                " value (/*:factory_id,*/ :factory_name, :factory_open_year)";
        MapSqlParameterSource params = new MapSqlParameterSource();
       // params.addValue("factory_id", entity.getFactory_id());
        params.addValue("factory_name", entity.getFactory_name());
        params.addValue("factory_open_year", entity.getFactory_open_year());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(createQuery, params, keyHolder);
        long createdFactoryId = Objects.requireNonNull(keyHolder.getKey()).longValue();

        return findById(createdFactoryId);
    }

    @Override
    public Factory update(Factory entity) {
        final String updateQuery = "update factory set factory_name = :factory_name, factory_open_year= :factory_open_year" +
                " where factory_id = :factory_id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("factory_id", entity.getFactory_id());
        params.addValue("factory_name", entity.getFactory_name());
        params.addValue("factory_open_year", entity.getFactory_open_year());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(updateQuery, params, keyHolder);
        long updatedFactoryId = Objects.requireNonNull(keyHolder.getKey()).longValue();

        return findById(updatedFactoryId);
    }

    @Override
    public void saveFactories(List<Factory> factories) {
        final String saveQuery = "INSERT into factory(factory_name, factory_open_year) VALUE (:factory_name, :factory_open_year)";
        List<SqlParameterSource> batchParams = new ArrayList<>();
        factories.forEach(factory -> {
                    MapSqlParameterSource params = new MapSqlParameterSource();
                    params.addValue("factory_name", factory.getFactory_name());
                    params.addValue("factory_open_year", factory.getFactory_open_year());
                    batchParams.add(params);}
        );
        namedParameterJdbcTemplate.batchUpdate(saveQuery, batchParams.toArray(new SqlParameterSource[batchParams.size()]));
    }
}
