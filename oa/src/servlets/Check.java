package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.omg.CORBA.PUBLIC_MEMBER;

import database.DatabaseOperation;
import beans.Apply;
import beans.DepLeader;
import beans.Employee;
import beans.Leader;
import beans.SchoolLeader;
import beans.TopLeader;

@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Check() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseOperation database = new DatabaseOperation();
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("user");
		String userId = employee.getId();

		/* 如果是领导,获取所有申请，进行审批 */
		if(employee.isPower()){
			List<Apply> list = getApplies(userId, database);
			request.setAttribute("applys", list);
		}

		/* 如果是普通员工，提交申请，并分配领导处理 */
		else {
			String d = request.getParameter("days");
			System.out.println(d+"    时间 ： xxxxxxxx");
			int days = Integer.parseInt(d);
			Leader depLeader = getDepLeader(employee.getDepartment(), database);
			Leader schoolLeader = getSchoolLeader();
			Leader topLeader = getTopLeader();
			depLeader.setSuccessor(schoolLeader);
			schoolLeader.setSuccessor(topLeader);
			
			String reciveId = depLeader.handleRequest(days);
			System.out.println(reciveId+"   =====");

			Apply apply = createApply(reciveId, getLastAid(database), d, false, getCreateDate(), userId);
			saveApply(apply, database);
			response.sendRedirect("ShowAllApplies");
//			request.getRequestDispatcher("ShowAllApplies").include(request, response);
		}
		
		request.getRequestDispatcher("/pages/check.jsp").include(request, response);
	
	}

	
	/*
	 * 获取topLeader
	 * */
	private TopLeader getTopLeader(){
		TopLeader topLeader = new TopLeader();
		topLeader.setId("1000");
		topLeader.setName("Top");
		topLeader.setSex("男");
		topLeader.setBirth("1994-10-01");
		topLeader.setDepartment("0");
		topLeader.setPhone("10000000000");
		topLeader.setJob("TopLeader");
		topLeader.setPower(true);
		
		return topLeader;
	}
	
	/*
	 * 获取schoolLeader
	 * */
	private SchoolLeader getSchoolLeader(){
		SchoolLeader schoolLeader = new SchoolLeader();
		schoolLeader.setId("1001");
		schoolLeader.setName("熊帅");
		schoolLeader.setSex("男");
		schoolLeader.setBirth("1995-07-22");
		schoolLeader.setDepartment("1");
		schoolLeader.setPhone("18633867671");
		schoolLeader.setJob("校长");
		schoolLeader.setPower(true);
		return schoolLeader;
	}
	
	/*
	 * 获取部门leader
	 * */
	private DepLeader getDepLeader(String depName, DatabaseOperation database){
		ResultSet rs = database.select("department", "Dname", depName);
		DepLeader depLeader = null;
		try {
			rs.next();
			String depId = rs.getString(1);
			rs = database.select("select * from employee where power=1 and department=" + depId);
			rs.next();
			depLeader = new DepLeader();
			depLeader.setId(rs.getString(1));
			depLeader.setName(rs.getString(2));
			depLeader.setSex(rs.getString(3));
			depLeader.setBirth(rs.getString(4));
			depLeader.setDepartment(depId);
			depLeader.setPhone(rs.getString(6));
			depLeader.setJob(rs.getString(7));
			depLeader.setPower(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return depLeader;
	}
	
	
	/*
	 * 保存申请
	 * */
	private void saveApply(Apply apply, DatabaseOperation database){
		String[] strings = new String[6];
		strings[0] = apply.getReciveId();
		strings[1] = apply.getaId();
		strings[2] = apply.getContent();
		strings[3] = apply.getState()+"";
		strings[4] = apply.getDate();
		strings[5] = apply.getSendId();
		database.insert("apply", strings);
	}
	
	/*
	 * 创建一条申请
	 * */
	private Apply createApply(String reciveId, String Aid, String content, Boolean state, String date, String sendId){
		Apply apply = new Apply();
		apply.setReciveId(reciveId);
		apply.setaId(Aid);
		apply.setContent(content);
		apply.setState(state);
		apply.setDate(date);
		apply.setSendId(sendId);
		return apply;
	}
	
	/*
	 * 获取最后一个aId，并在此基础上+1，返回新申请的aId
	 * */
	private String getLastAid(DatabaseOperation database){
		ResultSet rs = database.selectAll("apply");
		String idString = "0";
		try {
			if(rs.last())
				idString = rs.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int id = Integer.parseInt(idString);
		id+=1;
		return Integer.toString(id);
	}
	
	/*
	 * 获取创建日期
	 * */
	private String getCreateDate(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
	
	/*
	 * 获取属于此领导的申请
	 * */
	private List<Apply> getApplies(String userId, DatabaseOperation database){
		List<Apply> list = new ArrayList<Apply>();
		ResultSet rs = database.select("apply", "ReciveId", userId);
		try {
			while(rs.next()){
				Apply apply = new Apply();
				apply.setReciveId(rs.getString(1));
				apply.setaId(rs.getString(2));
				apply.setContent(rs.getString(3));
				apply.setState(rs.getBoolean(4));
				apply.setDate(rs.getDate(5));
				String id = rs.getString(6);
				apply.setSendId(getUserNameById(id, database));/* 此处将sendId设置为申请方的姓名 */
				list.add(apply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * 凭借ID获取用户名
	 * */
	private String getUserNameById(String id, DatabaseOperation database){
		ResultSet rs = database.select("employee", "id", id);
		String name="";
		try {
			rs.next();
			name = rs.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
}
