package edu.iit.fenghuang.ssh.dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.AbandonedConfig;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import edu.iit.fenghuang.ssh.dao.GoodDAO;
import edu.iit.fenghuang.ssh.vo.GoodModel;
import edu.iit.fenghuang.ssh.vo.GoodQueryModel;
public class JdbcGoodDaoImplSpring implements GoodDAO{
	private DataSource ds = null;
	@Override
	public void createGood(GoodModel um) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = new JdbcTemplate(ds);
		final GoodModel fgm  = um;
		class MyCallback implements PreparedStatementCallback{

			@Override
			public Object doInPreparedStatement(PreparedStatement pstmt)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, fgm.getGoodId());
				pstmt.setString(2, fgm.getName());
				pstmt.setString(3, fgm.getDescription());
				pstmt.setDouble(4, fgm.getPrice());
				return pstmt.executeUpdate();
			}
			
		}
		jt.execute("INSERT INTO good_tbl (good_id,name,description,price) VALUES (?,?,?,?);",new MyCallback());
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public void updateGood(final GoodModel um) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = new JdbcTemplate(ds);
		class MyCallback implements PreparedStatementCallback{

			@Override
			public Object doInPreparedStatement(PreparedStatement pstmt)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				pstmt.setInt(4, um.getGoodId());
				pstmt.setString(1, um.getName());
				pstmt.setString(2, um.getDescription());
				pstmt.setDouble(3, um.getPrice());
				return pstmt.executeUpdate();
			}
			
		}
		jt.execute("UPDATE good_tbl SET name = ?,description = ?,price = ? WHERE good_id = ? ;",new MyCallback());
	}

	@Override
	public void deleteGood(final int uid) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = new JdbcTemplate(ds);
		class MyCallback implements PreparedStatementCallback{

			@Override
			public Object doInPreparedStatement(PreparedStatement pstmt)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, uid);
				
				return pstmt.executeUpdate();
			}
			
		}
		jt.execute("DELETE FROM good_tbl WHERE good_id = ? ;",new MyCallback());
	}

	@Override
	public GoodModel queryById(int gid) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = new JdbcTemplate(ds);
		final int fgid = gid;
		class MyCallback implements PreparedStatementCallback{

			@Override
			public GoodModel doInPreparedStatement(PreparedStatement pstmt)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, fgid);
				ResultSet rs = pstmt.executeQuery();
				GoodModel gm = new GoodModel();
				if (rs.next()){
					gm = rs2user(rs);
				}
					
				return gm;
			}
			
		}
		return (GoodModel) jt.execute("SELECT * FROM good_tbl WHERE good_id=?;",new MyCallback());
	}

	@Override
	public List<GoodModel> queryAll() {
		// TODO Auto-generated method stub
		JdbcTemplate jt = new JdbcTemplate(ds);
		class MyCallback implements PreparedStatementCallback{

			@Override
			public List<GoodModel> doInPreparedStatement(PreparedStatement pstmt)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ResultSet rs = pstmt.executeQuery();
				List<GoodModel> list = new ArrayList<GoodModel>();
				while(rs.next()){
					GoodModel gm = rs2user(rs);
					list.add(gm);
				}
				return list;
			}
			
		}
		return (List<GoodModel>) jt.execute("SELECT * FROM good_tbl;",new MyCallback());
	}

	@Override
	public List<GoodModel> queryByCondition(final GoodQueryModel gqm) {
		// TODO Auto-generated method stub
		JdbcTemplate jt = new JdbcTemplate(ds);
		class MyCallback implements PreparedStatementCallback{

			@Override
			public List<GoodModel> doInPreparedStatement(PreparedStatement pstmt)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				setValue(pstmt,gqm);
				ResultSet rs = pstmt.executeQuery();
				List<GoodModel> list = new ArrayList<GoodModel>();
				while(rs.next()){
					GoodModel gm = rs2user(rs);
					list.add(gm);
				}
				return list;
			}
			
		}
		return (List<GoodModel>) jt.execute(prepareSql("SELECT * FROM good_tbl where 1=1 ",gqm),new MyCallback());
	}
	private GoodModel rs2user(ResultSet rs) throws SQLException {
		GoodModel gm = new GoodModel();
		gm.setGoodId(rs.getInt("good_id"));
		gm.setName(rs.getString("name"));
		gm.setDescription(rs.getString("description"));
		gm.setPrice(rs.getDouble("price"));
		return gm;
	}
	private String prepareSql(String sql, GoodQueryModel gqm){
		StringBuffer buffer = new StringBuffer(sql);
		if (gqm.getGoodId() > 0)
			buffer.append(" and good_id = ? ");
		if (gqm.getName()!=null && gqm.getName().trim().length()>0)
			buffer.append(" and name like ? ");
		if (gqm.getDescription()!=null && gqm.getDescription().trim().length()>0)
			buffer.append(" and description like ? ");
		if (gqm.getPrice1() < gqm.getPrice2())
			buffer.append(" and price >= ? and price < ?");

		return buffer.toString();
	}
	private void setValue(PreparedStatement pstmt, GoodQueryModel gqm) throws SQLException{
		int count = 1;
		if (gqm.getGoodId() > 0)
			pstmt.setInt(count++, gqm.getGoodId());
		if (gqm.getName()!=null && gqm.getName().trim().length()>0)
			pstmt.setString(count++,"%"+gqm.getName()+"%" );
		if (gqm.getDescription()!=null && gqm.getDescription().trim().length()>0)
			pstmt.setString(count++,"%"+gqm.getDescription()+"%" );
		if (gqm.getPrice1() < gqm.getPrice2()){
			pstmt.setDouble(count++, gqm.getPrice1() );
			pstmt.setDouble(count++,gqm.getPrice2() );	
		}
	}
}
