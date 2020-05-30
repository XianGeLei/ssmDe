package com.entity;

public class Health {
		private Integer id;
	private String sdate;
	private String name;
	private String danwei;
	private String xiangmu;
	private String jieguo;
	private String cuoshi;
	private String beizhu;
	private String uname;
	private String zt;
	private String yijian;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getSdate()
	{
		return sdate;
	}
	public void setSdate(String sdate)
	{
		this.sdate = sdate;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDanwei()
	{
		return danwei;
	}
	public void setDanwei(String danwei)
	{
		this.danwei = danwei;
	}
	
	public String getXiangmu()
	{
		return xiangmu;
	}
	public void setXiangmu(String xiangmu)
	{
		this.xiangmu = xiangmu;
	}
	
	public String getJieguo()
	{
		return jieguo;
	}
	public void setJieguo(String jieguo)
	{
		this.jieguo = jieguo;
	}
	
	public String getCuoshi()
	{
		return cuoshi;
	}
	public void setCuoshi(String cuoshi)
	{
		this.cuoshi = cuoshi;
	}
	
	public String getBeizhu()
	{
		return beizhu;
	}
	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	
	public String getZt()
	{
		return zt;
	}
	public void setZt(String zt)
	{
		this.zt = zt;
	}
	
	public String getYijian()
	{
		return yijian;
	}
	public void setYijian(String yijian)
	{
		this.yijian = yijian;
	}
	@Override

	public String toString() {

		return "Health [id=" + id + ", sdate=" + sdate + ", name=" + name + ", danwei=" + danwei + ", xiangmu=" + xiangmu + ", jieguo=" + jieguo + ", cuoshi=" + cuoshi + ", beizhu=" + beizhu + ", uname=" + uname + ", zt=" + zt + ", yijian=" + yijian + "]";

	}
}