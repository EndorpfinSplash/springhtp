package com.htp.controller.requests;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Timestamp;
import java.util.Objects;

public class FactoryCreateRequest {

    private String factory_name;
    private Timestamp factory_open_year;

    public FactoryCreateRequest() {
    }

    public FactoryCreateRequest(String factory_name, Timestamp factory_open_year) {
        this.factory_name = factory_name;
        if (factory_open_year == null ) this.factory_open_year = new Timestamp(System.currentTimeMillis());
        else this.factory_open_year = factory_open_year;
    }

    public String getFactory_name() {
        return factory_name;
    }

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
    }

    public Timestamp getFactory_open_year() {
        return factory_open_year;
    }

    public void setFactory_open_year(Timestamp factory_open_year) {
        this.factory_open_year = factory_open_year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactoryCreateRequest that = (FactoryCreateRequest) o;
        return Objects.equals(factory_name, that.factory_name) &&
                Objects.equals(factory_open_year, that.factory_open_year);
    }

    @Override
    public int hashCode() {

        return Objects.hash(factory_name, factory_open_year);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
