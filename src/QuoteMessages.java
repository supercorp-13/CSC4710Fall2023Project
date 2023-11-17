public class QuoteMessages
{
	protected String quoteMessageID;
	protected String userID; //foreign
	protected String quoteID; //foreign
	protected String msgTime;
	protected String price;
	protected String scheduleStart;
	protected String scheduleEnd;
	protected String note;
	
	//Constructors
	public QuoteMessages() {}
	
	public QuoteMessages(String quoteMessageID)
	{
		this.quoteMessageID = quoteMessageID;
	}
	
	public QuoteMessages(String quoteMessageID, String userID, String quoteID, String msgTime, String price, String scheduleStart, String scheduleEnd, String note)
	{
		this(userID, quoteID, msgTime, price, scheduleStart, scheduleEnd, note);
		this.quoteMessageID = quoteMessageID;
	}
	
	public QuoteMessages(String userID, String quoteID, String msgTime, String price, String scheduleStart, String scheduleEnd, String note)
	{
		this.userID = userID;		this.quoteID = quoteID;
		this.msgTime = msgTime;		this.price = price;
		this.scheduleStart = scheduleStart;		this.scheduleEnd = scheduleEnd;
		this.note = note;
	}
	
	// Getter and setter for quoteMessageID
    public String getQuoteMessageID() {
        return quoteMessageID;
    }

    public void setQuoteMessageID(String quoteMessageID) {
        this.quoteMessageID = quoteMessageID;
    }

    // Getter and setter for userID
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    // Getter and setter for quoteID
    public String getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(String quoteID) {
        this.quoteID = quoteID;
    }

    // Getter and setter for msgTime
    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    // Getter and setter for price
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    // Getter and setter for scheduleStart
    public String getScheduleStart() {
        return scheduleStart;
    }

    public void setScheduleStart(String scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    // Getter and setter for scheduleEnd
    public String getScheduleEnd() {
        return scheduleEnd;
    }

    public void setScheduleEnd(String scheduleEnd) {
        this.scheduleEnd = scheduleEnd;
    }

    // Getter and setter for note
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}