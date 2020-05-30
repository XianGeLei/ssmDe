package com.entity;

import java.util.List;

public class User {
		private Integer id;
	private String name;
	private String sex;
	private String sdate;
	private String tel;
	private String xueli;
	private String addr;
	private String username;
	private String pwd;
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	private List<Role> roleList;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public String getSdate()
	{
		return sdate;
	}
	public void setSdate(String sdate)
	{
		this.sdate = sdate;
	}
	
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	
	public String getXueli()
	{
		return xueli;
	}
	public void setXueli(String xueli)
	{
		this.xueli = xueli;
	}
	
	public String getAddr()
	{
		return addr;
	}
	public void setAddr(String addr)
	{
		this.addr = addr;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", sdate='" + sdate + '\'' +
				", tel='" + tel + '\'' +
				", xueli='" + xueli + '\'' +
				", addr='" + addr + '\'' +
				", username='" + username + '\'' +
				", pwd='" + pwd + '\'' +
				", roleList=" + roleList +
				'}';
	}
}