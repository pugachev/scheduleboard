
package logic;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.Reservation;
import model.Room;

import dao.DAOHelper;
import dao.ReservationDAO;

import logic.exception.RoomAlreadyReserveException;


public class ReserveLogic {

    private ReservationDAO dao;

    public ReserveLogic(){
         dao = DAOHelper.getReservationDAO();
    }

    public void entryReserve(Reservation r) throws Exception {

        if(checkAvailableReserve(r)){
            //1)重複する予約がないので予約を登録する
            dao.insertReserve(r);
        }else{
            throw new RoomAlreadyReserveException();
        }

    }

    private boolean checkAvailableReserve(Reservation r) throws SQLException{

        //2)予約できるかどうかを3つのSQLを実行して判定している
        boolean check = dao.checkEndPoint(r) && dao.checkStartPoint(r) && dao.checkThruReserve(r);
        return check;
    }

    public Reservation findReserve(int reserveId) throws SQLException{
        Reservation r = dao.getReserve(reserveId);
        return r;
    }

    public Reservation findReserve(Room room,Date date,int start) throws SQLException{

        Reservation[] rs = findReserves(room,date);

        //予約一覧から開始時間が一致するものを返す。
        for(int i=0;i<rs.length;i++){
            if(rs[i].getStart() == start){
                return rs[i];
            }
        }

        return null;
    }

    public Reservation[] findReserves(Room room,Date date) throws SQLException{
        List<Reservation> list = dao.getReserve(room.getRoomId(),date);
        System.out.println("****************************************************************");
        System.out.println(list.size());
        System.out.println("****************************************************************");
        Reservation[] rs = new Reservation[list.size()];
        list.toArray(rs);
       return rs;
    }



    public void deleteReserve(int reserveId) throws Exception {
        dao.deleteReserve(reserveId);
    }

    public void updateReserve(Reservation r) throws Exception {

        //他の予約が入っていない場合は更新できる
        if(checkAvailableReserve(r)){
            dao.updateReserve(r);
        }else{
            throw new RoomAlreadyReserveException();
        }


    }
}
