<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Respond to Quote</title>
</head>
<body>
    <h2>Respond to Quote</h2>
    <form action="respondQuotes" method="post">
        <input type="hidden" name="quoteID" value="<%= request.getParameter("quoteID") %>">
		<table border="1" cellpadding="5">
		<caption><h2>Your Special Quote</h2></caption>
            <tr>
            	<th>Quote ID</th>
                <th>Price</th>
                <th>Status</th>
                <th>Time Window</th>
                <th>ClientID</th>
            </tr>
            <c:forEach var="quote" items="${listQuote}">
                <tr style="text-align:center">
                	<td><c:out value="${quote.quoteID}" /></td>
                    <td><c:out value="${quote.initialPrice}" /></td>
                    <td><c:out value="${quote.status}" /></td>
                    <td><c:out value="${quote.timeWindow}" /></td>
                    <td><c:out value="${quote.clientID}" /></td>
                </tr>
            </c:forEach>
        </table>
	        <tr>
				<th>Response: </th>
				<td align="center" colspan="3">
					<input type="text" name="note" size="100"  value="" onfocus="this.value=''">
				</td>
			</tr>
        <input type="submit" value="Submit Response">
        <a href="login.jsp" target="_self">Return to Login Page</a>
    </form>
    
</body>
</html>
