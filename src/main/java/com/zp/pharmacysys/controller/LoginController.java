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

import com.zp.pharmacysys.config.WebSecurityConfig;
import com.zp.pharmacysys.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/index")
	public String loginInfo() {
		
		return "index";
	}
	
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String toLogin () {
    	return "login";
    }
	
//	@PostMapping("/loginPost")
//    public String loginPost(String account,
//            String password, HttpSession session) {
//        Map<String, Object> map = new HashMap<>();
//        if (!"123456".equals(password)) {
//            map.put("success", false);
//            map.put("message", "密码错误");
//            return "err";
//        }
//        // 设置session
//        session.setAttribute(WebSecurityConfig.SESSION_KEY, account);
//        map.put("success", true);
//        map.put("message", "登录成功");
//        return "index";
//    }
	 
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
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET) 
//    @ResponseBody
//    public Map<String, Object> logout() {
//    	Map<String, Object> map = new HashMap<String, Object>();
//		map.put("msg", "成功注销！");
//        return map;
//    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
