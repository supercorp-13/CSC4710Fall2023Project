<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>David Smith DashBoard</title>
</head>
<body>

<div align = "center">
	<a href="login.jsp"target ="_self" > logout</a><br><br> 

	
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
            </tr>
            <c:forEach var="tree" items="${listTreeWithoutQuote}">
                <tr style="text-align:center">
                    <td><c:out value="${tree.treeID}" /></td>
                    <td><c:out value="${tree.size}" /></td>
                    <td><c:out value="${tree.height}" /></td>
                    <td><c:out value="${tree.location}" /></td>
                    <td><c:out value="${tree.proximity}" /></td>
                    <td><c:out value="${tree.clientID}" /></td>
                    <td>
			            <form action="registerQuote.jsp" method="post">
			                <input type="hidden" name="treeID" value="${tree.treeID}" />
			                <input type="hidden" name="clientID" value="${tree.clientID}" />
			                <button type="submit">Send Quote</button>
			            </form>
			        </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <h2>Quote Messages with Price</h2>
    <div align="center">
    <table border="1" cellpadding="6">
        <caption><h3>List of Quote Messages</h3></caption>
        <tr>
            <th>Quote Message ID</th>
            <th>User ID</th>
            <th>Quote ID</th>
            <th>Time Delivered</th>
            <th>Price</th>
            <th>Schedule Start</th>
            <th>Schedule End</th>
            <th>Note</th>
        </tr>
        <c:forEach var="quoteMessage" items="${listAllQuoteMessagesWithPrice}">
            <tr style="text-align:center">
                <td><c:out value="${quoteMessage.quoteMessageID}" /></td>
                <td><c:out value="${quoteMessage.userID}" /></td>
                <td><c:out value="${quoteMessage.quoteID}" /></td>
                <td><c:out value="${quoteMessage.msgTime}" /></td>
                <td><c:out value="${quoteMessage.price}" /></td>
                <td><c:out value="${quoteMessage.scheduleStart}" /></td>
                <td><c:out value="${quoteMessage.scheduleEnd}" /></td>
                <td><c:out value="${quoteMessage.note}" /></td>
                <td>
                    <form action="respondQuote.jsp" method="post">
    					<input type="hidden" name="quoteID" value="${quoteMessage.quoteID}" />
    					<button type="submit">Respond</button>
					</form>
                </td>
            </tr>
        </c:forEach>
    </table>
    </div>
	</div>
</body>
</html>