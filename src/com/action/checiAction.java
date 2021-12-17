package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



import org.apache.struts2.ServletActionContext;


import com.dao.TCheciDAO;
import com.model.TCheci;
import com.opensymphony.xwork2.ActionSupport;

/*Dao��Ҫ�����ݿ�Ľ�������
  Modle ��ģ�� ������ʵ����
  Service ����Ӧ��ҵ���߼�����
  Action��һ��������
    
    ���洫�������������-��action
  action����-��service
  service����-��dao����
  dao������ɶ����ݿ�Ĳ�������
  �򻯣�JSP��Action��Service��DAO��Hibernate��
    
    ���������Ĳ�������model�����ʵ�������
   
   action��Struts�Ŀ��Ʋ�   
   service��mvc�еķ����
   model��javaʵ��bean
   dao�������ݿ���н����־ò�
   ssh����Hibernateʵ�֡� 
    
   Struts����ǰ̨���̨֮�����ݵĴ��ݡ���̨����߼�����֮��ҳ�����ת��
     ��̨ÿ��֮��ĵ���ͨ��Spring������ע�룬��service�ж�model�����߼�������
     Ȼ�󴫵ݸ�dao����dao������Hibernate�����ݿ���г־û����������������Ƿ�Ӧ�з���ֵ��
     ���action�н���ҳ����ת��
     
   action�ܸ���service��ʵʩ
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
		request.put("msg", "��Ϣ������");
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
		request.put("msg", "��Ϣɾ�����");
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
		request.put("msg", "��Ϣ�޸����");
		return "msg";
	}
	
	public String checiAll()
	{
		//
		String sql="from TCheci where del='no' and riqi>? order by riqi ";//�ж������Ƿ����
		Object[] c={new SimpleDateFormat("yyyy-MM-dd").format(new Date())};//��ʽ����ǰ����
		List checiList=checiDAO.getHibernateTemplate().find(sql,c);//����������ص���һ��List����
		
		Map request=(Map)ServletActionContext.getContext().get("request");//��Action�����ȡrequest����
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
