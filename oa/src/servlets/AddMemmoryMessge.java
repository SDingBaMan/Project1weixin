package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Content;
import beans.Employee;
import database.DatabaseOperation;

@WebServlet("/AddMemmoryMessge")
public class AddMemmoryMessge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddMemmoryMessge() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		String context = request.getParameter("context");
		
		if(date.isEmpty() || context.isEmpty()){
			String message = " 日期或内容不能为空！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("pages/addmm.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("user");
		String userId = employee.getId();

		DatabaseOperation database = new DatabaseOperation();
		
		int mmid = getMMID(database);
		mmid += 1;
		String mmidString = String.valueOf(mmid);
		
		database.insert("memmorymessage", userId, mmidString, context, date);
		
		response.sendRedirect("Calendar");
	}
	
	private int getMMID(DatabaseOperation database){
		int rows=0;
		ResultSet rs = database.select("select count(*) from memmorymessage");
		try {
			rs.next();
			String s = rs.getString(1);
			rows = Integer.parseInt(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

}
