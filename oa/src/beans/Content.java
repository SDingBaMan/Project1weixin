package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Content {
	protected String content;
	protected Date date;
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDate() {
		String dateString="";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateString = dateFormat.format(date);
		
		return dateString;
	}
	
	public void setDate(String date) {
		Date thisDay = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			thisDay = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.date = thisDay;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
