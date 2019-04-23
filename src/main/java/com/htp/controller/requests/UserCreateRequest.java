package com.htp.controller.requests;

import java.sql.Date;
import java.util.Objects;



public class UserCreateRequest {

    private String userName;
    private String userSurname;
    private Date birthDate;
    private Long departmentId;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String userName, String userSurname, Date birthDate, Long departmentId) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.birthDate = birthDate;
        this.departmentId = departmentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateRequest that = (UserCreateRequest) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(userSurname, that.userSurname) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, userSurname, birthDate, departmentId);
    }


}
