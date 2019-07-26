
package model;

import java.util.ArrayList;
import java.util.List;

public class Building {
	private int id;
	private String name;
	
	private List<Room> rooms;
	
	public Building(){
		rooms = new ArrayList<Room>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setRooms(List<Room> rooms){
		this.rooms = rooms;
	}
	
	public Room[] getAllRooms(){
		Room[] allRooms = new Room[rooms.size()];
		rooms.toArray(allRooms);
		
		return allRooms;
	}
	
	public Room getRoom(String id){
		if(id == null){
			return null;
		}
		
		for(int i=0;i<rooms.size();i++){
			Room room = rooms.get(i);
			if(id.equals(room.getRoomId())){
				return room;
			}
		}
		
		return null;
	}

}