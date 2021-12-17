package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TCheci;

/**
 * Data access object (DAO) for domain model class TCheci.
 * 
 * @see com.model.TCheci
 * @author MyEclipse Persistence Tools
 */
/*dao�����У���������save delete find �����������Լ�����Ҫ����ʹ��*/
public class TCheciDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TCheciDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TCheci transientInstance)  //��ӳ��εķ���
	{
		log.debug("saving TCheci instance");
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

	public void delete(TCheci persistentInstance)  //ɾ�����εķ���
	{
		log.debug("deleting TCheci instance");
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

	public TCheci findById(java.lang.Integer id)   //�û����ҳ��εķ���
	{
		log.debug("getting TCheci instance with id: " + id);
		try
		{
			TCheci instance = (TCheci) getHibernateTemplate().get(
					"com.model.TCheci", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TCheci instance)  //����ʾ��
	{
		log.debug("finding TCheci instance by example");
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
		log.debug("finding TCheci instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TCheci as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()  //�����г�����Ϣ
	{
		log.debug("finding all TCheci instances");
		try
		{
			String queryString = "from TCheci";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TCheci merge(TCheci detachedInstance)  //�ϲ�������Ϣʾ��
	{
		log.debug("merging TCheci instance");
		try
		{
			TCheci result = (TCheci) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TCheci instance)
	{
		log.debug("attaching dirty TCheci instance");
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

	public void attachClean(TCheci instance)   //���θ��������
	{
		log.debug("attaching clean TCheci instance");
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

	public static TCheciDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TCheciDAO) ctx.getBean("TCheciDAO");
	}
}