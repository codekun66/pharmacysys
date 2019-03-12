package com.zp.pharmacysys.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pharmacysys.mapper.UserMapper;
import com.zp.pharmacysys.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	/**
	 * 根据用户名查询用户密码
	 * */
	@Override
	public String getPassword(String username) {
		return userMapper.queryPasswordByUsername(username);
	}

	@Override
	public String getRole(String username) {
		// TODO Auto-generated method stub
		return userMapper.queryRoleByUsername(username);
	}

	@Override
	public int getUserId(String username) {
		// TODO Auto-generated method stub
		return userMapper.queryUserId(username);
	}

}
