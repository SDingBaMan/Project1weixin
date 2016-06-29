package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Apply extends Content{
	private String aId;
	private String sendId;
	private String reciveId;
	private int state;
	
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public String getReciveId() {
		return reciveId;
	}
	public void setReciveId(String reciveId) {
		this.reciveId = reciveId;
	}
	public int getState() {
		return state;
	}
	public void setState(Boolean state) {
		if(state){
			this.state = 1;
		}else{
			this.state = 0;
		}
	}
	
}
