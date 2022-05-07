package com.reclamation.rservice.domain;


public class Dict implements java.io.Serializable {
	/**
	 * 版本�?
	 */
	private static final long serialVersionUID = 3192414484208636093L;

	private Integer id;

	private String dict_tabname;

	private String dict_colname;

	private String dict_option;

	private String dict_text;

	private Integer dict_sort;

	private String dict_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDict_tabname() {
		return dict_tabname;
	}

	public void setDict_tabname(String dict_tabname) {
		this.dict_tabname = dict_tabname;
	}

	public String getDict_colname() {
		return dict_colname;
	}

	public void setDict_colname(String dict_colname) {
		this.dict_colname = dict_colname;
	}

	public String getDict_option() {
		return dict_option;
	}

	public void setDict_option(String dict_option) {
		this.dict_option = dict_option;
	}

	public String getDict_text() {
		return dict_text;
	}

	public void setDict_text(String dict_text) {
		this.dict_text = dict_text;
	}

	public Integer getDict_sort() {
		return dict_sort;
	}

	public void setDict_sort(Integer dict_sort) {
		this.dict_sort = dict_sort;
	}

	public String getDict_name() {
		return dict_name;
	}

	public void setDict_name(String dict_name) {
		this.dict_name = dict_name;
	}

}