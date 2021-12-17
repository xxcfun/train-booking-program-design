package com.model;

/**
 * TOrderItem generated by MyEclipse Persistence Tools
 */

public class TOrderitem implements java.io.Serializable
{

	private String id;
	private String orderId;
	private Integer checiId;
	private String piaoleixing;//成人票，儿童票
	
	private Integer danjia;
	private Integer shuliang;
	
	private TCheci checi;//表里没有。自己加的
	private String zuoweihao;//在线选座座位号
	private String zwIndex;//在线选座座位索引

	public TCheci getCheci()
	{
		return checi;
	}

	public void setCheci(TCheci checi)
	{
		this.checi = checi;
	}

	public Integer getCheciId()
	{
		return checiId;
	}

	public void setCheciId(Integer checiId)
	{
		this.checiId = checiId;
	}

	public String getOrderId()
	{
		return orderId;
	}

	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}


	public int getDanjia()
	{
		return danjia;
	}

	public void setDanjia(int danjia)
	{
		this.danjia = danjia;
	}


	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getPiaoleixing()
	{
		return piaoleixing;
	}

	public void setPiaoleixing(String piaoleixing)
	{
		this.piaoleixing = piaoleixing;
	}

	public Integer getShuliang()
	{
		return shuliang;
	}

	public void setShuliang(Integer shuliang)
	{
		this.shuliang = shuliang;
	}

	public String getZuoweihao() {
		return zuoweihao;
	}

	public void setZuoweihao(String zuoweihao) {
		this.zuoweihao = zuoweihao;
	}

	public String getZwIndex() {
		return zwIndex;
	}

	public void setZwIndex(String zwIndex) {
		this.zwIndex = zwIndex;
	}

	
	
}