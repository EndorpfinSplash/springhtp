<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div>
    <h2>Create a Factory</h2>
    <sf:form method="POST" modelAttribute="factory"> <!-- Связать форму -->
        <fieldset> <!-- с атрибутом модели -->
            <table cellspacing="0">

                <tr>
                    <th><label for="factory_name">Factory name:</label></th>
                    <td><sf:input path="factory_name"
                                  size="15"
                                  maxlength="15"
                                  id="factory_name"/> <!-- Поле имени пользователя -->
                        <small id="username_msg">No spaces, please.</small>
                    </td>
                </tr>
<%--                <tr>
                    <th><label for="factory_open_year">Factory opening:</label></th>
                    <td><sf:input path="factory_open_year"
                                  size="30"
                                  id="factory_open_year"/>
                        <small>only numbers (be tricky!)</small>
                    </td>
                </tr>--%>
                <tr>
                    <th></th>
                    <td><input name="commit"
                               type="submit"
                               value="Create factory!"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </sf:form>
</div>