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
import beans.Employee;

@WebServlet("/Message")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Message() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseOperation database = new DatabaseOperation();

		HttpSession session = request.getSession();
		Employee user = (Employee) session.getAttribute("user");
		String depName = user.getDepartment();
		String depId = getDepId(database, depName);
		
		List<beans.Message> list = getMessage(database, depId);
		request.setAttribute("message", list);
		
		request.getRequestDispatcher("/pages/message.jsp").include(request, response);
	}
	
	
	/*
	 * 获取部门ID
	 * */
	private String getDepId(DatabaseOperation database, String depName){
		ResultSet rs = database.select("department", "Dname", depName);
		String depId="";
		try {
			rs.next();
			depId = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return depId;
	}
	
	
	/*
	 * 获取所有通知公告
	 * */
	private List<beans.Message> getMessage(DatabaseOperation database, String depId){
		ResultSet rs = database.select("message", "DepId", depId);
		List<beans.Message> list = new ArrayList<beans.Message>();
		try {
			while(rs.next()){
				beans.Message message = new beans.Message();
				try {
					message.setDepId(rs.getString(1));
					message.setmId(rs.getString(2));
					message.setContent(rs.getString(3));
					message.setDate(rs.getString(4));
					message.setTitle(rs.getString(5));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				list.add(message);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
}
