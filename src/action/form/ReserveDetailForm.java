
package action.form;

import org.apache.struts.action.ActionForm;

public class ReserveDetailForm extends ActionForm {
    //予約日付
    private int year;
    private int month;
    private int day;
    
    //予約範囲
    private int startRange;
    private int endRange;
    
    //予約者
    private String person;
    //予約内容
    private String content;
    
    //予約するビル番号
    private int building;
    //予約する部屋番号   
    private String roomId;
    
    //予約ID
    private int reserveId;
    //操作のステータス
    private int status;
    
    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getEndRange() {
        return endRange;
    }
    public void setEndRange(int endRange) {
        this.endRange = endRange;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public String getRoomId() {
        return roomId;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public int getStartRange() {
        return startRange;
    }
    public void setStartRange(int startRange) {
        this.startRange = startRange;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getBuilding() {
        return building;
    }
    public void setBuilding(int building) {
        this.building = building;
    }
    public int getReserveId() {
        return reserveId;
    }
    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }
    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
