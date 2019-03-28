package com.zp.pharmacysys.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zp.pharmacysys.util.DateUtil;

public class Goods implements Serializable{
	//序列化
	private static final long seriaVersionUID = 1L;
	//商品id
	private int id;
	//商品名称
	private String name;
	//商品编号
	private String code;
	//商品类型
	private String type;
	//预计进价
	private String purchaseprice;
	//预计售价
	private String sellprice;
	//商品简介
	private String summary;
	//创建者id
	private int userId;
	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonSerialize(using = DateUtil.class)
	private Date createTime;
	// 更新时间
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonSerialize(using = DateUtil.class)
	private Date modifieldTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPurchaseprice() {
		return purchaseprice;
	}
	public void setPurchaseprice(String purchaseprice) {
		this.purchaseprice = purchaseprice;
	}
	public String getSellprice() {
		return sellprice;
	}
	public void setSellprice(String sellprice) {
		this.sellprice = sellprice;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifieldTime() {
		return modifieldTime;
	}
	public void setModifieldTime(Date modifieldTime) {
		this.modifieldTime = modifieldTime;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", code=" + code + ", type=" + type + ", purchaseprice="
				+ purchaseprice + ", sellprice=" + sellprice + ", summary=" + summary + ", userId=" + userId
				+ ", createTime=" + createTime + ", modifieldTime=" + modifieldTime + "]";
	}

	
}
