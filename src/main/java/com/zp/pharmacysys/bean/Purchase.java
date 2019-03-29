package com.zp.pharmacysys.bean;

import java.io.Serializable;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mysql.fabric.xmlrpc.base.Data;
import com.zp.pharmacysys.util.DateUtil;

public class Purchase implements Serializable{

	//序列化
	private static final long seriaVersionUID = 1L;
	//id
	private int id;
	//商品id
	private int goodsId;
	//供应商id
	private int providerId;
	//订单号
	private String ordercode;
	//数量
	private String count;
	//单价
	private String unitprice;
	//总价
	private String totalprice;
	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonSerialize(using = DateUtil.class)
	private Data createTime;
	//修改时间
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonSerialize(using = DateUtil.class)
	private Data modifieldTime;
	//跟新人id
	private int userId;
	//备注
	private String remark;
	//状态 
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public Data getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Data createTime) {
		this.createTime = createTime;
	}
	public Data getModifieldTime() {
		return modifieldTime;
	}
	public void setModifieldTime(Data modifieldTime) {
		this.modifieldTime = modifieldTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", goodsId=" + goodsId + ", providerId=" + providerId + ", ordercode=" + ordercode
				+ ", count=" + count + ", unitprice=" + unitprice + ", totalprice=" + totalprice + ", createTime="
				+ createTime + ", modifieldTime=" + modifieldTime + ", userId=" + userId + ", remark=" + remark
				+ ", state=" + state + "]";
	}

	
}
