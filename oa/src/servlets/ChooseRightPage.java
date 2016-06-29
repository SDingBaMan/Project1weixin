package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import beans.Employee;

@WebServlet("/ChooseRightPage")
public class ChooseRightPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChooseRightPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String string = request.getParameter("choose");
		int choose = Integer.parseInt(string);
		switch (choose) {
			case 1:
				response.sendRedirect("Work");
				break;
			case 2:
				response.sendRedirect("Message");
				break;
			case 3:
				response.sendRedirect("Calendar");
				break;
			case 4:{
				HttpSession session = request.getSession();
				Employee employee = (Employee) session.getAttribute("user");

				System.out.println("sdfdfs  :  "+employee.isPower());

				if(employee.isPower())
					response.sendRedirect("Check");
				else{
					response.sendRedirect("ShowAllApplies");
				}
				break;
			}
		}
	} 
}
