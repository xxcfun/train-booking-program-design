package com.model;

/**
 * TOrder generated by MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable
{

	private String id;
	private int userId;
	private String xiadanshi;
	private String shouhourenming;
	
	private String shouhourenhua;
	private String shouhourenzhi;//已受理---未受理
	private int zongjiage=0;
	private String zhuangtai;
	
	private TUser user;
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getShouhourenhua()
	{
		return shouhourenhua;
	}
	public void setShouhourenhua(String shouhourenhua)
	{
		this.shouhourenhua = shouhourenhua;
	}
	public String getShouhourenming()
	{
		return shouhourenming;
	}
	public void setShouhourenming(String shouhourenming)
	{
		this.shouhourenming = shouhourenming;
	}
	public String getShouhourenzhi()
	{
		return shouhourenzhi;
	}
	public void setShouhourenzhi(String shouhourenzhi)
	{
		this.shouhourenzhi = shouhourenzhi;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getXiadanshi()
	{
		return xiadanshi;
	}
	
	public TUser getUser()
	{
		return user;
	}
	public void setUser(TUser user)
	{
		this.user = user;
	}
	public void setXiadanshi(String xiadanshi)
	{
		this.xiadanshi = xiadanshi;
	}
	
	public String getZhuangtai()
	{
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai)
	{
		this.zhuangtai = zhuangtai;
	}
	public int getZongjiage()
	{
		return zongjiage;
	}
	public void setZongjiage(int zongjiage)
	{
		this.zongjiage = zongjiage;
	}
	

}