<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Initial Request</title></head>
<body>
	<center><h1>Initial Request</h1></center>
	<div align="center">
		<p>Your client ID is: ${sessionScope.userID}</p>
        <c:if test="${not empty errorMessage}">
            <p style="color: red;">${errorMessage}</p>
        </c:if>

        <c:if test="${not empty sessionScope.successMessage}">
            <p style="color: orange;">${sessionScope.successMessage}</p>
            <% session.removeAttribute("successMessage"); // Remove after displaying %>
        </c:if>
		<form action="initialRequest">
			<table border="1" cellpadding="5">
				<tr>
					<th>Tree Size(In feet): </th>
					<td align="center" colspan="3">
						<input type="text" name="size" size="45"  value="" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Tree Height(In feet): </th>
					<td align="center" colspan="3">
						<input type="text" name="height" size="45" value="" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Location: </th>
					<td align="center" colspan="3">
						<input type="text" name="location" size="45" value="" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
				    <th>Distance From House(In feet): </th>
				    <td align="center" colspan="3">
				        <input type="text" name="proximity" size="45" value="" onfocus="this.value=''">
				    </td>
				</tr>
				<tr>
				    <th>Your Client ID: </th>
				    <td align="center" colspan="3">
				        <input type="text" name="clientID" size="45" value="" onfocus="this.value=''">
				    </td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Get Your Quote"/>
					</td>
				</tr>
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>