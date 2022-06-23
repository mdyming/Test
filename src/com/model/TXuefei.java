package com.model;

/**
 * TXuefei entity. @author MyEclipse Persistence Tools
 */

public class TXuefei implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer xueshengId;
	private String niandu;
	private Integer jine;
	
	private String shijian;

	// Constructors

	/** default constructor */
	public TXuefei()
	{
	}

	/** full constructor */
	public TXuefei(Integer xueshengId, String niandu, Integer jine,
			String shijian)
	{
		this.xueshengId = xueshengId;
		this.niandu = niandu;
		this.jine = jine;
		this.shijian = shijian;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getXueshengId()
	{
		return this.xueshengId;
	}

	public void setXueshengId(Integer xueshengId)
	{
		this.xueshengId = xueshengId;
	}

	public String getNiandu()
	{
		return this.niandu;
	}

	public void setNiandu(String niandu)
	{
		this.niandu = niandu;
	}

	public Integer getJine()
	{
		return this.jine;
	}

	public void setJine(Integer jine)
	{
		this.jine = jine;
	}

	public String getShijian()
	{
		return this.shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

}