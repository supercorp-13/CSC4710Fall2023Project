public class BillMessages {
    private String billMessageID; 
    private String userID;        //foreign
    private String billID;        //foreign
    private String msgTime;       
    private String price;         
    private String scheduleStart; 
    private String scheduleEnd;   
    private String note;          

    // Constructors
    public BillMessages() {
    }

    public BillMessages(String billMessageID) {
        this.billMessageID = billMessageID;
    }

    public BillMessages(String billMessageID, String userID, String billID, String msgTime, String price, String scheduleStart, String scheduleEnd, String note) {
        this.billMessageID = billMessageID;        this.userID = userID;        this.billID = billID;
        this.msgTime = msgTime;        this.price = price;        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;        this.note = note;
    }

    public BillMessages(String userID, String billID, String msgTime, String price, String scheduleStart, String scheduleEnd, String note) {
        this.userID = userID;        this.billID = billID;        this.msgTime = msgTime;
        this.price = price;        this.scheduleStart = scheduleStart;        this.scheduleEnd = scheduleEnd;
        this.note = note;
    }

    // Getters and setters
    public String getBillMessageID() {
        return billMessageID;
    }

    public void setBillMessageID(String billMessageID) {
        this.billMessageID = billMessageID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
