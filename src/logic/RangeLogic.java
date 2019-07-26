
package logic;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import model.Range;
import dao.DAOHelper;
import dao.RangeDAO;

public class RangeLogic {
    private  RangeDAO dao;
    
    public RangeLogic(){
        dao = DAOHelper.getRangeDAO();
    }
    
    public Range[] getAllRanges() throws SQLException{
         
        List<Range> rangeList = dao.getAllRange();
        
        Range[] ranges = new Range[rangeList.size()];
        rangeList.toArray(ranges);
        
        return ranges;
    }
    
    public Range[] getAllRanges(ServletContext context) throws SQLException{
        //1)時間帯一覧はServletContextインタフェースに格納して共通に利用される
        Range[] rInfo = (Range[])context.getAttribute("range");
        if(rInfo == null){
            rInfo = this.getAllRanges();
            context.setAttribute("range",rInfo);
        }
        
        return rInfo;
    }
    
}
