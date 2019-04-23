<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div>
    <h2>Update factroy</h2>
    <sf:form method="POST" modelAttribute="factory"> <!-- Связать форму -->
        <fieldset> <!-- с атрибутом модели -->
            <table cellspacing="0">

                <tr>
                    <th><label for="Factory">Factory name:</label></th>
                    <td><sf:input path="factory_name"
                                  size="15"
                                  id="Factory"/>
                    </td>
                </tr>
<%--                <tr>
                    <th><label for="Opening Year">Factory opening:</label></th>
                    <td><sf:input path="factory_open_year"
                                  size="15"
                                  maxlength="15"
                                  id="Opening Year"/> <!-- Поле имени пользователя -->
                        <small id="username_msg">No spaces, please.</small>
                    </td>
                </tr>--%>

                <tr>
                    <th></th>
                    <td><input name="commit"
                               type="submit"
                               value="Save factory!"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </sf:form>
</div>