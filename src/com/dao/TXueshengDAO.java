package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TXuesheng;

/**
 * Data access object (DAO) for domain model class TXuesheng.
 * 
 * @see com.model.TXuesheng
 * @author MyEclipse Persistence Tools
 */

public class TXueshengDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TXueshengDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TXuesheng transientInstance)
	{
		log.debug("saving TXuesheng instance");
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

	public void delete(TXuesheng persistentInstance)
	{
		log.debug("deleting TXuesheng instance");
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

	public TXuesheng findById(java.lang.Integer id)
	{
		log.debug("getting TXuesheng instance with id: " + id);
		try
		{
			TXuesheng instance = (TXuesheng) getHibernateTemplate().get(
					"com.model.TXuesheng", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TXuesheng instance)
	{
		log.debug("finding TXuesheng instance by example");
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
		log.debug("finding TXuesheng instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TXuesheng as model where model."
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
		log.debug("finding all TXuesheng instances");
		try
		{
			String queryString = "from TXuesheng";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TXuesheng merge(TXuesheng detachedInstance)
	{
		log.debug("merging TXuesheng instance");
		try
		{
			TXuesheng result = (TXuesheng) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TXuesheng instance)
	{
		log.debug("attaching dirty TXuesheng instance");
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

	public void attachClean(TXuesheng instance)
	{
		log.debug("attaching clean TXuesheng instance");
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

	public static TXueshengDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TXueshengDAO) ctx.getBean("TXueshengDAO");
	}
}