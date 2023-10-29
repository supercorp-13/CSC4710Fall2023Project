import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/userDAO")
public class userDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public userDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?allowPublicKeyRetrieval=true&useSSL=false&user=john&password=pass1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		connect_func("root","pass1234");
    		String sql = "select * from user where email = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, email);
    		ResultSet rs = preparedStatement.executeQuery();
    		return rs.next();
    	}
    	catch(SQLException e) {
    		System.out.println("failed login");
    		return false;
    	}
    }
	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/userdb?"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }
    
    public List<user> listAllUsers() throws SQLException {
        List<user> listUser = new ArrayList<user>();        
        String sql = "SELECT * FROM User";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String password = resultSet.getString("password");
            String credit_card_num = resultSet.getString("credit_card_num");
            String address_street_num = resultSet.getString("address_street_num"); 
            String address_street = resultSet.getString("address_street"); 
            String address_city = resultSet.getString("address_city"); 
            String address_state = resultSet.getString("address_state"); 
            String address_zip_code = resultSet.getString("address_zip_code"); 
            long phone_num = resultSet.getLong("phone_num");

             
            user users = new user(email,firstName, lastName, password, credit_card_num, address_street_num,  address_street,  address_city,  address_state,  address_zip_code, phone_num);
            listUser.add(users);
        }        
        resultSet.close();
        disconnect();        
        return listUser;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(user users) throws SQLException {
    	connect_func("root","pass1234");         
		String sql = "insert into User(email, firstName, lastName, password, credit_card_num,address_street_num, address_street,address_city,address_state,address_zip_code,phone_num) values ( ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, users.getEmail());
			preparedStatement.setString(2, users.getFirstName());
			preparedStatement.setString(3, users.getLastName());
			preparedStatement.setString(4, users.getPassword());
			preparedStatement.setString(5, users.getCredit_card_num());
			preparedStatement.setString(6, users.getAddress_street_num());		
			preparedStatement.setString(7, users.getAddress_street());		
			preparedStatement.setString(8, users.getAddress_city());		
			preparedStatement.setString(9, users.getAddress_state());		
			preparedStatement.setString(10, users.getAddress_zip_code());		
			preparedStatement.setLong(11, users.getPhone_num());			

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(String email) throws SQLException {
        String sql = "DELETE FROM User WHERE email = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(user users) throws SQLException {
        String sql = "update User set firstName=?, lastName =?,password = ?,credit_card_num=?,address_street_num =?, address_street=?,address_city=?,address_state=?,address_zip_code=?, phone_num=?, where email = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, users.getEmail());
		preparedStatement.setString(2, users.getFirstName());
		preparedStatement.setString(3, users.getLastName());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getCredit_card_num());
		preparedStatement.setString(6, users.getAddress_street_num());		
		preparedStatement.setString(7, users.getAddress_street());		
		preparedStatement.setString(8, users.getAddress_city());		
		preparedStatement.setString(9, users.getAddress_state());		
		preparedStatement.setString(10, users.getAddress_zip_code());		
		preparedStatement.setLong(11, users.getPhone_num());		
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public user getUser(String email) throws SQLException {
    	user user = null;
        String sql = "SELECT * FROM User WHERE email = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String password = resultSet.getString("password");
            String credit_card_num = resultSet.getString("credit_card_num");
            String address_street_num = resultSet.getString("address_street_num"); 
            String address_street = resultSet.getString("address_street"); 
            String address_city = resultSet.getString("address_city"); 
            String address_state = resultSet.getString("address_state"); 
            String address_zip_code = resultSet.getString("address_zip_code"); 
            long phone_num = resultSet.getLong("phone_num");
            user = new user(email, firstName, lastName, password, credit_card_num, address_street_num,  address_street,  address_city,  address_state,  address_zip_code,phone_num);
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }
    
    public boolean checkEmail(String email) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE email = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkPassword(String password) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE password = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
       	return checks;
    }
    
    
    
    public boolean isValid(String email, String password) throws SQLException
    {
    	String sql = "SELECT * FROM User";
    	connect_func();
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	resultSet.last();
    	
    	int setSize = resultSet.getRow();
    	resultSet.beforeFirst();
    	
    	for(int i = 0; i < setSize; i++)
    	{
    		resultSet.next();
    		if(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
    			return true;
    		}		
    	}
    	return false;
    }
    
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"drop database if exists testdb; ",
					        "create database testdb; ",
					        "use testdb; ",
					        "drop table if exists User; ",
					        ("CREATE TABLE if not exists User( " +
					        	"clientID int NOT NULL auto_increment, " +
					            "email VARCHAR(50) NOT NULL, " + 
					            "firstName VARCHAR(10) NOT NULL, " +
					            "lastName VARCHAR(10) NOT NULL, " +
					            "password VARCHAR(20) NOT NULL, " +
					            "credit_card_num VARCHAR(16) NOT NULL, " +
					            "address_street_num VARCHAR(4) , "+ 
					            "address_street VARCHAR(30) , "+ 
					            "address_city VARCHAR(20)," + 
					            "address_state VARCHAR(2),"+ 
					            "address_zip_code VARCHAR(5),"+ 
					            "phone_num BIGINT(15) NOT NULL,"+ 
					            "PRIMARY KEY (clientID) "+"); ")
        					};
        
        
        String[] TUPLES = {("insert into User(email, firstName, lastName, password, credit_card_num, address_street_num, address_street, address_city, address_state, address_zip_code, phone_num)"+
    			"values ('susie@gmail.com', 'Susie ', 'Guzman', 'susie1234', '1234567890123456', '1234', 'whatever street', 'detroit', 'MI', '48202','3136583920'),"+
		    		 	"('don@gmail.com', 'Don', 'Cummings','don123', '5184978162453198', '1000', 'hi street', 'mama', 'MO', '12345','2489874865'),"+
		    	 	 	"('margarita@gmail.com', 'Margarita', 'Lawson','margarita1234', '9102368749512348', '1234', 'ivan street', 'tata','CO','12561','7749876185'),"+
		    		 	"('jo@gmail.com', 'Jo', 'Brady','jo1234', '1108697198462194', '3214','marko street', 'brat', 'DU', '54321','5869781103'),"+
		    		 	"('wallace@gmail.com', 'Wallace', 'Moore','wallace1234', '6481975369452094', '4500', 'frey street', 'sestra', 'MI', '48202','2485919874'),"+
		    		 	"('amelia@gmail.com', 'Amelia', 'Phillips','amelia1234', '5169847163059784', '1245', 'm8s street', 'baka', 'IL', '48000','3136549103'),"+
		    			"('sophie@gmail.com', 'Sophie', 'Pierce','sophie1234', '5648456449561567', '2468', 'yolos street', 'ides', 'CM', '24680','3139745198'),"+
		    			"('angelo@gmail.com', 'Angelo', 'Francis','angelo1234', '5614138989711567', '4680', 'egypt street', 'lolas', 'DT', '13579','5869981347'),"+
		    			"('rudy@gmail.com', 'Rudy', 'Smith','rudy1234', '9987546981302597', '1234', 'sign street', 'samo ne tu','MH', '09876','2485563279'),"+
		    			"('jeannette@gmail.com', 'Jeannette ', 'Stone','jeannette1234', '5648169871256478', '0981', 'snoop street', 'kojik', 'HW', '87654','2489126478'),"+
		    			"('root', 'default', 'default','pass1234', 'default', '0000', 'Default', 'Default', '0', '00000','1000');")
		    			};
        
        
       
        String[] INITIAL2 = {"use testdb; ",
					        "drop table if exists User2; ",
					        ("CREATE TABLE if not exists User2( " +
					        	"clientID int NOT NULL auto_increment, " +
					            "email VARCHAR(50) NOT NULL, " + 
					            "firstName VARCHAR(10) NOT NULL, " +
					            "lastName VARCHAR(10) NOT NULL, " +
					            "password VARCHAR(20) NOT NULL, " +
					            "credit_card_num VARCHAR(16) NOT NULL, " +
					            "address_street_num VARCHAR(4) , "+ 
					            "address_street VARCHAR(30) , "+ 
					            "address_city VARCHAR(20)," + 
					            "address_state VARCHAR(2),"+ 
					            "address_zip_code VARCHAR(5),"+ 
					            "phone_num BIGINT(15) NOT NULL,"+ 
					            "PRIMARY KEY (clientID) "+"); ")
							};

        String[] TUPLES2 = {("insert into User2(email, firstName, lastName, password, credit_card_num, address_street_num, address_street, address_city, address_state, address_zip_code, phone_num)"+
    			"values ('john@gmail.com', 'john ', 'Guzman', 'joe1234', '1234567890123456', '1234', 'whatever street', 'detroit', 'MI', '48202','3136583920'),"+
		    		 	"('julio@gmail.com', 'julio', 'Cummings','julio123', '5184978162453198', '1000', 'hi street', 'mama', 'MO', '12345','2489874865'),"+
		    	 	 	"('jules@gmail.com', 'jules', 'Lawson','jules1234', '9102368749512348', '1234', 'ivan street', 'tata','CO','12561','7749876185'),"+
		    		 	"('bo@gmail.com', 'bo', 'Brady','bo1234', '1108697198462194', '3214','marko street', 'brat', 'DU', '54321','5869781103'),"+
		    		 	"('cheese@gmail.com', 'cheese', 'Moore','cheese1234', '6481975369452094', '4500', 'frey street', 'sestra', 'MI', '48202','2485919874'),"+
		    		 	"('ham@gmail.com', 'ham', 'Phillips','ham1234', '5169847163059784', '1245', 'm8s street', 'baka', 'IL', '48000','3136549103'),"+
		    			"('napkin@gmail.com', 'napkin', 'Pierce','napkin1234', '5648456449561567', '2468', 'yolos street', 'ides', 'CM', '24680','3139745198'),"+
		    			"('lolo@gmail.com', 'lolo', 'Francis','lolo1234', '5614138989711567', '4680', 'egypt street', 'lolas', 'DT', '13579','5869981347'),"+
		    			"('park@gmail.com', 'park', 'Smith','park1234', '9987546981302597', '1234', 'sign street', 'samo ne tu','MH', '09876','2485563279'),"+
		    			"('shark@gmail.com', 'shark ', 'Stone','jshark1234', '5648169871256478', '0981', 'snoop street', 'kojik', 'HW', '87654','2489126478');")
		    			};
        
        
		String[] INITIAL3 = {"use testdb; ",
		        "drop table if exists User3; ",
		        ("CREATE TABLE if not exists User3( " +
		        	"clientID int NOT NULL auto_increment, " +
		            "email VARCHAR(50) NOT NULL, " + 
		            "firstName VARCHAR(10) NOT NULL, " +
		            "lastName VARCHAR(10) NOT NULL, " +
		            "password VARCHAR(20) NOT NULL, " +
		            "credit_card_num VARCHAR(16) NOT NULL, " +
		            "address_street_num VARCHAR(4) , "+ 
		            "address_street VARCHAR(30) , "+ 
		            "address_city VARCHAR(20)," + 
		            "address_state VARCHAR(2),"+ 
		            "address_zip_code VARCHAR(5),"+ 
		            "phone_num BIGINT(15) NOT NULL,"+ 
		            "PRIMARY KEY (clientID) "+"); ")
				};


		String[] TUPLES3 = {("insert into User3(email, firstName, lastName, password, credit_card_num, address_street_num, address_street, address_city, address_state, address_zip_code, phone_num)"+
			"values ('elite@gmail.com', 'elite ', 'Guzman', 'elite1234', '1234567890123456', '1234', 'whatever street', 'detroit', 'MI', '48202','3136583920'),"+
				 	"('nivea@gmail.com', 'nivea', 'Cummings','nivea123', '5184978162453198', '1000', 'hi street', 'mama', 'MO', '12345','2489874865'),"+
			 	 	"('ps5@gmail.com', 'ps4', 'Lawson','ps41234', '9102368749512348', '1234', 'ivan street', 'tata','CO','12561','7749876185'),"+
				 	"('ca@gmail.com', 'ca', 'Brady','ca1234', '1108697198462194', '3214','marko street', 'brat', 'DU', '54321','5869781103'),"+
				 	"('complete@gmail.com', 'complete', 'Moore','complete1234', '6481975369452094', '4500', 'frey street', 'sestra', 'MI', '48202','2485919874'),"+
				 	"('home@gmail.com', 'home', 'Phillips','home1234', '5169847163059784', '1245', 'm8s street', 'baka', 'IL', '48000','3136549103'),"+
					"('multi@gmail.com', 'multi', 'Pierce','multi1234', '5648456449561567', '2468', 'yolos street', 'ides', 'CM', '24680','3139745198'),"+
					"('vitamins@gmail.com', 'vitamins', 'Francis','vitamins1234', '5614138989711567', '4680', 'egypt street', 'lolas', 'DT', '13579','5869981347'),"+
					"('jeol@gmail.com', 'jeol', 'Smith','jeol1234', '9987546981302597', '1234', 'sign street', 'samo ne tu','MH', '09876','2485563279'),"+
					"('wallet@gmail.com', 'wallet ', 'Stone','wallet1234', '5648169871256478', '0981', 'snoop street', 'kojik', 'HW', '87654','2489126478');")
					};
		
		String[] INITIAL4 = {"use testdb; ",
		        "drop table if exists User4; ",
		        ("CREATE TABLE if not exists User4( " +
		        	"clientID int NOT NULL auto_increment, " +
		            "email VARCHAR(50) NOT NULL, " + 
		            "firstName VARCHAR(10) NOT NULL, " +
		            "lastName VARCHAR(10) NOT NULL, " +
		            "password VARCHAR(20) NOT NULL, " +
		            "credit_card_num VARCHAR(16) NOT NULL, " +
		            "address_street_num VARCHAR(4) , "+ 
		            "address_street VARCHAR(30) , "+ 
		            "address_city VARCHAR(20)," + 
		            "address_state VARCHAR(2),"+ 
		            "address_zip_code VARCHAR(5),"+ 
		            "phone_num BIGINT(15) NOT NULL,"+ 
		            "PRIMARY KEY (clientID) "+"); ")
				};


		String[] TUPLES4 = {("insert into User4(email, firstName, lastName, password, credit_card_num, address_street_num, address_street, address_city, address_state, address_zip_code, phone_num)"+
			"values ('jaleca@gmail.com', 'jaleca ', 'Guzman', 'jaleca1234', '1234567890123456', '1234', 'whatever street', 'detroit', 'MI', '48202','3136583920'),"+
				 	"('barnes@gmail.com', 'barnes', 'Cummings','barnes123', '5184978162453198', '1000', 'hi street', 'mama', 'MO', '12345','2489874865'),"+
			 	 	"('chicken@gmail.com', 'chicken', 'Lawson','chicken1234', '9102368749512348', '1234', 'ivan street', 'tata','CO','12561','7749876185'),"+
				 	"('own@gmail.com', 'own', 'Brady','own1234', '1108697198462194', '3214','marko street', 'brat', 'DU', '54321','5869781103'),"+
				 	"('hotdog@gmail.com', 'hotdog', 'Moore','hotdog1234', '6481975369452094', '4500', 'frey street', 'sestra', 'MI', '48202','2485919874'),"+
				 	"('watch@gmail.com', 'watch', 'Phillips','watch1234', '5169847163059784', '1245', 'm8s street', 'baka', 'IL', '48000','3136549103'),"+
					"('chewable@gmail.com', 'chewable', 'Pierce','chewable1234', '5648456449561567', '2468', 'yolos street', 'ides', 'CM', '24680','3139745198'),"+
					"('water@gmail.com', 'water', 'Francis','water1234', '5614138989711567', '4680', 'egypt street', 'lolas', 'DT', '13579','5869981347'),"+
					"('joel@gmail.com', 'joel', 'Smith','joel1234', '9987546981302597', '1234', 'sign street', 'samo ne tu','MH', '09876','2485563279'),"+
					"('handbag@gmail.com', 'handbag ', 'Stone','handbag1234', '5648169871256478', '0981', 'snoop street', 'kojik', 'HW', '87654','2489126478');")
					};
		
		String[] INITIAL5 = {"use testdb; ",
		        "drop table if exists User5; ",
		        ("CREATE TABLE if not exists User5( " +
		        	"clientID int NOT NULL auto_increment, " +
		            "email VARCHAR(50) NOT NULL, " + 
		            "firstName VARCHAR(10) NOT NULL, " +
		            "lastName VARCHAR(10) NOT NULL, " +
		            "password VARCHAR(20) NOT NULL, " +
		            "credit_card_num VARCHAR(16) NOT NULL, " +
		            "address_street_num VARCHAR(4) , "+ 
		            "address_street VARCHAR(30) , "+ 
		            "address_city VARCHAR(20)," + 
		            "address_state VARCHAR(2),"+ 
		            "address_zip_code VARCHAR(5),"+ 
		            "phone_num BIGINT(15) NOT NULL,"+ 
		            "PRIMARY KEY (clientID) "+"); ")
				};


		String[] TUPLES5 = {("insert into User5(email, firstName, lastName, password, credit_card_num, address_street_num, address_street, address_city, address_state, address_zip_code, phone_num)"+
			"values ('bun@gmail.com', 'bun ', 'Guzman', 'bun1234', '1234567890123456', '1234', 'whatever street', 'detroit', 'MI', '48202','3136583920'),"+
				 	"('nun@gmail.com', 'nun', 'Cummings','nun123', '5184978162453198', '1000', 'hi street', 'mama', 'MO', '12345','2489874865'),"+
			 	 	"('cun@gmail.com', 'cun', 'Lawson','cun1234', '9102368749512348', '1234', 'ivan street', 'tata','CO','12561','7749876185'),"+
				 	"('sun@gmail.com', 'sun', 'Brady','sun1234', '1108697198462194', '3214','marko street', 'brat', 'DU', '54321','5869781103'),"+
				 	"('dun@gmail.com', 'dun', 'Moore','dun1234', '6481975369452094', '4500', 'frey street', 'sestra', 'MI', '48202','2485919874'),"+
				 	"('hun@gmail.com', 'hun', 'Phillips','hun1234', '5169847163059784', '1245', 'm8s street', 'baka', 'IL', '48000','3136549103'),"+
					"('yun@gmail.com', 'yun', 'Pierce','yun1234', '5648456449561567', '2468', 'yolos street', 'ides', 'CM', '24680','3139745198'),"+
					"('fun@gmail.com', 'fun', 'Francis','fun1234', '5614138989711567', '4680', 'egypt street', 'lolas', 'DT', '13579','5869981347'),"+
					"('lun@gmail.com', 'lun', 'Smith','lun1234', '9987546981302597', '1234', 'sign street', 'samo ne tu','MH', '09876','2485563279'),"+
					"('pun@gmail.com', 'pun ', 'Stone','pun1234', '5648169871256478', '0981', 'snoop street', 'kojik', 'HW', '87654','2489126478');")
					};
		
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        
        for (int i = 0; i < INITIAL2.length; i++)
        	statement.execute(INITIAL2[i]);
        
        for (int i = 0; i < TUPLES2.length; i++)	
        	statement.execute(TUPLES2[i]);
        
        for (int i = 0; i < INITIAL3.length; i++)
        	statement.execute(INITIAL3[i]);
        
        for (int i = 0; i < TUPLES3.length; i++)	
        	statement.execute(TUPLES3[i]);
        
        for (int i = 0; i < INITIAL4.length; i++)
        	statement.execute(INITIAL4[i]);
        
        for (int i = 0; i < TUPLES4.length; i++)	
        	statement.execute(TUPLES4[i]);
        
        for (int i = 0; i < INITIAL5.length; i++)
        	statement.execute(INITIAL5[i]);
        
        for (int i = 0; i < TUPLES5.length; i++)	
        	statement.execute(TUPLES5[i]);
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
