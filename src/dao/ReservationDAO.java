package dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.Reservation;

public interface ReservationDAO {

	//パターン1のチェック
	public boolean checkEndPoint(Reservation r) throws SQLException;
	
	//パターン2のチェック
	public boolean checkStartPoint(Reservation r) throws SQLException;
	
	//パターン3のチェック
	public boolean checkThruReserve(Reservation r) throws SQLException;
	
	public void insertReserve(Reservation r) throws SQLException;
	
	public void updateReserve(Reservation r) throws SQLException;
	
	public Reservation getReserve(int reserveId) throws SQLException;
	
    public List<Reservation> getReserve(String roomID, Date date) throws SQLException;
    
    public void deleteReserve(int reserveId) throws SQLException;
    
}
