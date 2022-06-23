package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TXuefeiDAO;
import com.model.TXuefei;
import com.model.TXuesheng;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class xuefeiAction extends ActionSupport
{
	private Integer id;
	private Integer xueshengId;
	private String niandu;
	private Integer jine;
	
	private String shijian;

	
	private TXuefeiDAO xuefeiDAO;
	
	
	public String xuefeiAdd()
	{
		TXuefei xuefei=new TXuefei();
		
		//xuefei.setId(id);
		xuefei.setXueshengId(xueshengId);
		xuefei.setNiandu(niandu);
		xuefei.setJine(jine);
		xuefei.setShijian(shijian);
		
		
		xuefeiDAO.save(xuefei);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		return "msg";
	}
	
	public String xuefeiMana()
	{
		String sql="from TXuefei where xueshengId="+xueshengId;
		List xuefeiList=xuefeiDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xuefeiList", xuefeiList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String xuefeiDel()
	{
		
		TXuefei xuefei=xuefeiDAO.findById(id);
		xuefeiDAO.delete(xuefei);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}

	
	public String xuefeiMine()
	{
		Map session=ActionContext.getContext().getSession();
		TXuesheng xuesheng=(TXuesheng)session.get("xuesheng");
		
		String sql="from TXuefei where xueshengId="+xuesheng.getId();
		List xuefeiList=xuefeiDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xuefeiList", xuefeiList);
		return ActionSupport.SUCCESS;
	}
	
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getXueshengId()
	{
		return xueshengId;
	}

	public void setXueshengId(Integer xueshengId)
	{
		this.xueshengId = xueshengId;
	}

	public String getNiandu()
	{
		return niandu;
	}

	public void setNiandu(String niandu)
	{
		this.niandu = niandu;
	}

	public Integer getJine()
	{
		return jine;
	}

	public void setJine(Integer jine)
	{
		this.jine = jine;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public TXuefeiDAO getXuefeiDAO()
	{
		return xuefeiDAO;
	}

	public void setXuefeiDAO(TXuefeiDAO xuefeiDAO)
	{
		this.xuefeiDAO = xuefeiDAO;
	}
	
	
}
