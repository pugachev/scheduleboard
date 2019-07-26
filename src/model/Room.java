
package model;


public class Room {
    private String roomId;
    private String roomNo;
    
    private int buildingId;

	public String getRoomId() {
		return roomId;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomId(String id) {
		roomId = id;
	}

	public void setRoomNo(String no) {
		roomNo = no;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
}
