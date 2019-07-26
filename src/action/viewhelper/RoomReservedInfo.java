package action.viewhelper;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.Reservation;
import model.Room;

public class RoomReservedInfo {
    private Room room;

    private ReservedInfo[] reservedList;

    private Date date;

    public RoomReservedInfo(Room room, Date date, int rangeCount) {
        this.room = room;
        this.date = date;

        //1)領域の数だけReservedInfoクラスを生成する
        reservedList = new ReservedInfo[rangeCount];
        for (int i = 0; i < rangeCount; i++) {
            reservedList[i] = new ReservedInfo();
            reservedList[i].setBuilding(room.getBuildingId());
        }
    }

    public String getRoomNo() {
        return room.getRoomNo();
    }

    public ReservedInfo[] getReservedInfos() {
        return reservedList;
    }

    public Map getParams() {
        //2)予約登録画面への引継ぎ情報
        Map<String,String> map = new HashMap<String,String>();

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        map.put("roomId", room.getRoomId());
        map.put("year", String.valueOf(cal.get(Calendar.YEAR)));
        map.put("month", String.valueOf(cal.get(Calendar.MONTH) + 1));
        map.put("day", String.valueOf(cal.get(Calendar.DATE)));
        map.put("building", String.valueOf(room.getBuildingId()));
        map.put("status", String.valueOf(0));

        return map;
    }

    public void setReservedList(Reservation[] reserveds) {
        //3)予約とReservedInfoクラスを結びつける
        if (reserveds == null) {
            return;
        }

        for (int i = 0; i < reserveds.length; i++) {
            Reservation res = (Reservation) reserveds[i];
            int[] range = getRangesFromReserved(res);
            for (int j = 0; j < range.length; j++) {
                reservedList[range[j]].setReserved(res);
            }
        }

    }

    private int[] getRangesFromReserved(Reservation res) {

        //4)予約と結びつける時間帯の一覧を作成する
        int size = res.getEnd() - res.getStart();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = res.getStart() + i;
        }

        return result;
    }

}