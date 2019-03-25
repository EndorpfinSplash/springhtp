package com.htp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;

public class Department {

    private Long depId;
    private String depName;
    private int depCapacity;
    private Long factoryId;

    public Department() {
    }

    public Department(Long depId, String depName, int depCapacity, Long factoryId) {
        this.depId = depId;
        this.depName = depName;
        this.depCapacity = depCapacity;
        this.factoryId = factoryId;
    }

    public Department(String depName, int depCapacity, Long factoryId) {
        this.depName = depName;
        this.depCapacity = depCapacity;
        this.factoryId = factoryId;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getDepCapacity() {
        return depCapacity;
    }

    public void setDepCapacity(int depCapacity) {
        this.depCapacity = depCapacity;
    }

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return depCapacity == that.depCapacity &&
                Objects.equals(depId, that.depId) &&
                Objects.equals(depName, that.depName) &&
                Objects.equals(factoryId, that.factoryId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(depId, depName, depCapacity, factoryId);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
