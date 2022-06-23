package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TXuefeiDAO;
import com.dao.TXueshengDAO;
import com.dao.TZhuanyeDAO;
import com.model.TXuesheng;
import com.opensymphony.xwork2.ActionSupport;

public class tongjiAction extends ActionSupport
{
	private TXueshengDAO xueshengDAO;
	private TZhuanyeDAO zhuanyeDAO;
	private TXuefeiDAO xuefeiDAO;
	
	
	public String tongjiweijiaoRes()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String niandu=request.getParameter("niandu");
		
		
		List xueshengweijiao=new ArrayList();
		
		String sql="from TXuesheng where del='no' order by zhuanyeId";
		List xueshengList=xueshengDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<xueshengList.size();i++)
		{
			TXuesheng xuesheng=(TXuesheng)xueshengList.get(i);
			xuesheng.setZhuanye(zhuanyeDAO.findById(xuesheng.getZhuanyeId()));
			
			String ss="from TXuefei where xueshengId=? and niandu=?";
			Object[] c={xuesheng.getId(),niandu};
			List list=xuefeiDAO.getHibernateTemplate().find(ss,c);
			if(list.size()==0)
			{
				xueshengweijiao.add(xuesheng);
			}
			
		}
		
		request.setAttribute("xueshengweijiao", xueshengweijiao);
		return ActionSupport.SUCCESS;
	}

	
	
	
	public String tongjiyijiaoRes()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String niandu=request.getParameter("niandu");
		
		
		List xueshengyijiao=new ArrayList();
		
		String sql="from TXuesheng where del='no' order by zhuanyeId";
		List xueshengList=xueshengDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<xueshengList.size();i++)
		{
			TXuesheng xuesheng=(TXuesheng)xueshengList.get(i);
			xuesheng.setZhuanye(zhuanyeDAO.findById(xuesheng.getZhuanyeId()));
			
			String ss="from TXuefei where xueshengId=? and niandu=?";
			Object[] c={xuesheng.getId(),niandu};
			List list=xuefeiDAO.getHibernateTemplate().find(ss,c);
			if(list.size()>0)
			{
				xueshengyijiao.add(xuesheng);
			}
			
		}
		
		request.setAttribute("xueshengyijiao", xueshengyijiao);
		return ActionSupport.SUCCESS;
	}


	public TXueshengDAO getXueshengDAO()
	{
		return xueshengDAO;
	}


	public void setXueshengDAO(TXueshengDAO xueshengDAO)
	{
		this.xueshengDAO = xueshengDAO;
	}


	public TZhuanyeDAO getZhuanyeDAO()
	{
		return zhuanyeDAO;
	}


	public void setZhuanyeDAO(TZhuanyeDAO zhuanyeDAO)
	{
		this.zhuanyeDAO = zhuanyeDAO;
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
