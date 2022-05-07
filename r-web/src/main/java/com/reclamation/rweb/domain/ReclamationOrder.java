package com.reclamation.rweb.domain;

import java.util.Date;

public class ReclamationOrder implements java.io.Serializable {
	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 3192414484208636093L;
	
    private Integer id;

    private String order_no;

    private String scrap_code;

    private String owner_id;

    private String sc_id;

    private String rd_id;

    private Integer amount;

    private String unit;
    
    private Integer money;

	private String sc_status;
	
	private String rd_status;
	
    private Date create_time;
    
    private Date update_time;
    
    private String scrap_name;

    private String owner_name;

    private String sc_name;

    private String rd_name;
    
    private String sc_status_val;
	
	private String rd_status_val;

	private Integer price;
	
	private String openid;
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public String getScrap_name() {
		return scrap_name;
	}

	public void setScrap_name(String scrap_name) {
		this.scrap_name = scrap_name;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getSc_name() {
		return sc_name;
	}

	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}

	public String getRd_name() {
		return rd_name;
	}

	public void setRd_name(String rd_name) {
		this.rd_name = rd_name;
	}

	public String getSc_status_val() {
		return sc_status_val;
	}

	public void setSc_status_val(String sc_status_val) {
		this.sc_status_val = sc_status_val;
	}

	public String getRd_status_val() {
		return rd_status_val;
	}

	public void setRd_status_val(String rd_status_val) {
		this.rd_status_val = rd_status_val;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getScrap_code() {
		return scrap_code;
	}

	public void setScrap_code(String scrap_code) {
		this.scrap_code = scrap_code;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getSc_id() {
		return sc_id;
	}

	public void setSc_id(String sc_id) {
		this.sc_id = sc_id;
	}

	public String getRd_id() {
		return rd_id;
	}

	public void setRd_id(String rd_id) {
		this.rd_id = rd_id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getSc_status() {
		return sc_status;
	}

	public void setSc_status(String sc_status) {
		this.sc_status = sc_status;
	}

	public String getRd_status() {
		return rd_status;
	}

	public void setRd_status(String rd_status) {
		this.rd_status = rd_status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}