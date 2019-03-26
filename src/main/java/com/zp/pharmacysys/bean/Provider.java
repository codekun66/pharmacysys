package com.zp.pharmacysys.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zp.pharmacysys.util.DateUtil;

public class Provider implements Serializable {

	    //序列化
		private static final long seriaVersionUID = 1L;
		//供应商id
		private int id;
		//供应商名称
		private String name;
		//供应商联系人
		private String linkman;
		//供应商电话
		private String mobile;
		//供应商地址
		private String addres;
		//供应商简介
		private String summary;
		//状态
		private String state;
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
		public String getLinkman() {
			return linkman;
		}
		public void setLinkman(String linkman) {
			this.linkman = linkman;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getAddres() {
			return addres;
		}
		public void setAddres(String addres) {
			this.addres = addres;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
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
			return "Provider [id=" + id + ", name=" + name + ", linkman=" + linkman + ", mobile=" + mobile + ", addres="
					+ addres + ", summary=" + summary + ", state=" + state + ", userId=" + userId + ", createTime="
					+ createTime + ", modifieldTime=" + modifieldTime + "]";
		}
		
}
