package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseOperation;

@WebServlet("/Approval")
public class Approval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Approval() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aid = request.getParameter("aid");
		String check = request.getParameter("check");
		if("1".equals(check)){	//同意
			agree(aid);
		}else{	//不同意
			this.disagree(aid);
		}
		response.sendRedirect("Check");
	}

	/*
	 * 审核通过
	 * */
	private void agree(String aid){
		DatabaseOperation database = new DatabaseOperation();
		database.update("apply", "state", "1", "AId", aid);
	}
	
	/*
	 * 审核不通过
	 * */
	private void disagree(String aid){
		DatabaseOperation database = new DatabaseOperation();
		database.update("apply", "state", "0", "AId", aid);
	}
	
}
