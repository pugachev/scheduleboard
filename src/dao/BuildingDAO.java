package dao;

import java.sql.SQLException;
import java.util.List;

import model.Building;

//後で消す
public interface BuildingDAO {

	public List<Building> getAllBuilding() throws SQLException;
	
}
