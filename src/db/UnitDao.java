package db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitDao extends AbstractDao {
	
public List<Unit> getAllUnits() throws SQLException{
	List<Unit> units = new ArrayList<Unit>();
	try {
	st =getConnection().createStatement();
	rs = st.executeQuery("SELECT * FROM unit");
	while(rs.next()){
		Unit unit = new Unit();
		unit.setId(rs.getInt(1));
		unit.setName(rs.getString(2));
		unit.setCode(rs.getString(3));
		units.add(unit);
		
	}
	} finally {
	      closeResources();
	    }
	return units;
}

public void deleteByID(int id) throws SQLException{
	try {
		pst = getConnection().prepareStatement("DELETE FROM unit WHERE id = ?;");
		pst.setInt(1, id);
		pst.execute();
		
	
	} finally {
	      closeResources();
	    }
}

public List<Unit> findUnitsByName(String name) throws SQLException{
	List<Unit> units = new ArrayList<Unit>();
	try {
		pst = getConnection().prepareStatement("SELECT * FROM unit WHERE UPPER(name) LIKE ?");
		pst.setString(1, "%"+name.toUpperCase()+"%");
		rs = pst.executeQuery();
		while(rs.next()){
			Unit unit = new Unit();
			unit.setId(rs.getInt(1));
			unit.setName(rs.getString(2));
			unit.setCode(rs.getString(3));
			units.add(unit);
		}
	
	} finally {
	      closeResources();
	    }
	return units;
}
public void addNewUnit(Unit unit) throws SQLException{
	try {
		pst = getConnection().prepareStatement("INSERT INTO unit (id, name, code) VALUES (NEXT VALUE FOR seq1, ?, ?)");
		pst.setString(1, unit.getName());
		pst.setString(2, unit.getCode());
		pst.execute();
		}
	
	 finally {
	      closeResources();
	    }
}
public void deleteList() throws SQLException{
	try {
		st =getConnection().createStatement();
		rs = st.executeQuery("TRUNCATE SCHEMA public AND COMMIT");
	
	} finally {
	      closeResources();
	    }
}

}
