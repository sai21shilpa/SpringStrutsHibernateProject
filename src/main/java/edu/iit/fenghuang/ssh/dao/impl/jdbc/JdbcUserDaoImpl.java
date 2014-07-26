package edu.iit.fenghuang.ssh.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.iit.fenghuang.ssh.dao.UserDAO;
import edu.iit.fenghuang.ssh.util.JdbcConnector;
import edu.iit.fenghuang.ssh.vo.UserModel;
import edu.iit.fenghuang.ssh.vo.UserQueryModel;

public class JdbcUserDaoImpl implements UserDAO {

	@Override
	public void createUser(UserModel um) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "insert into user_tbl values(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, um.getUserId());
			pstmt.setString(2, um.getPassword());
			pstmt.setString(3, um.getFirstName());
			pstmt.setString(4, um.getLastName());
			pstmt.setDouble(5, um.getBalance());
			pstmt.setString(6, um.getEmail());
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
	public void deleteUser(int uid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "DELETE FROM user_tbl WHERE user_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
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
	public void updateUser(UserModel um) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "UPDATE user_tbl SET password = ?,first_name = ?,last_name = ?,balance = ?,email = ? WHERE user_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, um.getPassword());
			pstmt.setString(2, um.getFirstName());
			pstmt.setString(3, um.getLastName());
			pstmt.setDouble(4, um.getBalance());
			pstmt.setString(5, um.getEmail());
			pstmt.setInt(6, um.getUserId());
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
	public UserModel queryById(int uid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		UserModel um = new UserModel();
		try {
			conn = JdbcConnector.getConn();
//			conn.setAutoCommit(false);
			String sql = "SELECT * FROM user_tbl WHERE user_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				um = this.rs2user(rs);
//			conn.commit();
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return um;
	}

	@Override
	public List<UserModel> queryAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM user_tbl";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				UserModel um = this.rs2user(rs);
				list.add(um);
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
	public List<UserModel> queryByCondition(UserQueryModel uqm) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM user_tbl where 1=1 ";
			sql = this.prepareSql(sql, uqm);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			setValue(pstmt, uqm);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				UserModel um = this.rs2user(rs);
				list.add(um);
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

	private UserModel rs2user(ResultSet rs) throws SQLException {
		UserModel um = new UserModel();
		um.setUserId(rs.getInt("user_id"));
		um.setPassword(rs.getString("password"));
		um.setFirstName(rs.getString("first_name"));
		um.setLastName(rs.getString("last_name"));
		um.setBalance(rs.getDouble("balance"));
		um.setEmail(rs.getString("email"));
		return um;
	}
	private String prepareSql(String sql, UserQueryModel uqm){
		StringBuffer buffer = new StringBuffer(sql);
		if (uqm.getUserId() > 0)
			buffer.append(" and user_id = ? ");
		if (uqm.getFirstName()!=null && uqm.getFirstName().trim().length()>0)
			buffer.append(" and first_name like ? ");
		if (uqm.getLastName()!=null && uqm.getLastName().trim().length()>0)
			buffer.append(" and last_name like ? ");
		if (uqm.getEmail()!=null && uqm.getEmail().trim().length()>0)
			buffer.append(" and email like ? ");
		if (uqm.getBalance1() < uqm.getBalance2())
			buffer.append(" and balance >= ? and balance < ?");

		return buffer.toString();
	}
	private void setValue(PreparedStatement pstmt, UserQueryModel uqm) throws SQLException{
		int count = 1;
		if (uqm.getUserId() > 0)
			pstmt.setInt(count++, uqm.getUserId());
		if (uqm.getFirstName()!=null && uqm.getFirstName().trim().length()>0)
			pstmt.setString(count++,"%"+uqm.getFirstName()+"%" );
		if (uqm.getLastName()!=null && uqm.getLastName().trim().length()>0)
			pstmt.setString(count++,"%"+uqm.getLastName()+"%" );
		if (uqm.getEmail()!=null && uqm.getEmail().trim().length()>0)
			pstmt.setString(count++,"%"+uqm.getEmail()+"%" );
		if (uqm.getBalance1() < uqm.getBalance2()){
			pstmt.setDouble(count++, uqm.getBalance1() );
			pstmt.setDouble(count++,uqm.getBalance2() );	
		}
	}
}
