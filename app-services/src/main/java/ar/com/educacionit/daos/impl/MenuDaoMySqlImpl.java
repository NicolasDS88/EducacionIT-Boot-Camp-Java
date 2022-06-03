package ar.com.educacionit.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.daos.MenuDao;
import ar.com.educacionit.domain.Menu;

public class MenuDaoMySqlImpl extends JDBCBaseDao<Menu> implements MenuDao {

	public MenuDaoMySqlImpl() {
		super("menu");
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Menu fromResultSetToEntity(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
