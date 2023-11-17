public class Order {
    protected String orderID;
    protected String quoteID; //foreign
    protected String price;   
    protected String scheduleStart; 
    protected String scheduleEnd;   

    // Constructors
    public Order() {
    }

    public Order(String orderID) {
        this.orderID = orderID;
    }

    public Order(String orderID, String quoteID, String price, String scheduleStart, String scheduleEnd) {
        this.orderID = orderID;        this.quoteID = quoteID;        this.price = price;
        this.scheduleStart = scheduleStart;        this.scheduleEnd = scheduleEnd;
    }

    public Order(String quoteID, String price, String scheduleStart, String scheduleEnd) {
        this.quoteID = quoteID;        this.price = price;
        this.scheduleStart = scheduleStart;        this.scheduleEnd = scheduleEnd;
    }

    // Getters and setters
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(String quoteID) {
        this.quoteID = quoteID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getScheduleStart() {
        return scheduleStart;
    }

    public void setScheduleStart(String scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    public String getScheduleEnd() {
        return scheduleEnd;
    }

    public void setScheduleEnd(String scheduleEnd) {
        this.scheduleEnd = scheduleEnd;
    }
}
