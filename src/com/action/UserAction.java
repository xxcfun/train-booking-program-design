package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TUserDAO;
import com.model.TCheci;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*��¼����*/
/*������action�㣺���Ǹ�����ҳ��ͳ���֮�䴫�����ݵģ�������������ҳ����ת��
 * ҳ�����û���д�����ݣ�����ύ��ť��ҳ��ı�������Hibernate�Զ���װ����ҳ�������Ӧ��Action
 * ��Action��ʵ���಻��һ��������Action��ҳ����ʲôֵ�������дʲô���ԣ���������װ�������õģ�
 * ��ʵ��������ȫ�������ݿ���ֶ����ɵģ�ʵ������Ե���Action�ã���Action���Բ����Ե���ʵ�����ã���
 * ���������ݾ���Action�������ʽ��Action�ĵ������¼��ִ�е��Ǹ�����������ˡ����ʱ����Ҫ���ľ��ǰѱ����ݴ������ݿ��С�
 * ��ʱ��Action�Ĺ��ܸ�һ���䣬�����ǰ����ݴ���service�㡣
 * 
 * service�㣨ҵ���߼��㣩��������Ƕ����ݵĴ������û�����ݴ�������Ļ����˲�ֻ�����������ݴ������ã������ֵ���DAO�㡣
 * DAO�㣨���ݿ�����㣩����������������ݿ���ɾ�Ĳ�Ĳ�����
        */
public class UserAction extends ActionSupport
{
    	
	private Integer userId;
	private String userName;
	private String userPw;
	private String userRealname;

	private String userSex;
	private int userAge;
	private String userAddress;
	private String userTel;
	
	private String userDel;
	
	
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;
	
	
	//��Աע��
	public String userReg()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		
		
		
		String sql="from TUser where userName=? and userDel='no'";
		Object[] c={userName.trim()};//trim()ȥ���ַ�����ͷ�ͽ�β�Ŀո�
		List list=userDAO.getHibernateTemplate().find(sql,c);
		if(list.size()>0)
		{
			request.put("msg", "�˺��ظ�������������");  //
			return "msg";
		}
		
		
		TUser user=new TUser();
		
		//user.setUserId(userId);
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setUserRealname(userRealname);
		
		user.setUserSex(userSex);
		user.setUserAge(userAge);
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		
		user.setUserDel("no");
		
		userDAO.save(user);

		
		request.put("msg", "ע��ɹ������¼");
		return "msg";
	}
	
	
	
	//��Ա�޸ĸ�������
	public String userEdit()
	{
		TUser user=userDAO.findById(userId);
		
		//user.setUserId(userId);
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setUserRealname(userRealname);
		
		user.setUserSex(userSex);
		user.setUserAge(userAge);
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		
		userDAO.attachDirty(user);

		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "�޸ĳɹ������µ�¼����Ч");
		return "msg";
	}
	
	
		
	
	//����Աɾ����Ա
	public String userDel()
	{
		TUser user=userDAO.findById(userId);
		user.setUserDel("yes");
		userDAO.attachDirty(user);
		
		this.setMessage("ɾ���ɹ�");
		this.setPath("userMana.action");
		return "succeed";
	}
	
	
	
	//����Ա�鿴��Ա��Ϣ
	public String userXinxi()
	{
        String sql="from TUser where userId="+userId;
		
		List userList=userDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	//��Ա����

	public String userMana()
	{
		String sql="from TUser where userDel='no'";
		
		List userList=userDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String userAll()
	{
		String sql="from TUser where userDel='no'";
		
		List userList=userDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String userDetailQian()
	{
		TUser user=userDAO.findById(userId);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("user", user);
		return ActionSupport.SUCCESS;
	}
	
	
	public String userSearch()
	{
		String sql="from TUser where userRealname like '%"+userRealname.trim()+"%'";
		
		List userList=userDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getPath()
	{
		return path;
	}
	




	public void setPath(String path)
	{
		this.path = path;
	}
	public String getUserAddress()
	{
		return userAddress;
	}
	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}
	public int getUserAge()
	{
		return userAge;
	}
	public void setUserAge(int userAge)
	{
		this.userAge = userAge;
	}
	public String getUserDel()
	{
		return userDel;
	}
	public void setUserDel(String userDel)
	{
		this.userDel = userDel;
	}
	public TUserDAO getUserDAO()
	{
		return userDAO;
	}
	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserPw()
	{
		return userPw;
	}
	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}
	public String getUserRealname()
	{
		return userRealname;
	}
	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}
	public String getUserSex()
	{
		return userSex;
	}
	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}
	public String getUserTel()
	{
		return userTel;
	}
	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}
	
}
