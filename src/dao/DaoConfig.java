package dao;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;

public class DaoConfig {
	
	private static final String DAOSETTING = "dao/dao.xml";

	private static DaoManager dM = newDaoManager();
	
	public static DaoManager getDaoManager(){
		return dM;
	}

	private static DaoManager newDaoManager() {
	      Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(DAOSETTING);
		} catch (IOException e) {
			throw new RuntimeException("DaoConfig縺悟・譛溷喧縺ァ縺阪∪縺帙ｓ:"+e, e);
		}
	      return DaoManagerBuilder.buildDaoManager(reader);
	}
	
}
