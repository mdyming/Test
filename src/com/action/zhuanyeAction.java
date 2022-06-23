package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TZhuanyeDAO;
import com.model.TZhuanye;
import com.opensymphony.xwork2.ActionSupport;

public class zhuanyeAction extends ActionSupport
{
	private Integer id;
	private String mingcheng;
	private String jieshao;
	
	private TZhuanyeDAO zhuanyeDAO;
	
	
	public String zhuanyeAdd()
	{
		TZhuanye zhuanye=new TZhuanye();
		
		//zhuanye.setId(id);
		zhuanye.setMingcheng(mingcheng);
		zhuanye.setDel("no");
		
		
		zhuanyeDAO.save(zhuanye);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		return "msg";
	}
	
	public String zhuanyeMana()
	{
		String sql="from TZhuanye where del='no'";
		List zhuanyeList=zhuanyeDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhuanyeList", zhuanyeList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String zhuanyeDel()
	{
		
		TZhuanye zhuanye=zhuanyeDAO.findById(id);
		zhuanye.setDel("yes");
		zhuanyeDAO.attachDirty(zhuanye);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	
	public String zhuanyeAll()
	{
		String sql="from TZhuanye where del='no'";
		List zhuanyeList=zhuanyeDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhuanyeList", zhuanyeList);
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

	public String getJieshao()
	{
		return jieshao;
	}

	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}

	public String getMingcheng()
	{
		return mingcheng;
	}

	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}


	public TZhuanyeDAO getZhuanyeDAO()
	{
		return zhuanyeDAO;
	}

	public void setZhuanyeDAO(TZhuanyeDAO zhuanyeDAO)
	{
		this.zhuanyeDAO = zhuanyeDAO;
	}

}
