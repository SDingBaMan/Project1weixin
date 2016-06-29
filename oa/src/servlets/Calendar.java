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

import beans.Employee;
import beans.MemmoryMessage;
import database.DatabaseOperation;

@WebServlet("/Calendar")
public class Calendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Calendar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee user = (Employee) session.getAttribute("user");
		String userId = user.getId();
		DatabaseOperation database = new DatabaseOperation();
		ResultSet rs;
		
		String today = getDate();
		request.setAttribute("today", today);
		
		List<MemmoryMessage> list = getMemmoryMessages(database, userId);
		request.setAttribute("memmoryMessage", list);
		
		List<String> calendar = getCalendar();
		request.setAttribute("calendar", calendar);
		
		java.util.Calendar calendar2 = java.util.Calendar.getInstance();
		int year = calendar2.get(java.util.Calendar.YEAR);
		int month = calendar2.get(java.util.Calendar.MONTH);
		int daysOfMonth = getDaysOfMonth(year, month);
		request.setAttribute("daysOfMonth", daysOfMonth);
		
		int date = getToday();
		request.setAttribute("date", date);
		
		request.getRequestDispatcher("/pages/calendar.jsp").include(request, response);
	}

	/*
	 * 获取今日的日期，并格式化成 年年年年-月月-日日 的格式
	 * */
	private String getDate(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd EEEE");
		StringBuilder dateString = new StringBuilder();
		dateString.append(dateFormat.format(date));

		return dateString.toString();
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
	
	
	/*
	 * 计算日历，并存入ArrayList中
	 * */
	private List<String> getCalendar(){
		List<String> list = new ArrayList<String>();
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		int year = calendar.get(java.util.Calendar.YEAR);
		int month = calendar.get(java.util.Calendar.MONTH);
		
		int days = getDaysOfMonth(year, month);
		int firstDay = getFirstDay(year, month);
		
		for(int i=1; i<firstDay; ++i){
			list.add("");
		}
		for(int i=1; i<=days; ++i){
			list.add(i+"");
		}
				
		return list;
	}
	
	/*
	 * 获得某月的天数
	 * */
	public int getDaysOfMonth(int year, int month){
		int days;

		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(java.util.Calendar.YEAR, year);
		calendar.set(java.util.Calendar.MONTH, month);
		days = calendar.getActualMaximum(java.util.Calendar.DATE);
		
		return days;
	}
	
	/*
	 * 获得某月的1日是星期几
	 * */
	public int getFirstDay(int year, int month){
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(java.util.Calendar.YEAR, year);
		calendar.set(java.util.Calendar.MONTH, month);
		calendar.set(java.util.Calendar.DATE, 1);
		
		return calendar.get(java.util.Calendar.DAY_OF_WEEK);
	}
	
	public int getToday(){
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		return calendar.get(java.util.Calendar.DATE);
	}
}
