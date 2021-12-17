package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



import org.apache.struts2.ServletActionContext;


import com.dao.TCheciDAO;
import com.model.TCheci;
import com.opensymphony.xwork2.ActionSupport;

/*Dao主要做数据库的交互工作
  Modle 是模型 存放你的实体类
  Service 做相应的业务逻辑处理
  Action是一个控制器
    
    界面传过来的请求调用-》action
  action调用-》service
  service调用-》dao方法
  dao方法完成对数据库的操作工作
  简化：JSP—Action—Service—DAO—Hibernate。
    
    里面所传的参数就是model里面的实体类参数
   
   action是Struts的控制层   
   service是mvc中的服务层
   model是java实体bean
   dao是与数据库进行交互持久层
   ssh中由Hibernate实现。 
    
   Struts负责前台与后台之间数据的传递、后台完成逻辑操作之后页面的跳转，
     后台每层之间的调用通过Spring进行类注入，在service中对model做出逻辑操作，
     然后传递给dao，在dao层中用Hibernate对数据库进行持久化操作，根据需求，是否应有返回值。
     最后到action中进行页面跳转。
     
   action管负责，service管实施
 */

public class checiAction extends ActionSupport
{
    private Integer id;
	
	private String riqi;
	private String bianhao;
	private String shifadi;
	private String daodadi;
	
	private String facheshi;
	private Integer shengpiao;
	private Integer chengrenpiaojia;
	
	private Integer ertongpiaojia;
	private String del;
	
	private TCheciDAO checiDAO;
	
	public String checiAdd()
	{
			
		TCheci checi=new TCheci();
		
		checi.setRiqi(riqi);
		checi.setBianhao(bianhao);
		checi.setShifadi(shifadi);
		checi.setDaodadi(daodadi);
		
		checi.setFacheshi(facheshi);
		checi.setShengpiao(shengpiao);
		checi.setChengrenpiaojia(chengrenpiaojia);
		
		checi.setErtongpiaojia(ertongpiaojia);
		checi.setDel("no");
		
		
		checiDAO.save(checi);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加完毕");
		return "msg";
	}
	
	
	public String checiMana()
	{
		String sql="from TCheci where del='no' order by riqi";
		List checiList=checiDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("checiList", checiList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String checiDel()
	{
		TCheci checi=checiDAO.findById(id);
		checi.setDel("yes");
		checiDAO.attachDirty(checi);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除完毕");
		return "msg";
	}
	
	public String checiEditTo()
	{
		TCheci checi=checiDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("checi", checi);
		return ActionSupport.SUCCESS;
	}
	
	public String checiEditSuc()
	{
		TCheci checi=checiDAO.findById(id);
		checi.setBianhao(bianhao);
		checi.setChengrenpiaojia(chengrenpiaojia);
		checi.setDaodadi(daodadi);
		checi.setErtongpiaojia(ertongpiaojia);
		checi.setFacheshi(facheshi);
		checi.setRiqi(riqi);
		checi.setShengpiao(shengpiao);
		checi.setShifadi(shifadi);
		checiDAO.attachDirty(checi);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息修改完毕");
		return "msg";
	}
	
	public String checiAll()
	{
		//
		String sql="from TCheci where del='no' and riqi>? order by riqi ";//判断日期是否过期
		Object[] c={new SimpleDateFormat("yyyy-MM-dd").format(new Date())};//格式化当前日期
		List checiList=checiDAO.getHibernateTemplate().find(sql,c);//这个方法返回的是一个List集合
		
		Map request=(Map)ServletActionContext.getContext().get("request");//在Action里面获取request对象
		request.put("checiList", checiList);
		return ActionSupport.SUCCESS;
	}

	
	public String checiDetailQian()
	{
		TCheci checi=checiDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("checi", checi);
		return ActionSupport.SUCCESS;
	}

	
	
	public String checiRes()
	{
		String sql="from TCheci where del='no' and riqi='"+riqi+"'"+" and shifadi like '%"+shifadi.trim()+"%'";
		List checiList=checiDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("checiList", checiList);
		return ActionSupport.SUCCESS;
	}
	public String getBianhao()
	{
		return bianhao;
	}


	public void setBianhao(String bianhao)
	{
		this.bianhao = bianhao;
	}



	public Integer getChengrenpiaojia()
	{
		return chengrenpiaojia;
	}


	public void setChengrenpiaojia(Integer chengrenpiaojia)
	{
		this.chengrenpiaojia = chengrenpiaojia;
	}


	public String getDaodadi()
	{
		return daodadi;
	}


	public void setDaodadi(String daodadi)
	{
		this.daodadi = daodadi;
	}


	public String getDel()
	{
		return del;
	}


	public void setDel(String del)
	{
		this.del = del;
	}


	public Integer getErtongpiaojia()
	{
		return ertongpiaojia;
	}


	public void setErtongpiaojia(Integer ertongpiaojia)
	{
		this.ertongpiaojia = ertongpiaojia;
	}


	public TCheciDAO getCheciDAO()
	{
		return checiDAO;
	}


	public void setCheciDAO(TCheciDAO checiDAO)
	{
		this.checiDAO = checiDAO;
	}


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public String getFacheshi()
	{
		return facheshi;
	}


	public void setFacheshi(String facheshi)
	{
		this.facheshi = facheshi;
	}


	public String getRiqi()
	{
		return riqi;
	}


	public void setRiqi(String riqi)
	{
		this.riqi = riqi;
	}


	public Integer getShengpiao()
	{
		return shengpiao;
	}


	public void setShengpiao(Integer shengpiao)
	{
		this.shengpiao = shengpiao;
	}


	public String getShifadi()
	{
		return shifadi;
	}


	public void setShifadi(String shifadi)
	{
		this.shifadi = shifadi;
	}
	
	
}
