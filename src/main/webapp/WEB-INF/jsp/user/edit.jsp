<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div>
    <h2>Update user</h2>
    <sf:form method="POST" modelAttribute="user"> <!-- Связать форму -->
        <fieldset> <!-- с атрибутом модели -->
            <table cellspacing="0">
                <tr>
                    <th><label for="user_id">User id:</label></th>
                    <td><sf:input path="userId"
                                  size="15"
                                  id="user_id"/>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_name">User name:</label></th>
                    <td><sf:input path="userName"
                                  size="15"
                                  id="user_name"/>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_surname">User surname:</label></th>
                    <td><sf:input path="userSurname"
                                  size="15"
                                  maxlength="15"
                                  id="user_surname"/> <!-- Поле имени пользователя -->
                        <small id="username_msg">No spaces, please.</small>
                    </td>
                </tr>
                <tr>
                    <th><label for="user_department">Department:</label></th>
                    <td><sf:input path="departmentId"
                                  size="30"
                                  id="user_department"/> <!-- Поле пароля -->
                        <small>only numbers (be tricky!)</small>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td><input name="commit"
                               type="submit"
                               value="Save user!"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </sf:form>
</div>