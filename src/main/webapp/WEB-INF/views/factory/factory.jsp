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
<h2> Factories </h2>
<p/>
<a href="/factories/create?new">Create new factory</a></td>
<p/>
<table cellspacing="15" border="1px solid green">
    <tr>
        <th>Id</th>
        <th>FactoryName</th>
        <th>OpeningDate</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${factoriesList}" var="factory">
        <tr>
            <td><c:out value="${factory.factory_id}"/><br/></td>
            <td>
                <s:url value="/factories"
                       var="factory_url"> <!-- Конструирование URL-сообщения -->
                    <s:param name="factory_id"
                             value="${factory.factory_id}"/>
                </s:url>
                <a href="${factory_url}"> <!-- Отображение свойств сообщения -->
                    <c:out value="${factory.factory_name}"/>
                </a>

            </td>

            <td><c:out value="${factory.factory_open_year}"/><br/></td>

            <td><a href="/factories/edit?factory_id=${factory.factory_id}">Edit</a></td>
            <td><a href="/factories/delete?factory_id=${factory.factory_id}">Delete</a></td>

            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>