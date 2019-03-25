package com.htp.repository;

import com.htp.domain.Factory;

import java.util.List;


public interface FactoryDao extends GenericDao<Factory, Long> {
    void saveFactories(List<Factory> factories);
}
