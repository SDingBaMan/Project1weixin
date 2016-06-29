package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseOperation;
import beans.Apply;
import beans.Employee;

/**
 * Servlet implementation class ShowAllApplies
 */
@WebServlet("/ShowAllApplies")
public class ShowAllApplies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowAllApplies() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("user");
		String userId = employee.getId();
		List<Apply> list = getAllMyApplies(userId);
		request.setAttribute("myapplys", list);
		request.getRequestDispatcher("/pages/check.jsp").include(request, response);
	}
	
	/*
	 * 获取自己的所有申请
	 * */
	private List<Apply> getAllMyApplies(String myId){
		List<Apply> list = new ArrayList<Apply>();
		DatabaseOperation database = new DatabaseOperation();
		ResultSet rs = database.select("apply", "SendId", myId);
		try {
			while(rs.next()){
				Apply apply = new Apply();
				apply.setReciveId(rs.getString(1));
				apply.setaId(rs.getString(2));
				apply.setContent(rs.getString(3));
				apply.setState(rs.getBoolean(4));
				apply.setDate(rs.getString(5));
				apply.setSendId(rs.getString(6));
				list.add(apply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
