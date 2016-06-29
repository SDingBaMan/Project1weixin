package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Employee;
import database.DatabaseOperation;

@WebServlet("/CreateMessage")
public class CreateMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseOperation database = new DatabaseOperation();
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("user");

		String depName = employee.getDepartment();
		String depId = getDepId(database, depName);
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		
		createMessage(database, depId, title, content);
		response.sendRedirect("Message");
	}
	
	private String getDepId(DatabaseOperation database, String depName){
		ResultSet rs = database.select("department", "Dname", depName);
		String depId = "";
		try {
			if(rs.next()){
				depId = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return depId;
	}
	
	private int createMessage(DatabaseOperation database, String depId, String title, String content){
		String date = getDateString();
		String mid = getLastMid(database);
		int rows=0;
		rows = database.insert("message", depId, mid, content, date, title);
		
		return rows;
	}
	
	
	private String getDateString(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormat.format(date);
	
		return dateString;
	}
	
	private String getLastMid(DatabaseOperation database){
		ResultSet rs = database.selectAll("message");
		String id = "1";
		try {
			if(rs.last()){
				id = rs.getString(2);
				int i = Integer.parseInt(id);
				i += 1;
				id = Integer.toString(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
}
