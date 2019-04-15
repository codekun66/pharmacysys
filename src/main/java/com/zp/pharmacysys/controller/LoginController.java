package com.zp.pharmacysys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zp.pharmacysys.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/notLogin", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> notLogin() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "您尚未登陆！");
		return map;
	}
	@RequestMapping(value = "/notRole", method = RequestMethod.GET)
	@ResponseBody
    public Map<String, Object> notRole() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "您没有权限！");
        return map;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> logout() {
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "成功注销！");
        return map;
    }
	
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String toLogin () {
    	 return "login";
    }
    
    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
 	public String toRegister () {
     	return "register";
     }
	 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
    public Map<String, Object> login(String username, String password ) throws Exception {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆   封装了用户名，密码的 token 作为参数传入
        subject.login(token);
        Session session =  subject.getSession();
        String role = userService.getRole(username);
        int userId = userService.getUserId(username);
        //根据权限，指定返回数据
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "success");
        map.put("returncode", 1);
        map.put("username", username);
        map.put("role", role);
        map.put("userId", userId);
        session.setAttribute("role", role);
    	session.setAttribute("userId", userId);
    	session.setAttribute("username", username);
        return map ;
    }
	
	   @RequestMapping(value = "/judge", method = RequestMethod.GET)
	    @ResponseBody
	    public Map<String, Object> judgeIdentity (HttpServletRequest request, HttpServletResponse response){
	    	Map<String, Object> map = new HashMap<>();
	    	Subject subject = SecurityUtils.getSubject();
	    	Session session =  subject.getSession();
	    	String role = (String) session.getAttribute("role");
	    	map.put("role", role);
	    	int userId = (int) session.getAttribute("userId");
	    	map.put("userId", userId);
	    	String	username = (String) session.getAttribute("username");
	    	map.put("username", username);
	    	return map;
	    }
	
		@RequestMapping(value = "/register/userAdd", method = RequestMethod.POST , consumes="application/json")
		@ResponseBody
		public Map<String,Object> addUser(@RequestBody JSONObject jsonParam ) {
			int count = userService.addUser(jsonParam);
			Map<String, Object> map = new HashMap<>();
			if(count > 0) {
				map.put("msg", "success");
				map.put("returnCode", 1);
				return map;
			}
			else {
				map.put("msg","error");
				map.put("returnCode", 0);
				return map;
			}
		}
		
		/*
		 * 获得所有角色列表接口
		 */
		@RequestMapping(value = "/role/info" , method = RequestMethod.GET)
		@ResponseBody
		public List<Map<String, Object>> getRoleList() throws Exception{
			return  userService.getRoleInfo();
		}
		
		
		/*
		 * 增加role信息列表接口
		 */
		@RequestMapping(value = "/role/add" , method = RequestMethod.POST )
		@ResponseBody
		public Map<String, Object> addRole(@RequestBody JSONObject jsonParam) throws Exception{
			int count = userService.addRole(jsonParam);
			Map<String, Object> map = new HashMap<>();
			if(count > 0) {
				map.put("msg", "success");
				map.put("returnCode", 1);
				return map;
			}
			else {
				map.put("msg","error");
				map.put("returnCode", 0);
				return map;
			}
		}
		 /*
		  * 根据Id查询role
		  */
		 @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
		 @ResponseBody
			public Map<String, Object> getRoleById(@PathVariable("id") int id) { // @PathVariable用于定义自定义或动态请求URI
			 Map<String, Object> map = userService.getRoleById(id);
			 return map;
			 
		 }
		 /*
		  * 更新role信息
		  */
		 @RequestMapping(value = "/role/update", method = RequestMethod.POST)
		 @ResponseBody
			public Map<String, Object> updateRole(@RequestBody JSONObject jsonParam) throws Exception { // @PathVariable用于定义自定义或动态请求URI
			 Map<String, Object> map = new HashMap<>();
			 int count = userService.updateRoleById(jsonParam);
			 if(count > 0) {
				  map.put("msg", "success");
				  map.put("returnCode", 1);
				}
			  else {
				  map.put("msg", "error");
				  map.put("returnCode",0);
				}
			  return map;  
		 }
		 
			/*
			 * 获得所有角色列表接口
			 */
			@RequestMapping(value = "/user/info" , method = RequestMethod.GET)
			@ResponseBody
			public List<Map<String, Object>> getUserList() throws Exception{
				return  userService.getUserInfo();
			}
			
			
			 /*
			  * 根据Id查询User信息
			  */
			 @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
			 @ResponseBody
				public Map<String, Object> getUserById(@PathVariable("id") int id) { // @PathVariable用于定义自定义或动态请求URI
				 Map<String, Object> map = userService.getUserById(id);
				 return map;
				 
			 }
			 
			 
			 /*
			  * 更新role信息
			  */
			 @RequestMapping(value = "/user/update", method = RequestMethod.POST)
			 @ResponseBody
				public Map<String, Object> updateUser(@RequestBody JSONObject jsonParam) throws Exception { // @PathVariable用于定义自定义或动态请求URI
				 Map<String, Object> map = new HashMap<>();
				 int count = userService.updateUserById(jsonParam);
				 if(count > 0) {
					  map.put("msg", "success");
					  map.put("returnCode", 1);
					}
				  else {
					  map.put("msg", "error");
					  map.put("returnCode",0);
					}
				  return map;  
			 }
}
