package com.zp.pharmacysys.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	/**
	 * 获取密码
	 * 
	 * @return
	 */
	String getPassword(String username);
	
	/**
     * 获得角色权限
     * @param username 用户名
     * @return user/admin
     */
	String getRole(String username);
	
	/**
     * 获得用户id
     * @param username 用户名
     * @return user/admin
     */
    int getUserId(String username);
    
    /**
     * 根据用户id获取用户姓名
     * @param id 用户名
     * @return username
     */
    String getUsernameById(int id);
    
    /**
	 * 添加user
	 *
	 * @return
	 */
	int addUser(Map<String, Object> map);
	
	/**
     * 查询所有角色信息
     *
     * @return
     */
	List<Map<String, Object>> getRoleInfo() throws Exception;
}
