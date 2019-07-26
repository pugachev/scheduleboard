
package model;

import java.util.Date;

public class Reservation {
	
    private int reserveId;
    
    private Room room;
    
    private Date date;
    private String person;
    private String content;
    
    private int start;
    private int end;
    
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}

	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getReserveId() {
		return reserveId;
	}

  public void setReserveId(int id){
        reserveId = id;
  }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
}
