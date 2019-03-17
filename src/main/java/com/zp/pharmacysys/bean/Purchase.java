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
	//联系人
	private String linkman;
	//电话
	private String moblile;
	//地址
	private String address;
	//描述
	private String descs;
	//状态
	private String state;
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
	public String getMoblile() {
		return moblile;
	}
	public void setMoblile(String moblile) {
		this.moblile = moblile;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescs() {
		return descs;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
