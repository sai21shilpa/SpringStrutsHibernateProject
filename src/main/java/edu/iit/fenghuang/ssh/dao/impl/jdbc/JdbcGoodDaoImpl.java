package edu.iit.fenghuang.ssh.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.iit.fenghuang.ssh.dao.GoodDAO;
import edu.iit.fenghuang.ssh.util.JdbcConnector;
import edu.iit.fenghuang.ssh.vo.GoodModel;
import edu.iit.fenghuang.ssh.vo.GoodQueryModel;

public class JdbcGoodDaoImpl implements GoodDAO {

	@Override
	public void createGood(GoodModel gm) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "insert into good_tbl values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gm.getGoodId());
			pstmt.setString(2, gm.getName());
			pstmt.setString(3, gm.getDescription());
			pstmt.setDouble(4, gm.getPrice());

			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
	}

	@Override
	public void updateGood(GoodModel gm) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "UPDATE good_tbl SET name = ?,description = ?,price = ? WHERE good_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gm.getName());
			pstmt.setString(2, gm.getDescription());
			pstmt.setDouble(3, gm.getPrice());
			pstmt.setInt(4, gm.getGoodId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
	}

	@Override
	public void deleteGood(int gid) {
		// TODO Auto-generated method stub
	Connection conn = null;
		
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "DELETE FROM good_tbl WHERE good_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
	}

	@Override
	public GoodModel queryById(int gid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		GoodModel gm = new GoodModel();
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM good_tbl WHERE good_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				gm = this.rs2user(rs);
			conn.commit();
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return gm;
	}

	@Override
	public List<GoodModel> queryAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<GoodModel> list = new ArrayList<GoodModel>();
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM good_tbl";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				GoodModel gm = this.rs2user(rs);
				list.add(gm);
			}
			conn.commit();
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return list;
	}

	@Override
	public List<GoodModel> queryByCondition(GoodQueryModel gqm) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<GoodModel> list = new ArrayList<GoodModel>();
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM good_tbl where 1=1 ";
			sql = this.prepareSql(sql, gqm);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			setValue(pstmt, gqm);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				GoodModel gm = this.rs2user(rs);
				list.add(gm);
			}
			conn.commit();
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return list;
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
