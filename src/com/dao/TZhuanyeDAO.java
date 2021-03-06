package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TZhuanye;

/**
 * Data access object (DAO) for domain model class TZhuanye.
 * 
 * @see com.model.TZhuanye
 * @author MyEclipse Persistence Tools
 */

public class TZhuanyeDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TZhuanyeDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TZhuanye transientInstance)
	{
		log.debug("saving TZhuanye instance");
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

	public void delete(TZhuanye persistentInstance)
	{
		log.debug("deleting TZhuanye instance");
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

	public TZhuanye findById(java.lang.Integer id)
	{
		log.debug("getting TZhuanye instance with id: " + id);
		try
		{
			TZhuanye instance = (TZhuanye) getHibernateTemplate().get(
					"com.model.TZhuanye", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TZhuanye instance)
	{
		log.debug("finding TZhuanye instance by example");
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
		log.debug("finding TZhuanye instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TZhuanye as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all TZhuanye instances");
		try
		{
			String queryString = "from TZhuanye";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TZhuanye merge(TZhuanye detachedInstance)
	{
		log.debug("merging TZhuanye instance");
		try
		{
			TZhuanye result = (TZhuanye) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TZhuanye instance)
	{
		log.debug("attaching dirty TZhuanye instance");
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

	public void attachClean(TZhuanye instance)
	{
		log.debug("attaching clean TZhuanye instance");
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

	public static TZhuanyeDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TZhuanyeDAO) ctx.getBean("TZhuanyeDAO");
	}
}