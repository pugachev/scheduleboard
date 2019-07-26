package dao;


import com.ibatis.dao.client.DaoManager;

public class DAOHelper {

	private static final DaoManager mgr = DaoConfig.getDaoManager();
	private static final Class BUILD = BuildingDAO.class;
	private static final Class RANGE = RangeDAO.class;
	private static final Class RESERVE = ReservationDAO.class;
	
	public static BuildingDAO getBuildingDAO(){
		return (BuildingDAO)mgr.getDao(BUILD);
	}

	public static RangeDAO getRangeDAO() {
		return (RangeDAO)mgr.getDao(RANGE);
	}

	public static ReservationDAO getReservationDAO() {
		return (ReservationDAO)mgr.getDao(RESERVE);
	}
}
