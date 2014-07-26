package edu.iit.fenghuang.ssh.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.iit.fenghuang.ssh.dao.OrderDAO;
import edu.iit.fenghuang.ssh.util.JdbcConnector;
import edu.iit.fenghuang.ssh.vo.OrderModel;
import edu.iit.fenghuang.ssh.vo.OrderQueryModel;

public class JdbcOrderDaoImpl implements OrderDAO {


	@Override
	public void createOrder(OrderModel om) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "insert into order_tbl values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, om.getOrderId());
			pstmt.setInt(2, om.getUserId());
			pstmt.setInt(3, om.getGoodId());
			pstmt.setInt(4, om.getNumber());
			pstmt.setDouble(5, om.getUnitPrice());

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
	public void updateOrder(OrderModel om) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "UPDATE order_tbl SET user_id = ?,good_id = ?,number = ?, unit_price = ? WHERE order_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, om.getUserId());
			pstmt.setInt(2, om.getGoodId());
			pstmt.setInt(3, om.getNumber());
			pstmt.setDouble(4, om.getUnitPrice());
			pstmt.setInt(5, om.getOrderId());
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
	public void deleteOrder(int oid) {
		// TODO Auto-generated method stub
		Connection conn = null;

		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "DELETE FROM order_tbl WHERE order_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oid);
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
	public OrderModel queryById(int oid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		OrderModel om = new OrderModel();
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM order_tbl WHERE order_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				om = this.rs2user(rs);
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
		return om;
	}
	@Override
	public List<OrderModel> queryAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<OrderModel> list = new ArrayList<OrderModel>();
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM order_tbl";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				OrderModel om = this.rs2user(rs);
				list.add(om);
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
	public List<OrderModel> queryByCondition(OrderQueryModel oqm) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<OrderModel> list = new ArrayList<OrderModel>();
		try {
			conn = JdbcConnector.getConn();
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM order_tbl where 1=1 ";
			sql = this.prepareSql(sql, oqm);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			setValue(pstmt, oqm);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				OrderModel om = this.rs2user(rs);
				list.add(om);
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

	private OrderModel rs2user(ResultSet rs) throws SQLException {
		OrderModel om = new OrderModel();
		om.setOrderId(rs.getInt("order_id"));
		om.setGoodId(rs.getInt("good_id"));
		om.setUserId(rs.getInt("user_id"));
		om.setNumber(rs.getInt("number"));
		om.setUnitPrice(rs.getDouble("unit_price"));
		return om;
	}
	private String prepareSql(String sql, OrderQueryModel oqm){
		StringBuffer buffer = new StringBuffer(sql);
		if (oqm.getOrderId() > 0)
			buffer.append(" and order_id = ? ");
		if (oqm.getGoodId() > 0)
			buffer.append(" and good_id = ? ");
		if (oqm.getUserId() > 0)
			buffer.append(" and user_id = ? ");

		return buffer.toString();
	}
	private void setValue(PreparedStatement pstmt, OrderQueryModel oqm) throws SQLException{
		int count = 1;
		if (oqm.getOrderId() > 0)
			pstmt.setInt(count++, oqm.getOrderId());
		if (oqm.getGoodId() > 0)
			pstmt.setInt(count++, oqm.getGoodId());
		if (oqm.getUserId() > 0)
			pstmt.setInt(count++, oqm.getUserId());
		
	}
}
