<%--
  Created by IntelliJ IDEA.
  User: Tao
  Date: 3/23/2017
  Time: 1:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">add user</h3>
<form action="<c:url value="/Login"/>"method="post">
    <table border="0" align="center" width="40%" style="margin-left: 100px">
        <tr>
            <td width="100px">user name</td>
            <td width="40%">
                <input type="text" name="username"/>
            </td>
            <td align="left">
                <label id="nameError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>password</td>
            <td>
                <input type="password" name="password" id="password"/>
            </td>
            <td>
                <label id="passwordError"class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>email</td>
            <td>
                <input type="text" name="email" id="email"/>
            </td>
            <td>
                <label id="emailError"class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit" value="login"/>
                <input type="reset" name="reset" value="reset"/>
            </td>
        </tr>

    </table>

</form>
</body>
</html>

