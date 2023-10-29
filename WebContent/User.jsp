<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<a href="login.jsp"target ="_self" > logout</a><br><br> 

<h1>List all users</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Address</th>
                <th>Password</th>
                <th>Credit Card Number</th>
                <th>Phone Number</th>
            </tr>
            <c:forEach var="user" items="${get_user}">
                <tr style="text-align:center">
                    <td>"${user.email}" </td>
                    <td>"${user.firstName}"</td>
                    <td>"${user.lastName}"</td>
                    <td>"${user.address_street_num} ${users.address_street} ${users.address_city} ${users.address_state} ${users.address_zip_code}"</td>
                    <td>"${user.password}"</td>
                    <td>"${user.credit_card_num}"</td>
                    <td>"${user.phone_num}"</td>
                 </tr>
            </c:forEach>
          </table>
	</div>
<body>

</body>
</html>