<%@ page contentType="text/html; charset = UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Hello World</title>
    <style>
        table, th, td {
            border: 1px solid #7af246;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
            text-align: center;
        }
    </style>
</head>

<body>
<p/>
<h2> USERS </h2>
<p/>
<a href="/users/create?new">Create new user</a></td>
<p/>
<table cellspacing="15" border="1px solid green">
    <tr>
        <th>Id</th>
        <th>UserName</th>
        <th>UserSurname</th>
        <th>BirthDate</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${usersList}" var="user">
        <tr>
            <td><c:out value="${user.userId}"/><br/></td>
            <td>
                <s:url value="/users/edit"
                       var="user_url"> <!-- Конструирование URL-сообщения -->
                    <s:param name="user_id"
                             value="${user.userId}"/>
                </s:url>
                <a href="${user_url}"> <!-- Отображение свойств сообщения -->
                    <c:out value="${user.userName}"/>
                </a>

            </td>

            <td><c:out value="${user.userSurname}"/><br/></td>
            <td><c:out value="${user.birthDate}"/><br/></td>
            <td><a href="/users/edit?user_id=${user.userId}">Edit</a></td>
            <td><a href="/users/delete?user_id=${user.userId}">Delete</a></td>


            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>