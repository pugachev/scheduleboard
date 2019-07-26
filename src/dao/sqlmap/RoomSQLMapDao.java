package dao.sqlmap;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

import dao.RoomDAO;

public class RoomSQLMapDao extends SqlMapDaoTemplate implements RoomDAO{
	
	//1)SqlMapDaoTemplateを継承している。

	private static final String GETROOMS = "getRooms";
	
	
	public RoomSQLMapDao(DaoManager dao) {
		super(dao);
	}

	public List getRooms(int buildingId) throws SQLException {
		//2)ビルIDを満たす部屋の一覧を取得する。
		return queryForList(GETROOMS, String.valueOf(buildingId));
	}

}
