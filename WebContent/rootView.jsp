<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Root page</title>
</head>
<body>

<div align = "center">
	
	<form action = "initialize">
		<input type = "submit" value = "Initialize the Database"/>
	</form>
	<a href="login.jsp"target ="_self" > logout</a><br><br> 

<h1>List all users</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Users</h2></caption>
            <tr>
            	<th>ID</th>
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Credit Card Number</th>
                <th>Phone Number</th>
                <th>Role</th>
                <th>Address</th>
                <th>Password</th>
            </tr> 
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                	<td><c:out value="${users.id}" /></td>
                    <td><c:out value="${users.email}" /></td>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <td><c:out value="${users.CCNum}" /></td>
			        <td><c:out value="${users.phoneNumber}" /></td>
			        <td><c:out value="${users.role}" /></td>
                    <td><c:out value="${users.address_street_num} ${users.address_street} ${users.address_city} ${users.address_state} ${users.address_zip_code}" /></td>
                    <td><c:out value="${users.password}" /></td>

            </c:forEach>
        </table>
	</div>
	
<h1>List all trees</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Trees</h2></caption>
            <tr>
                <th>Tree ID</th>
                <th>Size</th>
                <th>Height</th>
                <th>Location</th>
                <th>Distance to House</th>
                <th>Client ID</th>
                <th>Quote ID</th>
            </tr>
            <c:forEach var="tree" items="${listTree}">
                <tr style="text-align:center">
                    <td><c:out value="${tree.treeID}" /></td>
                    <td><c:out value="${tree.size}" /></td>
                    <td><c:out value="${tree.height}" /></td>
                    <td><c:out value="${tree.location}" /></td>
                    <td><c:out value="${tree.proximity}" /></td>
                    <td><c:out value="${tree.clientID}" /></td>
                    <td><c:out value="${tree.quoteID}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    
<h1>List all quotes</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Quotes</h2></caption>
            <tr>
                <th>Quote ID</th>
                <th>Initial Price</th>
                <th>Time Window</th>
                <th>Status</th>
                <th>Client ID</th>
                <th>Contractor ID</th>
            </tr>
            <c:forEach var="quote" items="${listQuote}">
                <tr style="text-align:center">
                    <td><c:out value="${quote.quoteID}" /></td>
                    <td><c:out value="${quote.initialPrice}" /></td>
                    <td><c:out value="${quote.timeWindow}" /></td>
                    <td><c:out value="${quote.status}" /></td>
                    <td><c:out value="${quote.clientID}" /></td>
                    <td><c:out value="${quote.contractorID}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    
 <h1>List all quote messages</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Quote Messages</h2></caption>
            <tr>
                <th>Quote Message ID</th>
                <th>User ID</th>
                <th>Quote ID</th>
                <th>Message Time</th>
                <th>Price</th>
                <th>Schedule Start</th>
                <th>Schedule End</th>
                <th>Note</th>
            </tr>
            <c:forEach var="quoteMessage" items="${listQuoteMessages}">
                <tr style="text-align:center">
                    <td><c:out value="${quoteMessage.quoteMessageID}" /></td>
                    <td><c:out value="${quoteMessage.userID}" /></td>
                    <td><c:out value="${quoteMessage.quoteID}" /></td>
                    <td><c:out value="${quoteMessage.msgTime}" /></td>
                    <td><c:out value="${quoteMessage.price}" /></td>
                    <td><c:out value="${quoteMessage.scheduleStart}" /></td>
                    <td><c:out value="${quoteMessage.scheduleEnd}" /></td>
                    <td><c:out value="${quoteMessage.note}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
	
	<h1>List all orders</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Orders</h2></caption>
            <tr>
                <th>Order ID</th>
                <th>Quote ID</th>
                <th>Price</th>
                <th>Schedule Start</th>
                <th>Schedule End</th>
            </tr>
            <c:forEach var="order" items="${listOrders}">
                <tr style="text-align:center">
                    <td><c:out value="${order.orderID}" /></td>
                    <td><c:out value="${order.quoteID}" /></td>
                    <td><c:out value="${order.price}" /></td>
                    <td><c:out value="${order.scheduleStart}" /></td>
                    <td><c:out value="${order.scheduleEnd}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
	
	<h1>List all bills</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Bills</h2></caption>
            <tr>
                <th>Bill ID</th>
                <th>Order ID</th>
                <th>Price</th>
                <th>Discount</th>
                <th>Balance</th>
                <th>Status</th>
            </tr>
            <c:forEach var="bill" items="${listBills}">
                <tr style="text-align:center">
                    <td><c:out value="${bill.billID}" /></td>
                    <td><c:out value="${bill.orderID}" /></td>
                    <td><c:out value="${bill.price}" /></td>
                    <td><c:out value="${bill.discount}" /></td>
                    <td><c:out value="${bill.balance}" /></td>
                    <td><c:out value="${bill.status}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    
    <h1>List all bill messages</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Bill Messages</h2></caption>
            <tr>
                <th>Bill Message ID</th>
                <th>User ID</th>
                <th>Bill ID</th>
                <th>Message Time</th>
                <th>Price</th>
                <th>Schedule Start</th>
                <th>Schedule End</th>
                <th>Note</th>
            </tr>
            <c:forEach var="billMessage" items="${listBillMessages}">
                <tr style="text-align:center">
                    <td><c:out value="${billMessage.billMessageID}" /></td>
                    <td><c:out value="${billMessage.userID}" /></td>
                    <td><c:out value="${billMessage.billID}" /></td>
                    <td><c:out value="${billMessage.msgTime}" /></td>
                    <td><c:out value="${billMessage.price}" /></td>
                    <td><c:out value="${billMessage.scheduleStart}" /></td>
                    <td><c:out value="${billMessage.scheduleEnd}" /></td>
                    <td><c:out value="${billMessage.note}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
	</div>

</body>
</html>