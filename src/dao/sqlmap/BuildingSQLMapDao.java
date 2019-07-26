package dao.sqlmap;

import java.sql.SQLException;
import java.util.List;

import model.Building;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

import dao.BuildingDAO;
import dao.RoomDAO;

public class BuildingSQLMapDao extends SqlMapDaoTemplate implements BuildingDAO {

	//1)SqlMapDaoTemplateを継承している。

	private static final String GETBUILDINGS = "getAllBuilding";
	
	public BuildingSQLMapDao(DaoManager dm) {
		super(dm);
	}

	public List<Building> getAllBuilding() throws SQLException {
		
		//2)DBに登録されているビルを取得する
		List<Building> list = queryForList(GETBUILDINGS,null);
		
		for(int i=0;i<list.size();i++){
			Building building = (Building)list.get(i);
			
			//3) RoomDAOを取得する
			RoomDAO roomDao = (RoomDAO)daoManager.getDao(RoomDAO.class);
			
			building.setRooms(roomDao.getRooms(building.getId()));
		}
		
		return list;
	}

}
