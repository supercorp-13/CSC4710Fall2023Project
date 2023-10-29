<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Registration</title></head>
<body>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="register">
			<table border="1" cellpadding="5">
				<tr>
					<th>Username: </th>
					<td align="center" colspan="3">
						<input type="text" name="email" size="45"  value="example@gmail.com" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>First Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="firstName" size="45" value="FirstName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Last Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="lastName" size="45" value="LastName" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Credit Card Information: </th>
					<td align="center" colspan="3">
						<input type="text" name="credit_card_num" size="16" value="1234567890123456" onfocus="this.value=''">
					</td>
	
				</tr>
				
				<tr>
					<th>Address Street Number: </th>
					<td align="center" colspan="3">
						<input type="text" name="address_street_num" size="5" value="StreetNumber" onfocus="this.value=''">
					</td>
	
				</tr>
				
				<tr>
					<th>Address Street: </th>
					<td align="center" colspan="3">
						<input type="text" name="address_street" size="16" value="StreetName" onfocus="this.value=''">
					</td>
	
				</tr>
				
				<tr>
					<th>Address City: </th>
					<td align="center" colspan="3">
						<input type="text" name="address_city" size="20" value="AddressCity" onfocus="this.value=''">
					</td>
	
				</tr>
				
				<tr>
					<th>Address State: </th>
					<td align="center" colspan="3">
						<input type="text" name="address_state" size="2" value="NA" onfocus="this.value=''">
					</td>
	
				</tr>
				
				<tr>
					<th>Address Zip Code: </th>
					<td align="center" colspan="3">
						<input type="text" name="address_zip_code" size="9" value="ZipCode" onfocus="this.value=''">
					</td>
	
				</tr>
				
				<tr>
					<th>Phone Number: </th>
					<td align="center" colspan="3">
						<input type="text" name="phone_num" size="15" value="phone number" onfocus="this.value=''">
					</td>
	
				</tr>
				
				<tr>
					<th>Password: </th>
					<td align="center" colspan="3"> 
						<input type="password" name="password" size="45" value="password" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Password Confirmation: </th>
					<td align="center" colspan="3">
						<input type="password" name="confirmation" size="45" value="password" onfocus="this.value=''">
					</td>
				
				</tr>
				
				<tr>
					<th>Role: </th>
					<td align="center" colspan="3">
						<input type="role" name="role" size="9" value="role" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Register"/>
					</td>
				</tr>
			</table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</form>
	</div>
</body>