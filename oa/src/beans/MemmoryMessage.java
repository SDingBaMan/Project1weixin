package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemmoryMessage extends Content {
	private String mmId;
	private String userId;
	
	public String getMmId() {
		return mmId;
	}
	public void setMmId(String mmId) {
		this.mmId = mmId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
