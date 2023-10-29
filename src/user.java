public class user 
{
		protected String password;
	 	protected String email;
	    protected String firstName;
	    protected String lastName;
	    protected String address_street_num;
	    protected String address_street;
	    protected String address_city;
	    protected String address_state;
	    protected String address_zip_code;
	    protected String credit_card_num;
	    protected long phone_num;
	 
	    //constructors
	    public user() {
	    }
	 
	    public user(String email) 
	    {
	        this.email = email;
	    }
	    
	    public user(String email,String firstName, String lastName, String password,String credit_card_num, String address_street_num, String address_street, String address_city, String address_state,String address_zip_code, long phone_num) 
	    {
	    	this(firstName,lastName,password,credit_card_num, address_street_num,  address_street,  address_city,  address_state,  address_zip_code,phone_num);
	    	this.email = email;
	    }
	 
	
	    public user(String firstName, String lastName, String password,String credit_card_num, String address_street_num, String address_street, String address_city, String address_state,String address_zip_code, long phone_num) 
	    {
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.password = password;
	        this.credit_card_num = credit_card_num;
	        this.address_street_num = address_street_num;
	        this.address_street = address_street;
	        this.address_city= address_city;
	        this.address_state = address_state;
	        this.address_zip_code = address_zip_code;
	        this.phone_num = phone_num;
	    }
	    
	   //getter and setter methods
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	  
	    public String getCredit_card_num() {
	    	return credit_card_num;
	    }
	    public void setCredit_card_num(String credit_card_num) {
	    	this.credit_card_num = credit_card_num;
	    }
	    
	    public String getAddress_street_num() {
	        return address_street_num;
	    }
	    public void setAddress_street_num(String address_street_num) {
	        this.address_street_num = address_street_num;
	    }
	    public String getAddress_street() {
	        return address_street;
	    }
	    public void setAddress_street(String address_street) {
	        this.address_street = address_street;
	    }
	    public String getAddress_city() {
	        return address_city;
	    }
	    public void setAddress_city(String address_city) {
	        this.address_city = address_city;
	    }
	    public String getAddress_state() {
	        return address_state;
	    }
	    public void setAddress_state(String address_state) {
	        this.address_state = address_state;
	    }
	    public String getAddress_zip_code() {
	        return address_zip_code;
	    }
	    public void setAddress_zip_code(String address_zip_code) {
	        this.address_zip_code = address_zip_code;
	    }
	    
	    public long getPhone_num() {
	    	return phone_num;
	    }
	    public void setPhone_num(long phone_num) {
	    	this.phone_num = phone_num;
	    }
	    
	    
	}