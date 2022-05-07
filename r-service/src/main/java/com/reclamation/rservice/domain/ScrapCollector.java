package com.reclamation.rservice.domain;

import java.util.Date;


public class ScrapCollector implements java.io.Serializable {
	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 3192414484208636093L;

	private Integer id;

	private String name;

	private String sex;

	private String tel;

	private String idCard;

	private String housing_estate_code;

	private Integer income;

	private String openid;
	
	private Date create_time;
	
	private String sexval;
	
	private String housing_estate;
	
	private String province_name;

	public String getProvince_name() {
		return province_name;
	}

	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHousing_estate_code() {
		return housing_estate_code;
	}

	public void setHousing_estate_code(String housing_estate_code) {
		this.housing_estate_code = housing_estate_code;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getSexval() {
		return sexval;
	}

	public void setSexval(String sexval) {
		this.sexval = sexval;
	}

	public String getHousing_estate() {
		return housing_estate;
	}

	public void setHousing_estate(String housing_estate) {
		this.housing_estate = housing_estate;
	}

}