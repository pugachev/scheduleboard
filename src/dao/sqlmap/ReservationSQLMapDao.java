package dao.sqlmap;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Reservation;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

import dao.ReservationDAO;

public class ReservationSQLMapDao extends SqlMapDaoTemplate implements ReservationDAO {

	//SqlMapDaoTemplateを継承している

	private static final String DELETE_RESERVATION = "deleteReservation";
	private static final String UPDATE_RESERVATION = "updateReservation";
	private static final String INSERT_RESERVATION = "insertReservation";
	private static final String GET_RESERVATIONS_FOR_DATE = "getReservationsForDate";
	private static final String GET_RESERVATION = "getReservation";
	private static final String CHECK_P3 = "CheckP3";
	private static final String CHECK_P2 = "CheckP2";
	private static final String CHECK_P1 = "CheckP1";

	public ReservationSQLMapDao(DaoManager dao) {
		super(dao);
	}

	public boolean checkEndPoint(Reservation r) throws SQLException {

		//1)予約可能かどうかを調べるSQL（パターン1）
		Integer count = (Integer)queryForObject(CHECK_P1, r);
		return count.intValue() == 0 ? true:false;
	}

	public boolean checkStartPoint(Reservation r) throws SQLException {

		//2)予約可能かどうかを調べるSQL（パターン2）
		Integer count = (Integer)queryForObject(CHECK_P2, r);
		return count.intValue() == 0 ? true:false;
	}

	public boolean checkThruReserve(Reservation r) throws SQLException {

		//3)予約可能かどうかを調べるSQL（パターン3）
		Integer count = (Integer)queryForObject(CHECK_P3, r);
		return count.intValue() == 0 ? true:false;
	}

	public Reservation getReserve(int reserveId) throws SQLException {
		//予約IDを元に予約を取得する
		return (Reservation)queryForObject(GET_RESERVATION, Integer.valueOf(reserveId));
	}

	public List<Reservation> getReserve(String roomID, Date date) throws SQLException {

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roomid",roomID);
		map.put("date", date);

		//4)指定された日、指定された部屋の予約の一覧を取得する
		return queryForList(GET_RESERVATIONS_FOR_DATE, map);
	}

	public void insertReserve(Reservation r) throws SQLException {
		//予約の登録をする
		insert(INSERT_RESERVATION, r);
	}

	public void updateReserve(Reservation r) throws SQLException {
		//予約を更新する
		update(UPDATE_RESERVATION, r);
	}

	public void deleteReserve(int reserveId) throws SQLException {
		//予約を削除する
		delete(DELETE_RESERVATION, Integer.valueOf(reserveId));
	}
}
