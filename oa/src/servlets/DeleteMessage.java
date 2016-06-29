package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseOperation;

/**
 * Servlet implementation class DeleteMessage
 */
@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteMessage() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		DatabaseOperation database = new DatabaseOperation();
		database.delete("message", "MId", mid);
		response.sendRedirect("Message");
	}

}
