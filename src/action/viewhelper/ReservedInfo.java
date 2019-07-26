
package action.viewhelper;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import model.Reservation;

public class ReservedInfo {
	
	private Reservation reserved;
	private int building;
	
	//1)派生属性 
	private Calendar cal;
	
	public ReservedInfo(){
	}
	
	public ReservedInfo(Reservation r){
		setReserved(r);
	}
	
	public boolean getReserved(){
    //2)メソッド名について
		if(reserved != null){
			return true;
		}
		return false;
	}
	
	public String getReserveInfo(){
		//3)ツールチップに表示する値
		if(!getReserved()){
			return "";
		}
		
		StringBuffer info = new StringBuffer(reserved.getContent());
		info.append(":");
		info.append(reserved.getPerson());
		
		return info.toString();
	}
	
	public void setReserved(Reservation r) {
		reserved = r;
		cal = Calendar.getInstance();
		cal.setTime(reserved.getDate());
	}
	
	public Map getParams(){
		//4)予約更新、削除画面への引継ぎ情報
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("reserveId",String.valueOf(reserved.getReserveId()));
		map.put("building",String.valueOf(building));
		map.put("status",String.valueOf(1));
		return map;
	}
	
	public String getRoomNo() {
		return reserved.getRoom().getRoomNo();
	}
	
	public String getReservedPerson(){
		return reserved.getPerson();
	}
	
	public String getContent(){
		return reserved.getContent();
	}
	
	public String getRoomId(){
		return reserved.getRoom().getRoomId();
	}
	
	public int getYear(){
		return cal.get(Calendar.YEAR);
	}
	
	public int getMonth(){
		return cal.get(Calendar.MONTH)+1;
	}
	
	public int getDay(){
		return cal.get(Calendar.DATE);
	}
	
	public int getStart(){
		return reserved.getStart();
	}
	
	public int getEnd(){
		return reserved.getEnd();
	}
	public int getBuilding() {
		return building;
	}
	public void setBuilding(int building) {
		this.building = building;
	}
}
