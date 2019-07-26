package dao;


import java.sql.SQLException;
import java.util.List;

//部屋の検索用（後で消す)
public interface RoomDAO {
	public List getRooms(int buildingId) throws SQLException;
}
