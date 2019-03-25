package com.htp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.Objects;

public class Factory {
    private Long factory_id;
    private String factory_name;
    private Date factory_open_year;

    public Factory() {
    }

    public Factory(Long factory_id, String factory_name, Date factory_open_year) {
        this.factory_id = factory_id;
        this.factory_name = factory_name;
        this.factory_open_year = factory_open_year;
    }

    public Factory(String factory_name, Date factory_open_year) {
        this.factory_name = factory_name;
        this.factory_open_year = factory_open_year;
    }

    public Long getFactory_id() {
        return factory_id;
    }

    public void setFactory_id(Long factory_id) {
        this.factory_id = factory_id;
    }

    public String getFactory_name() {
        return factory_name;
    }

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
    }

    public Date getFactory_open_year() {
        return factory_open_year;
    }

    public void setFactory_open_year(Date factory_open_year) {
        this.factory_open_year = factory_open_year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factory factory = (Factory) o;
        return Objects.equals(factory_id, factory.factory_id) &&
                Objects.equals(factory_name, factory.factory_name) &&
                Objects.equals(factory_open_year, factory.factory_open_year);
    }

    @Override
    public int hashCode() {

        return Objects.hash(factory_id, factory_name, factory_open_year);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
