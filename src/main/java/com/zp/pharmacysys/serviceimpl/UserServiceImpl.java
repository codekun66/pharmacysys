package com.zp.pharmacysys.serviceimpl;

import java.util.List;
import java.util.Map;

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

	@Override
	public String getUsernameById(int id) {
		// TODO Auto-generated method stub
		return userMapper.queryUsernameById(id);
	}

	@Override
	public int addUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(map);
	}

	@Override
	public List<Map<String, Object>> getRoleInfo() throws Exception {
		// TODO Auto-generated method stub
		return userMapper.queryRoleInfo();
	}

	@Override
	public int addRole(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		String role = (String) map.get("remark");
		map.put("role", role);
		return userMapper.insertRole(map);
	}

	@Override
	public int updateRoleById(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		String role = (String) map.get("remark");
		map.put("role", role);
		return userMapper.updateRoleById(map);
	}

	@Override
	public Map<String, Object> getRoleById(int id) {
		// TODO Auto-generated method stub
		return userMapper.queryRoleInfoById(id);
	}

	@Override
	public List<Map<String, Object>> getUserInfo() throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = userMapper.queryUserInfo();
		for (Map<String, Object> map : list) {
			int roleId = (int) map.get("role_id");
			String remark = userMapper.queryroleById(roleId);
			map.put("role", remark);
		}
		return list;
	}

	@Override
	public Map<String, Object> getUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.queryUserInfoById(id);
	}

	@Override
	public int updateUserById(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updateUserById(map);
	}

	
	
}
