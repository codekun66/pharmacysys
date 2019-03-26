package com.zp.pharmacysys.service;

import java.util.List;
import java.util.Map;

import com.zp.pharmacysys.bean.Provider;

/*
 * 供应商业务接口层
 * 
 * */

public interface ProviderService {

	/**
     * 查询所有供应商信息列表
     *
     * @return
     */
	List<Provider> getProviderInfo() throws Exception;
	
	/**
     * 添加供应商信息
     *
     */
	int addProvider(Provider provider) throws Exception;
	
	 /**
	  * 更新供应商信息
	  *
	  * @return
	  */
	int updateProviderById(Map<String, Object> map) throws Exception; 
	
	/**
	 * 删除供应商信息
	 *
	 * @return
	 */
	int deleteProviderById(int id) throws Exception;
}
