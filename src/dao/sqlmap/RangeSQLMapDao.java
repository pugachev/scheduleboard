package dao.sqlmap;

import java.sql.SQLException;
import java.util.List;

import model.Range;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

import dao.RangeDAO;

public class RangeSQLMapDao extends SqlMapDaoTemplate implements RangeDAO {

	//1)SqlMapDaoTemplateを継承している

	private static final String GETALLRANGE = "getAllRange";
	
	public RangeSQLMapDao(DaoManager dao) {
		super(dao);
	}

	public List<Range> getAllRange() throws SQLException {

		//2)DBに登録されている時間帯を取得する
		return queryForList(GETALLRANGE,null);
	}

}
