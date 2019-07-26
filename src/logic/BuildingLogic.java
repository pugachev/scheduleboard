
package logic;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import model.Building;

import dao.BuildingDAO;
import dao.DAOHelper;


public class BuildingLogic {

    private BuildingDAO dao;
    
    public BuildingLogic(){
    	//1) DAOの初期化はDAOHelperによっておこなわれる
        dao = DAOHelper.getBuildingDAO();
    }
    
    public Building[] getAllBuilding() throws SQLException{     
        List<Building> list = dao.getAllBuilding();
        
        //リストから配列に変換
        Building[] bs = new Building[list.size()];
        list.toArray(bs);
        
        return bs;
    }
    
    public Building[] getAllBuilding(ServletContext context) throws SQLException{
        //2)ビル一覧はコンテキストに格納して共通に利用される
        Building[] bds = (Building[]) context.getAttribute("buildings");
        if (bds == null) {
            bds = this.getAllBuilding();
            context.setAttribute("buildings", bds);
        }
        return bds;
    }
    
}
