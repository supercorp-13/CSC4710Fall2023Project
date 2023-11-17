import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;


public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private userDAO userDAO = new userDAO();
	    private String currentUser;
	    private HttpSession session=null;
	    
	    public ControlServlet()
	    {
	    	
	    }
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	currentUser= "";
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
	    try {
        	switch(action) {  
        	case "/login":
        		login(request,response);
        		break;
        	case "/register":
        		register(request, response);
        		break;
        	case "/initialQuote":
        		initialQuote(request, response);
        		break;
        	case "/initialRequest":
        		initialRequest(request, response);
        		break;
        	case "/initialize":
        		userDAO.init();
        		System.out.println("Database successfully initialized!");
        		rootPage(request,response,"");
        		break;
        	case "/root":
        		rootPage(request,response, "");
        		break;
        	case "/davidSmith":
        		davidSmithDashBoard(request, response, "");
        		break;
        	case "/logout":
        		logout(request,response);
        		break;
        	case "/list": 
                System.out.println("The action is: list");
                listUser(request, response);           	
                break;
        	case "/listTree":
        		System.out.println("The action is: listTree");
        		listTree(request, response);
        		break;
        	case "/listQuote":
        		System.out.println("The action is: listQuote");
        		listQuote(request, response);
        		break;
        	case "/listQuoteMessages":
        		System.out.println("The action is: listQuoteMessages");
        		listQuoteMessages(request, response);
        		break;
        	case "/listOrder":
        		System.out.println("The action is: listOrder");
        		listOrders(request, response);
        		break;
        	case "/listBills":
        		System.out.println("The action is: listBills");
        		listBills(request, response);
        		break;
        	case "/listBillMessages":
        		System.out.println("The action is: listBillMessages");
        		listBillMessages(request, response);
        		break;
        	case "/respondQuotes":
	        	System.out.println("The action is: respondQuote");
	    		respondQuotes(request, response);
	    		break;
	    	}
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
        	
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<user> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listPeople finished: 111111111111111111111111111111111111");
	    }
	    
	    private void listTree(HttpServletRequest request, HttpServletResponse response)
	    		throws SQLException, IOException, ServletException {
	    	System.out.println("listTree started: 00000000000000000000000000000000000");
	    	
	    	List<Tree> listTree = userDAO.listAllTrees();
	    	request.setAttribute("listTree", listTree);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("rootView.jsp");
	    	dispatcher.forward(request, response);
	    	
	    	System.out.println("listTree finished: 111111111111111111111111111111111111");
	    }
	    
	    private void listQuote(HttpServletRequest request, HttpServletResponse response)
	    		throws SQLException, IOException, ServletException {
	    	System.out.println("listQuote started: 00000000000000000000000000000000000");
	    	
	    	List<Quote> listQuote = userDAO.listAllQuotes();
	    	request.setAttribute("listQuote", listQuote);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("rootView.jsp");
	    	dispatcher.forward(request, response);
	    	
	    	System.out.println("listQuote finished: 111111111111111111111111111111111111");
	    }
	    
	    private void listQuoteMessages(HttpServletRequest request, HttpServletResponse response)
	    		throws SQLException, IOException, ServletException {
	    	System.out.println("listQuoteMessages started: 00000000000000000000000000000000000");
	    	
	    	List<QuoteMessages> listQuoteMessages = userDAO.listAllQuoteMessages();
	    	request.setAttribute("listQuoteMessages", listQuoteMessages);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("rootView.jsp");
	    	dispatcher.forward(request, response);
	    	
	    	System.out.println("listQuoteMessages finished: 111111111111111111111111111111111111");
	    }
	    
	    private void listOrders(HttpServletRequest request, HttpServletResponse response)
	    		throws SQLException, IOException, ServletException {
	    	System.out.println("listOrders started: 00000000000000000000000000000000000");
	    	
	    	List<Order> listOrders = userDAO.listAllOrders();
	    	request.setAttribute("listOrders", listOrders);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("rootView.jsp");
	    	dispatcher.forward(request, response);
	    	
	    	System.out.println("listOrders finished: 111111111111111111111111111111111111");
	    }
	    
	    private void listBills(HttpServletRequest request, HttpServletResponse response)
	    		throws SQLException, IOException, ServletException {
	    	System.out.println("listBills started: 00000000000000000000000000000000000");
	    	
	    	List<Bills> listBills = userDAO.listAllBills();
	    	request.setAttribute("listBills", listBills);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("rootView.jsp");
	    	dispatcher.forward(request, response);
	    	
	    	System.out.println("listBills finished: 111111111111111111111111111111111111");
	    }
	    
	    private void listBillMessages(HttpServletRequest request, HttpServletResponse response)
	    		throws SQLException, IOException, ServletException {
	    	System.out.println("listBillMessages started: 00000000000000000000000000000000000");
	    	
	    	List<BillMessages> listBillMessages = userDAO.listAllBillMessages();
	    	request.setAttribute("listBillMessages", listBillMessages);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("rootView.jsp");
	    	dispatcher.forward(request, response);
	    	
	    	System.out.println("listBills finished: 111111111111111111111111111111111111");
	    }
	    
	    private void rootPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root view");
			request.setAttribute("listUser", userDAO.listAllUsers());
			request.setAttribute("listTree", userDAO.listAllTrees());
			request.setAttribute("listQuote", userDAO.listAllQuotes());
			request.setAttribute("listQuoteMessages", userDAO.listAllQuoteMessages());
			request.setAttribute("listOrders", userDAO.listAllOrders());
			request.setAttribute("listBills", userDAO.listAllBills());
			request.setAttribute("listBillMessages", userDAO.listAllBillMessages());
	    	request.getRequestDispatcher("rootView.jsp").forward(request, response);
	    }
	    
	    private void davidSmithDashBoard(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	List<Tree> listTreeWithoutQuote = userDAO.listTreesWithoutQuote();
	        request.setAttribute("listTreeWithoutQuote", listTreeWithoutQuote);
	    	request.getRequestDispatcher("davidSmithDashboard.jsp").forward(request, response);
	    }
	    
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	 String email = request.getParameter("email");
	    	 String password = request.getParameter("password");
	    	 
	    	 if (email.equals("root") && password.equals("root1234")) {
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("username", email);
				 rootPage(request, response, "");
	    	 }
	    	 
	    	 else if(email.equals("david@gmail.com") && password.equals("david1234"))
	    	 {
	    		 System.out.println("Welcome David Smith! Redirecing to your dashboard");
	    		 session = request.getSession();
	    		 session.setAttribute("username", email);
	    		 davidSmithDashBoard(request, response, "");
	    	 }
	    	 
	    	 else if(userDAO.isValid(email, password)) 
	    	 {
			 	 
			 	 currentUser = email;
			 	 session = request.getSession();
			 	 session.setAttribute("username", email);
				 System.out.println("Login Successful! Redirecting");
				 String clientID = userDAO.getClientIDByEmail(email);
					 if (userDAO.quoteisValid(clientID)) {
						 System.out.println("I'm here");
						 request.getRequestDispatcher("respondQuote.jsp").forward(request, response);
					 } 
					 
					 else {
						 System.out.println("Sike I'm here");
						 request.getRequestDispatcher("activitypage.jsp").forward(request, response);
					 }
				 }
		
	    	 else {
	    		 request.setAttribute("loginFailedStr","Login Failed: Wrong password or username.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }}
	    
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String id = String.valueOf(request.getParameter("id"));
	    	String email = request.getParameter("email");
	   	 	String firstName = request.getParameter("firstName");
	   	 	String lastName = request.getParameter("lastName");
	   	 	String password = request.getParameter("password");
	   	 	String ccNum = request.getParameter("ccNum");
	   	    String phoneNumber = request.getParameter("phoneNumber");
	   	    String role = request.getParameter("role");
	   	 	String address_street_num = request.getParameter("address_street_num"); 
	   	 	String address_street = request.getParameter("address_street"); 
	   	 	String address_city = request.getParameter("address_city"); 
	   	 	String address_state = request.getParameter("address_state"); 
	   	 	String address_zip_code = request.getParameter("address_zip_code"); 	 
	   	 	String confirm = request.getParameter("confirmation");
	 
			
	   	 	
	   	 	if (password.equals(confirm)) {
	   	 		if (!userDAO.checkEmail(email)) {
		   	 		System.out.println("Registration Successful! Added to database");
		            user users = new user(id, email,firstName, lastName, password, ccNum, phoneNumber, role, address_street_num,  address_street,  address_city,  address_state,  address_zip_code);
		   	 		userDAO.insert(users);
		   	 		response.sendRedirect("login.jsp");
	   	 		}
		   	 	else {
		   	 		System.out.println("Username taken, please enter new username");
		    		 request.setAttribute("errorOne","Registration failed: Username taken, please enter a new username.");
		    		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	   	 	else {
	   	 		System.out.println("Password and Password Confirmation do not match");
	   		 request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
	   		 request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	    }   
	    
	    private void initialQuote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String initialPrice = request.getParameter("initialPrice");
	    	String timeWindow = request.getParameter("timeWindow");
	    	String treeID = request.getParameter("treeID");
	    	if (treeID == null || treeID.isEmpty()) {
	    	    request.setAttribute("errorMessage", "Tree ID is required.");
	    	    request.getRequestDispatcher("registerQuote.jsp").forward(request, response);
	    	    return;
	    	    }
	        String status = request.getParameter("status");
	        if (status == null || status.isEmpty()) {
	            status = "pending";
	        }

	        String clientID = request.getParameter("clientID");
	        if (clientID == null || clientID.isEmpty()) {
	        }

	        String contractorID = request.getParameter("contractorID");
	        if (contractorID == null || contractorID.isEmpty()) {
	            contractorID = "1";
	        }
	        
	        if (initialPrice == null || initialPrice.isEmpty() ||
	        		timeWindow == null || timeWindow.isEmpty() || 
	        		        clientID == null || clientID.isEmpty()) {

		            request.setAttribute("errorMessage", "All fields are required.");
		            request.getRequestDispatcher("registerQuote.jsp").forward(request, response);
		        } else {
		            Quote quote = new Quote(initialPrice, timeWindow, status, clientID, contractorID);
		            userDAO.insertQuote(quote, treeID);
		            
		            request.getSession().setAttribute("successMessage", "Request Submitted Successfully. Please wait for a response.");
		            davidSmithDashBoard(request, response, ""); 
		            //response.sendRedirect("davidSmithDashboard.jsp");
		        }
	    }
	    
	    private void respondQuotes(HttpServletRequest request, HttpServletResponse response) 
	    		throws ServletException, IOException {
	    	String quoteID = request.getParameter("quoteID");
	        String responseAction = request.getParameter("response");
	        String userID = (String) request.getSession().getAttribute("userID");

	        
	     
	        try {
	            if (quoteID == null || quoteID.isEmpty() || responseAction == null || responseAction.isEmpty()) {
	                request.setAttribute("errorMessage", "Quote ID and Response Action are required.");
	                request.getRequestDispatcher("respondQuote.jsp").forward(request, response);
	                return;
	            }
	            else {
	            	List<Quote> listQuote = userDAO.listQuote(userID);
	    	        request.setAttribute("listQuote", listQuote);
	            	String note = request.getParameter("note");
	                long time = System.currentTimeMillis();
	                Date dat = new Date(time);
	                GregorianCalendar gc, gc1, gc2 = new GregorianCalendar();
	                gc1 = new GregorianCalendar(); gc = new GregorianCalendar();
	                gc.setTime(dat); gc1.setTime(dat); gc2.setTime(dat);
	                java.text.SimpleDateFormat format, format1, format2 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                String msgTime = format.format(gc.getTime()); String scheduleStart = format1.format(gc.getTime()); String scheduleEnd = format2.format(gc.getTime());
	                Random rand = new Random();
	                int num = rand.nextInt(1250);
	                String price = Integer.toString(num);
	                QuoteMessages quoteMessage = new QuoteMessages(userID, quoteID, msgTime, price, scheduleStart, scheduleEnd, note);
	                userDAO.insertQuoteMessage(quoteMessage);
	                //request.getRequestDispatcher("respondQuote.jsp").forward(request, response);
	            }

	            request.getSession().setAttribute("successMessage", "Response to quote processed successfully.");
	            response.sendRedirect("respondQuote.jsp");
	        } catch (SQLException e) {
	            request.setAttribute("errorMessage", "Database access error: " + e.getMessage());
	            request.getRequestDispatcher("respondQuote.jsp").forward(request, response);
	        }
	    }
	    
	    private void initialRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException, SQLException {
	        String size = request.getParameter("size");
	        String height = request.getParameter("height");
	        String location = request.getParameter("location");
	        String proximity = request.getParameter("proximity");
	        String clientID = request.getParameter("clientID");
	        String quoteID = request.getParameter("quoteID");

	        if (size == null || size.isEmpty() ||
	            height == null || height.isEmpty() ||
	            location == null || location.isEmpty() ||
	            proximity == null || proximity.isEmpty() ||
	            clientID == null || clientID.isEmpty()) {

	            request.setAttribute("errorMessage", "All fields are required.");
	            request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	        } else {
	            Tree tree = new Tree(size, height, location, proximity, clientID, quoteID);
	            userDAO.insertTree(tree);
	            
	            request.getSession().setAttribute("successMessage", "Request Submitted Successfully. Please wait for a response.");
	            response.sendRedirect("activitypage.jsp");
	        }
	    }

	    
	    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        		response.sendRedirect("login.jsp");
        	}
	
	    

	     
        
	    
	    
	    
	    
	    
}
	        
	        
	    
	        
	        
	        
	    


