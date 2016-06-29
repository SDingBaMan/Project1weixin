package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Employee;
import database.DatabaseOperation;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	DatabaseOperation database = new DatabaseOperation();
    	boolean status = false;
    	StringBuilder message = new StringBuilder();
    	message.append("*");
    	
    	String un = request.getParameter("username");
    	String pw = request.getParameter("password");
    	
    	ResultSet resultSet = database.select("account", "id", un);
    	try {
			if(resultSet.next()){	//resultSet.next()如果返回false证明结果集为空
				try {
					String password = resultSet.getString(2);
					if(password.equals(pw)){
						status = true;
					}else{
						message.append("密码错误");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				message.append("用户名不存在");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	message.append("*");
    	
    	Employee employee = null;
    	if(status){
    		resultSet = database.select("employee", "id", un);
    		try {
				resultSet.next();
				employee = new Employee();
				employee.setId(un);
				employee.setName(resultSet.getString(2));
				employee.setSex(resultSet.getString(3));
				employee.setBirth(resultSet.getString(4));
				
				String dId = resultSet.getString(5);
				ResultSet rs = database.select("department", "Did", dId);
				rs.next();
				employee.setDepartment(rs.getString(2));
				
				employee.setPhone(resultSet.getString(6));
				employee.setJob(resultSet.getString(7));
				employee.setPower(resultSet.getBoolean(8));
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	database.closeDatabase();
    	
    	if(status){
    		HttpSession session = request.getSession();
    		session.setAttribute("user", employee);
    		session.setMaxInactiveInterval(60*60*24);
    		response.sendRedirect("pages/index.jsp");
    	}else{
    		request.setAttribute("accountMessage", message);
    		request.getRequestDispatcher("login.jsp").forward(request, response);
    	}
    	
    }

}
