package dao;

import java.sql.SQLException;
import java.util.List;

import model.Range;

//後で消す
public interface RangeDAO {
	public List<Range> getAllRange() throws SQLException;
}
