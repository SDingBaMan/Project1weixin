package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Message;
import database.DatabaseOperation;

/**
 * Servlet implementation class showMessage
 */
@WebServlet("/ShowMessage")
public class ShowMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		DatabaseOperation database = new DatabaseOperation();
		ResultSet rs = database.select("message", "MId", mid);
		try {
			while(rs.next()){
				Message message = new Message();
				message.setDepId(rs.getString(1));
				message.setmId(rs.getString(2));
				message.setContent(rs.getString(3));
				message.setDate(rs.getDate(4));
				message.setTitle(rs.getString(5));
				request.setAttribute("message", message);
				request.getRequestDispatcher("/pages/contentPage.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
