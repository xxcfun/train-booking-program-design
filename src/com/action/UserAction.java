package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TUserDAO;
import com.model.TCheci;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*登录举例*/
/*首先是action层：它是负责在页面和程序之间传输数据的，还有作用是做页面跳转。
 * 页面由用户填写表单数据，点击提交按钮，页面的表单数据由Hibernate自动封装到该页面表单所对应的Action
 * （Action跟实体类不是一个东西，Action是页面有什么值，类里就写什么属性，是用来封装表单数据用的；
 * 而实体类是完全按照数据库的字段生成的，实体类可以当做Action用，但Action绝对不可以当做实体类用），
 * 这样表单数据就以Action对象的形式在Action的点击“登录”执行的那个方法里存在了。这个时候需要做的就是把表单数据存入数据库中。
 * 此时，Action的功能告一段落，接着是把数据传入service层。
 * 
 * service层（业务逻辑层）：负责的是对数据的处理。如果没有数据处理任务的话，此层只做单纯的数据传递作用，而后又到了DAO层。
 * DAO层（数据库操作层）：负责对数据向数据库增删改查的操作。
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
	
	
	//会员注册
	public String userReg()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		
		
		
		String sql="from TUser where userName=? and userDel='no'";
		Object[] c={userName.trim()};//trim()去掉字符串开头和结尾的空格
		List list=userDAO.getHibernateTemplate().find(sql,c);
		if(list.size()>0)
		{
			request.put("msg", "账号重复，请重新输入");  //
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

		
		request.put("msg", "注册成功，请登录");
		return "msg";
	}
	
	
	
	//会员修改个人资料
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
		request.put("msg", "修改成功。重新登录后生效");
		return "msg";
	}
	
	
		
	
	//管理员删除会员
	public String userDel()
	{
		TUser user=userDAO.findById(userId);
		user.setUserDel("yes");
		userDAO.attachDirty(user);
		
		this.setMessage("删除成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	
	
	
	//管理员查看会员信息
	public String userXinxi()
	{
        String sql="from TUser where userId="+userId;
		
		List userList=userDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	//会员管理

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
