package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TXunwuDAO;
import com.model.TAdmin;
import com.model.TXunwu;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class xunwuAction extends ActionSupport
{
	private Integer id;
	private String neirong;
	private String xunwushi;
	private Integer stuId;

	private String huifu;
	private String huifushi;
	
	private TXunwuDAO xunwuDAO;
	
	
	
	public String xunwuAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		TUser user=(TUser)session.getAttribute("user");
		
		TXunwu xunwu=new TXunwu();
		
		xunwu.setNeirong(neirong);
		xunwu.setXunwushi(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		xunwu.setUserId(user.getUserId());
		
		xunwu.setHuifu("");
		xunwu.setHuifushi("");
		xunwuDAO.save(xunwu);
		
		request.setAttribute("msg", "发布完毕");
		return "msg";
	}
	
	
	public String xunwuMana()
	{
		String sql="from TXunwu order by xunwushi";
		List xunwuList=xunwuDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xunwuList", xunwuList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String xunwuDel()
	{
		TXunwu xunwu=xunwuDAO.findById(id);
		xunwuDAO.delete(xunwu);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("msg", "删除成功");
		return "msg";
	}
	
	
	public String xunwuHuifu()
	{
		TXunwu xunwu=xunwuDAO.findById(id);
		xunwu.setHuifu(huifu);
		xunwu.setHuifushi(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		
		xunwuDAO.attachDirty(xunwu);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("msg", "回复完毕");
		return "msg";
	}
	
	
	public String xunwuDetail()
	{
		TXunwu xunwu=xunwuDAO.findById(id);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("xunwu", xunwu);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String xunwuAll()
	{
		String sql="from TXunwu order by xunwushi";
		List xunwuList=xunwuDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xunwuList", xunwuList);
		return ActionSupport.SUCCESS;
	}

	public String getHuifu()
	{
		return huifu;
	}

	public void setHuifu(String huifu)
	{
		this.huifu = huifu;
	}

	public String getHuifushi()
	{
		return huifushi;
	}

	public void setHuifushi(String huifushi)
	{
		this.huifushi = huifushi;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public TXunwuDAO getXunwuDAO()
	{
		return xunwuDAO;
	}

	public void setXunwuDAO(TXunwuDAO xunwuDAO)
	{
		this.xunwuDAO = xunwuDAO;
	}

	public String getXunwushi()
	{
		return xunwushi;
	}

	public void setXunwushi(String xunwushi)
	{
		this.xunwushi = xunwushi;
	}

	public String getNeirong()
	{
		return neirong;
	}

	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}

	public Integer getStuId()
	{
		return stuId;
	}

	public void setStuId(Integer stuId)
	{
		this.stuId = stuId;
	}
	
}
