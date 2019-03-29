package com.zp.pharmacysys.service;

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
}
