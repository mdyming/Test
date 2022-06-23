package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TXuefei;

/**
 * A data access object (DAO) providing persistence and search support for
 * TXuefei entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TXuefei
 * @author MyEclipse Persistence Tools
 */

public class TXuefeiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TXuefeiDAO.class);
	// property constants
	public static final String XUESHENG_ID = "xueshengId";
	public static final String NIANDU = "niandu";
	public static final String JINE = "jine";
	public static final String SHIJIAN = "shijian";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TXuefei transientInstance)
	{
		log.debug("saving TXuefei instance");
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

	public void delete(TXuefei persistentInstance)
	{
		log.debug("deleting TXuefei instance");
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

	public TXuefei findById(java.lang.Integer id)
	{
		log.debug("getting TXuefei instance with id: " + id);
		try
		{
			TXuefei instance = (TXuefei) getHibernateTemplate().get(
					"com.model.TXuefei", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TXuefei instance)
	{
		log.debug("finding TXuefei instance by example");
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
		log.debug("finding TXuefei instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TXuefei as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByXueshengId(Object xueshengId)
	{
		return findByProperty(XUESHENG_ID, xueshengId);
	}

	public List findByNiandu(Object niandu)
	{
		return findByProperty(NIANDU, niandu);
	}

	public List findByJine(Object jine)
	{
		return findByProperty(JINE, jine);
	}

	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}

	public List findAll()
	{
		log.debug("finding all TXuefei instances");
		try
		{
			String queryString = "from TXuefei";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TXuefei merge(TXuefei detachedInstance)
	{
		log.debug("merging TXuefei instance");
		try
		{
			TXuefei result = (TXuefei) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TXuefei instance)
	{
		log.debug("attaching dirty TXuefei instance");
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

	public void attachClean(TXuefei instance)
	{
		log.debug("attaching clean TXuefei instance");
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

	public static TXuefeiDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TXuefeiDAO) ctx.getBean("TXuefeiDAO");
	}
}