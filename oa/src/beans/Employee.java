package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Employee {
	private String id;
	private String name;
	private String sex;
	private Date birth;
	private String department;
	private String phone;
	private String job;
	private boolean power;
	private Account account;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getBirth() {
		String birthString = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		birthString = dateFormat.format(birth);

		return birthString;
	}
	
	public void setBirth(String birthday) {
		Date birth = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			birth = dateFormat.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.birth = birth;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public boolean isPower() {
		return power;
	}
	
	public void setPower(boolean power) {
		this.power = power;
	}
	
	public void setAccount(Account account){
		this.account = account;
	}
	
	public void setAccount(String username, String password){
		this.account.setUsername(username);
		this.account.setPassword(password);
	}
	
	public Account getAccount(){
		return this.account;
	}
	
}
