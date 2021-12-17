package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



import org.apache.struts2.ServletActionContext;


import com.dao.TGonggaoDAO;
import com.model.TGonggao;
import com.opensymphony.xwork2.ActionSupport;



public class gonggaoAction extends ActionSupport
{
    private Integer id;
	
	private String gonggao;

	private String del;
	
	private TGonggaoDAO gonggaoDAO;
	
	public String gonggaoAdd()
	{
			
		TGonggao gonggaoneirong=new TGonggao();
		
		gonggaoneirong.setGonggao(gonggao);
	
		gonggaoneirong.setDel("no");
		
		
		gonggaoDAO.save(gonggaoneirong);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加完毕");
		return "msg";
	}
	
	
	public String gonggaoMana()
	{
		String sql="from TGonggao where del='no' order by gonggao";
		List gonggaoList=gonggaoDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("gonggaoList", gonggaoList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String gonggaoDel()
	{
		TGonggao gonggao=gonggaoDAO.findById(id);
		gonggao.setDel("yes");
		gonggaoDAO.attachDirty(gonggao);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除完毕");
		return "msg";
	}
	
	public String gonggaoEditTo()
	{
		TGonggao gonggao=gonggaoDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("gonggao", gonggao);
		return ActionSupport.SUCCESS;
	}
	
	public String gonggaoEditSuc()
	{
		TGonggao gonggao=gonggaoDAO.findById(id);
	
		gonggaoDAO.attachDirty(gonggao);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息修改完毕");
		return "msg";
	}
	
	public String gonggaoAll()
	{
		//
		String sql="from TGonggao where del='no' and gonggao>? order by gonggao ";//判断日期是否过期
		Object[] c={new SimpleDateFormat("yyyy-MM-dd").format(new Date())};//格式化当前日期
		List gonggaoList=gonggaoDAO.getHibernateTemplate().find(sql,c);//这个方法返回的是一个List集合
		
		Map request=(Map)ServletActionContext.getContext().get("request");//在Action里面获取request对象
		request.put("gonggaoList", gonggaoList);
		return ActionSupport.SUCCESS;
	}

	
	public String gonggaoDetailQian()
	{
		TGonggao gonggao=gonggaoDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("gonggao", gonggao);
		return ActionSupport.SUCCESS;
	}

	
	

	public String getDel()
	{
		return del;
	}


	public void setDel(String del)
	{
		this.del = del;
	}


	

	public TGonggaoDAO getGonggaoDAO()
	{
		return gonggaoDAO;
	}


	public void setGonggaoDAO(TGonggaoDAO gonggaoDAO)
	{
		this.gonggaoDAO = gonggaoDAO;
	}


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	


	public String getGonggao()
	{
		return gonggao;
	}


	public void setGonggao(String gonggao)
	{
		this.gonggao = gonggao;
	}


	
	
	
}
