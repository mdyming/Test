package com.model;

/**
 * TXuesheng generated by MyEclipse Persistence Tools
 */

public class TXuesheng implements java.io.Serializable
{

	private Integer id;
	private Integer zhuanyeId;
	private String xuehao;
	private String xingming;

	private String xingbie;
	private String nianling;
	private String loginpw;
	private String del;
	
	private TZhuanye zhuanye;


	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
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

	public TZhuanye getZhuanye()
	{
		return zhuanye;
	}

	public void setZhuanye(TZhuanye zhuanye)
	{
		this.zhuanye = zhuanye;
	}

	public String getLoginpw()
	{
		return loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getNianling()
	{
		return nianling;
	}

	public void setNianling(String nianling)
	{
		this.nianling = nianling;
	}

	public String getXingbie()
	{
		return xingbie;
	}

	public void setXingbie(String xingbie)
	{
		this.xingbie = xingbie;
	}

	public String getXingming()
	{
		return xingming;
	}

	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}

	public String getXuehao()
	{
		return xuehao;
	}

	public void setXuehao(String xuehao)
	{
		this.xuehao = xuehao;
	}

}