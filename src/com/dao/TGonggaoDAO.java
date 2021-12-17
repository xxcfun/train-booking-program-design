package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TGonggao;

/**
 * Data access object (DAO) for domain model class TGonggao.
 * 
 * @see com.model.TGonggao
 * @author MyEclipse Persistence Tools
 */
/*dao方法中，都集成了save delete find 方法，根据自己的需要进行使用*/
public class TGonggaoDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TGonggaoDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TGonggao transientInstance)  //添加车次的方法
	{
		log.debug("saving TGonggao instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TGonggao persistentInstance)  //删除车次的方法
	{
		log.debug("deleting TGonggao instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TGonggao findById(java.lang.Integer id)   //用户查找车次的方法
	{
		log.debug("getting TGonggao instance with id: " + id);
		try
		{
			TGonggao instance = (TGonggao) getHibernateTemplate().get(
					"com.model.TGonggao", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TGonggao instance)  //查找示列
	{
		log.debug("finding TGonggao instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TGonggao instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TGonggao as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()  //查所有车次信息
	{
		log.debug("finding all TGonggao instances");
		try
		{
			String queryString = "from TGonggao";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TGonggao merge(TGonggao detachedInstance)  //合并车次信息示例
	{
		log.debug("merging TGonggao instance");
		try
		{
			TGonggao result = (TGonggao) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TGonggao instance)
	{
		log.debug("attaching dirty TGonggao instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TGonggao instance)   //车次附件的清除
	{
		log.debug("attaching clean TGonggao instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TGonggaoDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TGonggaoDAO) ctx.getBean("TGonggaoDAO");
	}
}