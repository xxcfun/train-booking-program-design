package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TCheciDAO;
import com.dao.TOrderDAO;
import com.dao.TOrderitemDAO;
import com.dao.TUserDAO;
import com.model.TCheci;
import com.model.TOrder;
import com.model.TOrderitem;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Cart;

public class buyAction extends ActionSupport
{
	private String message;
	private String path;
	
	private TCheciDAO checiDAO;
	private TOrderDAO orderDAO;
	private TOrderitemDAO orderitemDAO;
	private TUserDAO userDAO;
	
	public String addToCart()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Cart cart =(Cart)session.getAttribute("cart");
		
		String id=String.valueOf(new Date().getTime());
		String orderId="";
		//��ÿͻ��˷�������������������Ϊtimes������ֵ
		int checiId=Integer.parseInt(request.getParameter("checiId"));//getParameter��ȡ����
		String piaoleixing=request.getParameter("piaoleixing");
		String zuoweihao = request.getParameter("zuoweihao");
		String zwIndex = request.getParameter("zwIndex");
		int danjia=0;
		if(piaoleixing.equals("����Ʊ")){danjia=checiDAO.findById(checiId).getChengrenpiaojia();}if(piaoleixing.equals("��ͯƱ")){danjia=checiDAO.findById(checiId).getErtongpiaojia();}
		
		int shuliang=Integer.parseInt(request.getParameter("shuliang"));
		TCheci checi=checiDAO.findById(checiId);
		
		TOrderitem orderItem=new TOrderitem();
		
		orderItem.setId(id);
		orderItem.setOrderId(orderId);
		orderItem.setCheciId(checiId);
		orderItem.setPiaoleixing(piaoleixing);

		orderItem.setDanjia(danjia);
		orderItem.setShuliang(shuliang);
		orderItem.setCheci(checi);
		orderItem.setZuoweihao(zuoweihao);
		orderItem.setZwIndex(zwIndex);
		
		cart.addCheci(id, orderItem);
		
		session.setAttribute("cart", cart);
		
