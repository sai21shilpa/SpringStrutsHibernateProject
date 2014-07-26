package edu.iit.fenghuang.ssh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iit.fenghuang.ssh.business.ebi.UserEbi;
import edu.iit.fenghuang.ssh.business.factory.BusinessFactory;
import edu.iit.fenghuang.ssh.vo.GoodQueryModel;
import edu.iit.fenghuang.ssh.vo.UserModel;
import edu.iit.fenghuang.ssh.vo.UserQueryModel;

public class UserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("enter UserServlet");
		System.out.println("submitFlag="+req.getParameter("submitFlag"));
		switch (req.getParameter("submitFlag")){
		case "toList" : 
			System.out.println("--->toList");
			toList(req, resp);
			break;
		case "toQuery" :
			System.out.println("--->toQuery");
			toQuery(req, resp);
			break;
		case "toCreate" :
			System.out.println("--->toCreate");
			toCreate(req, resp);
			break;
		case "toUpdate" :
			System.out.println("--->toUpdate");
			toUpdate(req, resp);
			break;
		case "toDelete" :
			System.out.println("--->toDelete");
			toDelete(req, resp);
			break;
		case "doUpdate" : 
			System.out.println("--->doUpdate");
			doUpdate(req, resp);
			break;
		}
	}
	private void toList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		UserEbi userEbi =  BusinessFactory.getUserEbi();
		List<UserModel> list = userEbi.queryAll();
		UserQueryModel ret = new UserQueryModel();
		ret.setResult(list);
		req.setAttribute("lr", ret);
		req.getRequestDispatcher("/back/user/userList.jsp").forward(req, resp);
	}
	private void toQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		UserQueryModel uqm = (UserQueryModel) req.getAttribute("uqm");
		UserEbi userEbi =  BusinessFactory.getUserEbi();
		List<UserModel> list = userEbi.queryByCondition(uqm);
		UserQueryModel ret = new UserQueryModel();
		ret.setResult(list);
		req.setAttribute("qr", ret);
		req.getRequestDispatcher("/back/user/userQueryResult.jsp").forward(req, resp);
	}
	private void toCreate(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		UserModel um = (UserModel) req.getAttribute("cb");
		UserEbi userEbi =  BusinessFactory.getUserEbi();
		userEbi.createUser(um);
		toList(req, resp);
	}
	private void toDelete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		int userId =  Integer.parseInt(req.getParameter("userId"));
		UserEbi userEbi =  BusinessFactory.getUserEbi();
		userEbi.deleteUser(userId);
		toList(req, resp);
	}
	private void toUpdate(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		int userId =  Integer.parseInt(req.getParameter("userId"));
		UserEbi userEbi =  BusinessFactory.getUserEbi();
		UserModel oldb = userEbi.queryById(userId);
		req.setAttribute("oldb", oldb);
		req.getRequestDispatcher("/back/user/userUpdate.jsp").forward(req, resp);
	}
	private void doUpdate(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		UserEbi userEbi =  BusinessFactory.getUserEbi();
		UserModel newbean = (UserModel) req.getAttribute("newb");
		System.out.println("new bean: "+newbean);
		userEbi.updateUser(newbean);
		toList(req, resp);
	}
}
