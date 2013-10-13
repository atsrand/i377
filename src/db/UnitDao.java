package db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitDao extends AbstractDao {
	
	public List<Unit> findAllDepartments() throws SQLException {

		List<Unit> units = new ArrayList<Unit>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM unit");
			while (rs.next()) {
				Unit unit = new Unit();
				unit.setId(rs.getInt(1));
				unit.setName(rs.getString("name"));
				unit.setCode(rs.getString("code"));
				units.add(unit);
			}

		} finally {
			closeResources();
		}
		return units;

	}

	public void addUnit(String name, String code) throws SQLException {
		try{
			st = getConnection().createStatement();
			rs = st.executeQuery("INSERT INTO unit VALUES (NEXT VALUE For seq1), '"+name+"', '"+code+"'");
		} finally {
			closeResources();
		}
	}
	
	public void deleteAllData() throws SQLException {
		try{
			st = getConnection().createStatement();
			rs = st.executeQuery("DELETE FROM unit");
		} finally {
			closeResources();
		}
	}
	
	public void deleteDataById(int id) throws SQLException {
		try{
			st = getConnection().createStatement();
			rs = st.executeQuery("DELETE FROM unit WHERE id = " + id);
		} finally {
			closeResources();
		}
	}

	public List<Unit> fullTextSearch(String userInput) throws SQLException {

		List<Unit> units = new ArrayList<Unit>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM unit WHERE UPPER(name) LIKE '%" + userInput.toUpperCase() + "%'");
			while (rs.next()) {
				Unit unit = new Unit();
				unit.setId(rs.getInt(1));
				unit.setName(rs.getString("name"));
				unit.setCode(rs.getString("code"));
				units.add(unit);
			}

		} finally {
			closeResources();
		}
		return units;

	}

}