		request.setAttribute("msg", "�ɹ����빺�ﳵ");
		return "msg";
	}
	
	
	public String delFromCart()//�û��Լ�ɾ������
	{
		HttpServletRequest request=ServletActionContext.getRequest();//��ȡsession����
		HttpSession session=request.getSession();//��session�л�ȡuser����
		Cart cart =(Cart)session.getAttribute("cart");
		
		cart.delCheci(request.getParameter("id"));
		
        session.setAttribute("cart", cart);
        this.setMessage("ɾ���ɹ�");
        this.setPath("toCart.action");
		return "succeed";
	}
	
	
	public String orderAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Cart cart =(Cart)session.getAttribute("cart");
		TUser user=(TUser)session.getAttribute("user");
		
		String id=String.valueOf(new Date().getTime());
		
		TOrder order=new TOrder();
		
		order.setId(id);
		order.setUserId(user.getUserId());
		order.setXiadanshi(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		order.setShouhourenming(request.getParameter("shouhourenming"));
		
		order.setShouhourenhua(request.getParameter("shouhourenhua"));
		order.setShouhourenzhi(request.getParameter("shouhourenzhi"));
		order.setZongjiage(cart.getTotalPrice());
		order.setZhuangtai("δ����");
		
		orderDAO.save(order);
		
		for (Iterator it = cart.getItems().values().iterator(); it.hasNext();)
		{
			TOrderitem orderItem = (TOrderitem) it.next();
			orderItem.setOrderId(id);
			orderitemDAO.save(orderItem);
			
			jianqu_piaoshu(orderItem.getCheciId(),orderItem.getShuliang());
		}
		
		cart.getItems().clear();
		session.setAttribute("cart", cart);
		
		this.setMessage("�µ��ɹ�");
		this.setPath("checiAll.action");
		return "succeed";
		
	}
	
	
	public String orderMana()
	{
		String sql="from TOrder order by zhuangtai";
		List orderList=orderDAO.getHibernateTemplate().find(sql);
		
		for(int i=0;i<orderList.size();i++)
		{
			TOrder order=(TOrder)orderList.get(i);
			order.setUser(userDAO.findById(order.getUserId()));
		}
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("orderList", orderList);
		return ActionSupport.SUCCESS;
	}
	

	public String orderShouli()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		
		TOrder order=orderDAO.findById(id);//����������ö���
		order.setZhuangtai("������");//�Ѿ�������
		orderDAO.attachDirty(order);//��������
		
		request.setAttribute("msg", "�����������");
		return "msg";
	}
	
	
	public String orderDelAd()//����Աɾ������
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		
		TOrder order=orderDAO.findById(id);//��ö�������
		String sql="delete from TOrderitem where orderId="+order.getId();//ƴһ��ɾ��������SQL
		orderitemDAO.getHibernateTemplate().bulkUpdate(sql);//ִ�и�SQL
		
		orderDAO.delete(order);//ɾ���ö���
		
		request.setAttribute("msg", "����ɾ�����");
		return "msg";
	}
	
	
	public String orderDetail()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String orderId=request.getParameter("orderId");
		
		String sql="from TOrderitem where orderId=?";
		Object[] c={orderId};
		List orderitemList=orderitemDAO.getHibernateTemplate().find(sql,c);
		for(int i=0;i<orderitemList.size();i++)
		{
			TOrderitem orderitem=(TOrderitem)orderitemList.get(i);
			orderitem.setCheci(checiDAO.findById(orderitem.getCheciId()));
		}
		request.setAttribute("orderitemList", orderitemList);
		return ActionSupport.SUCCESS;
	}
	
	public String toCart(){
		HttpServletRequest request=ServletActionContext.getRequest();
		return ActionSupport.SUCCESS;
	}
	public String orderEdit()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
			TOrder order=orderDAO.findById(id);
			if(order!=null){
			if(order.getZhuangtai().equals("������"))
			{
				this.setMessage("��Ǹ�����Ķ����Ѿ���������ȡ��������");
			}
			else
			{
				String sql="delete from TOrderitem where orderId="+order.getId();
				orderitemDAO.getHibernateTemplate().bulkUpdate(sql);
				orderDAO.delete(order);
				Cart cart =(Cart)request.getSession().getAttribute("cart");
				cart.getItems().clear();
				request.getSession().setAttribute("cart", cart);
				this.setMessage("��ǩ�ɹ��������¹�Ʊ��");
			}
		}
		this.setPath("toCart.action");
		return "succeed";
	}
	
	
	public String orderMine()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		TUser user=(TUser)session.getAttribute("user");
		
		String sql="from TOrder where userId="+user.getUserId();
		List orderList=orderDAO.getHibernateTemplate().find(sql);
		
		request.setAttribute("orderList", orderList);
		return ActionSupport.SUCCESS;
	}
	
	public String usedSeats()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String checiId = request.getParameter("checiId");
		String sql="from TOrderitem where checiId="+checiId;
		List list=orderDAO.getHibernateTemplate().find(sql);
		String seatsData ="";
		for (TOrderitem object : (List<TOrderitem>)list) {
			String[] arr = object.getZwIndex().split(",");
			for (int i = 0; i < arr.length; i++) {
				seatsData +="\'"+arr[i]+"\',";
			}
		}
		request.setAttribute("seatsList", seatsData);
		request.setAttribute("checiId", checiId);
//		Map req=(Map)ServletActionContext.getContext().get("request");
//		req.put("seatsList", seatsData);
//		req.put("checiId", checiId);
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderQuxiao()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		
		TOrder order=orderDAO.findById(id);
		if(order.getZhuangtai().equals("������"))
		{
			this.setMessage("��Ǹ�����Ķ����Ѿ���������ȡ������");
		}
		else
		{
			String sql="delete from TOrderitem where orderId="+order.getId();
			orderitemDAO.getHibernateTemplate().bulkUpdate(sql);
			
			orderDAO.delete(order);
			this.setMessage("�˶��ɹ�");
		}
		
		this.setPath("orderMine.action");
		return "succeed";
	}
	
	public void jianqu_piaoshu(int checiId,int shuliang)
	{
		TCheci checi=checiDAO.findById(checiId);
		checi.setShengpiao(checi.getShengpiao()-shuliang);
		checiDAO.attachDirty(checi);
	}

	public TCheciDAO getCheciDAO()
	{
		return checiDAO;
	}

	public void setCheciDAO(TCheciDAO checiDAO)
	{
		this.checiDAO = checiDAO;
	}


	public String getMessage()
	{
		return message;
	}


	public void setMessage(String message)
	{
		this.message = message;
	}


	public TUserDAO getUserDAO()
	{
		return userDAO;
	}


	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public TOrderDAO getOrderDAO()
	{
		return orderDAO;
	}


	public void setOrderDAO(TOrderDAO orderDAO)
	{
		this.orderDAO = orderDAO;
	}


	public TOrderitemDAO getOrderitemDAO()
	{
		return orderitemDAO;
	}


	public void setOrderitemDAO(TOrderitemDAO orderitemDAO)
	{
		this.orderitemDAO = orderitemDAO;
	}


	public String getPath()
	{
		return path;
	}


	public void setPath(String path)
	{
		this.path = path;
	}
	
}
