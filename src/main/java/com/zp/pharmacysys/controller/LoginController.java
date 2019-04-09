package com.zp.pharmacysys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zp.pharmacysys.config.WebSecurityConfig;
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
	 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
    public Map<String, Object> login(String username, String password ) throws Exception {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆   封装了用户名，密码的 token 作为参数传入
        subject.login(token);
        //根据权限，指定返回数据
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "success");
        map.put("returncode", 1);
        map.put("username", username);
        return map ;
    }
	
}
