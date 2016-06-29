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

import beans.Employee;
import beans.MemmoryMessage;
import beans.Message;
import database.DatabaseOperation;

@WebServlet("/Work")
public class Work extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Work() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee user = (Employee) session.getAttribute("user");
		String depName = user.getDepartment();
		String userId = user.getId();
		String depId = null;

		DatabaseOperation database = new DatabaseOperation();
		ResultSet rs;

		/*
		 * 查询用户所属部门的部门号
		 * */
		rs = database.select("department", "Dname", depName);
		try {
			rs.next();
			depId = rs.getString(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		/*
		 * 查询通知公告模块
		 * */
		Message message = getMessage(database, depId);
		request.setAttribute("message", message);
		
		/*
		 * 查询备忘模块
		 * */
		List<MemmoryMessage> list = getMemmoryMessages(database, userId);
		request.setAttribute("memmoryMessage", list);
		
		/*
		 * 跳转到work.jsp页面
		 * */
		request.getRequestDispatcher("/pages/work.jsp").include(request, response);
	}
	
	
	/*
	 * 查询通知公告
	 * */
	private Message getMessage(DatabaseOperation database, String depId){
		ResultSet rs = database.select("message", "DepId", depId);
		try {
			if(rs.last()){
				Message message = new Message();
				try {
					message.setDepId(rs.getString(1));
					message.setmId(rs.getString(2));
					message.setContent(rs.getString(3));
					message.setDate(rs.getString(4));
					message.setTitle(rs.getString(5));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return message;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * 查询备忘
	 * */
	private List<MemmoryMessage> getMemmoryMessages(DatabaseOperation database, String userId){
		ResultSet rs = database.select("memmorymessage", "UserId", userId);
		List<MemmoryMessage> list = new ArrayList<MemmoryMessage>();
		try {
			while(rs.next()){
				MemmoryMessage memmoryMessage = new MemmoryMessage();
				memmoryMessage.setUserId(rs.getString(1));
				memmoryMessage.setMmId(rs.getString(2));
				memmoryMessage.setContent(rs.getString(3));
				memmoryMessage.setDate(rs.getDate(4));
				list.add(memmoryMessage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
