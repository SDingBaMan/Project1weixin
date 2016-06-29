package com.wwkj.bean;


/**
 * 地址详细
 * 
 * @author leo
 * 
 */
public class AddressDetail implements Comparable<AddressDetail> {

	private int id;
	private String name;

	private String phonenumber;

	private String fixedtel;
	private int provinceid;

	private int cityid;

	private int areaid;

	private String areadetail;

	private String zipcode;

	public AddressDetail() {
	}

	public AddressDetail(int id, String name, String phonenumber, String fixedtel, int provinceid, int cityid,
			int areaid, String areadetail, String zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
		this.fixedtel = fixedtel;
		this.provinceid = provinceid;
		this.cityid = cityid;
		this.areaid = areaid;
		this.areadetail = areadetail;
		this.zipcode = zipcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFixedtel() {
		return fixedtel;
	}

	public void setFixedtel(String fixedtel) {
		this.fixedtel = fixedtel;
	}

	public int getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public int getAreaid() {
		return areaid;
	}

	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}

	public String getAreadetail() {
		return areadetail;
	}

	public void setAreadetail(String areadetail) {
		this.areadetail = areadetail;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "AddressDetail [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", fixedtel=" + fixedtel
				+ ", provinceid=" + provinceid + ", cityid=" + cityid + ", areaid=" + areaid + ", areadetail="
				+ areadetail + ", zipcode=" + zipcode + "]";
	}

	public int compareTo(AddressDetail o) {
		return id < o.id ? 1 : -1 ;
	}
	
	
}
