package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TXueshengDAO;
import com.dao.TZhuanyeDAO;
import com.model.TXuesheng;
import com.opensymphony.xwork2.ActionSupport;

public class xueshengAction extends ActionSupport
{
	private Integer id;
	private Integer zhuanyeId;
	private String xuehao;
	private String xingming;

	private String xingbie;
	private String nianling;
	private String loginpw;
	private String del;
	
	private TXueshengDAO xueshengDAO;
	private TZhuanyeDAO zhuanyeDAO;
	
	public String xueshengAdd()
	{
		String sql="from TXuesheng where xuehao=?";
		Object[] c={xuehao.trim()};
		List list=xueshengDAO.getHibernateTemplate().find(sql,c);
		if(list.size()>0)
		{
			Map request=(Map)ServletActionContext.getContext().get("request");
			request.put("msg", "学号重复，请重新输入");
			return "msg";
		}
		
		TXuesheng xuesheng=new TXuesheng();
		
		xuesheng.setZhuanyeId(zhuanyeId);
		xuesheng.setXuehao(xuehao.trim());
		xuesheng.setXingming(xingming);
		xuesheng.setXingbie(xingbie);
		
		xuesheng.setNianling(nianling);
		xuesheng.setLoginpw(loginpw);
		xuesheng.setDel("no");
		
		xueshengDAO.save(xuesheng);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		return "msg";
	}
	
	public String xueshengMana()
	{
		String sql="from TXuesheng where del='no' order by zhuanyeId";
		List xueshengList=xueshengDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<xueshengList.size();i++)
		{
			TXuesheng xuesheng=(TXuesheng)xueshengList.get(i);
			xuesheng.setZhuanye(zhuanyeDAO.findById(xuesheng.getZhuanyeId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xueshengList", xueshengList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String xueshengDel()
	{
		
		TXuesheng xuesheng=xueshengDAO.findById(id);
		xuesheng.setDel("yes");
		xueshengDAO.attachDirty(xuesheng);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	public String xueshengRes()
	{
		StringBuffer sql=new StringBuffer("from TXuesheng where del='no'");
		if(zhuanyeId !=0)
		{
			sql.append(" and zhuanyeId="+zhuanyeId);
		}
		sql.append(" and xuehao like '%"+xuehao.trim()+"%'");
		sql.append(" and xingming like '%"+xingming.trim()+"%'");
		
		
		
		List xueshengList=xueshengDAO.getHibernateTemplate().find(sql.toString());
		for(int i=0;i<xueshengList.size();i++)
		{
			TXuesheng xuesheng=(TXuesheng)xueshengList.get(i);
			xuesheng.setZhuanye(zhuanyeDAO.findById(xuesheng.getZhuanyeId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xueshengList", xueshengList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String xueshengEditMe()
	{
		TXuesheng xuesheng=xueshengDAO.findById(id);
		
		xuesheng.setXuehao(xuehao);
		xuesheng.setXingming(xingming);
		xuesheng.setXingbie(xingbie);
		
		xuesheng.setNianling(nianling);
		xuesheng.setLoginpw(loginpw);
		
		xueshengDAO.attachDirty(xuesheng);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "修改成功，重新登陆后生效");
		return "msg";
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getZhuanyeId()
	{
		return zhuanyeId;
	}

	public void setZhuanyeId(Integer zhuanyeId)
	{
		this.zhuanyeId = zhuanyeId;
	}

	public String getXuehao()
	{
		return xuehao;
	}

	public void setXuehao(String xuehao)
	{
		this.xuehao = xuehao;
	}

	public String getXingming()
	{
		return xingming;
	}

	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}

	public String getXingbie()
	{
		return xingbie;
	}

	public void setXingbie(String xingbie)
	{
		this.xingbie = xingbie;
	}

	public String getNianling()
	{
		return nianling;
	}

	public void setNianling(String nianling)
	{
		this.nianling = nianling;
	}

	public String getLoginpw()
	{
		return loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
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
	
}
