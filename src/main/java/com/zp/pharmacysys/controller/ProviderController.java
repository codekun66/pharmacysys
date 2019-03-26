package com.zp.pharmacysys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.pharmacysys.bean.Provider;
import com.zp.pharmacysys.service.ProviderService;

@Controller
public class ProviderController {

	@Autowired 
	ProviderService providerService;
	/*
	 * 获得所有课程列表接口
	 */
	@RequestMapping(value = "/provider/info" , method = RequestMethod.GET)
	@ResponseBody
	public List<Provider> getProviderList() throws Exception{
		List<Provider> list = providerService.getProviderInfo();
		return  list;
	}
	/*
	 * 增加课程列表接口
	 */
	@RequestMapping(value = "/provider/add" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addProvider(@RequestBody Provider provider) throws Exception{
		System.out.println(provider.toString());
		int count = providerService.addProvider(provider);
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
	 * 增加课程列表接口
	 */
	 @RequestMapping(value = "/deleteProvider/{id}", method = RequestMethod.GET)
	 @ResponseBody
	    public Map<String, Object> deleteProvider(@PathVariable("id") int id , ModelMap modelMap) throws Exception {  //@PathVariable用于定义自定义或动态请求URI
		  int count =providerService.deleteProviderById(id);
		  Map<String, Object> map  = new HashMap<>();
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
