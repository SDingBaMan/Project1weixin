package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseOperation;

@WebServlet("/DeleteMemmoryMessage")
public class DeleteMemmoryMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteMemmoryMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseOperation database = new DatabaseOperation();
		String id = request.getParameter("mmId");
		database.delete("memmorymessage", "MMid", id);
		response.sendRedirect("Calendar");
	}

}
