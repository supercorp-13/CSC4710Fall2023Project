public class Bills
{
	protected String billID;
	protected String orderID; //foreign
	protected String price;
	protected String discount;
	protected String balance;
	protected String status;
	
	
	//Constructors
	public Bills() {}
	
	public Bills(String billID)
	{
		this.billID = billID;
	}
	
	public Bills(String billID, String orderID, String price, String discount, String balance, String status)
	{
		this(orderID, price, discount, balance, status);
		this.billID = billID;
	}
	
	public Bills(String orderID, String price, String discount, String balance, String status)
	{
		this.orderID = orderID;		this.price = price;		this.discount = discount;
		this.balance = balance;		this.status = status;
	}
	
	 // Getters and Setters
    public String getBillID() 
    {
        return billID;
    }

    public void setBillID(String billID) 
    {
        this.billID = billID;
    }

    public String getOrderID() 
    {
        return orderID;
    }

    public void setOrderID(String orderID) 
    {
        this.orderID = orderID;
    }

    public String getPrice() 
    {
        return price;
    }

    public void setPrice(String price) 
    {
        this.price = price;
    }

    public String getDiscount() 
    {
        return discount;
    }

    public void setDiscount(String discount) 
    {
        this.discount = discount;
    }

    public String getBalance() 
    {
        return balance;
    }

    public void setBalance(String balance) 
    {
        this.balance = balance;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }
}