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

import com.alibaba.fastjson.JSONObject;
import com.zp.pharmacysys.bean.Provider;
import com.zp.pharmacysys.bean.Purchase;
import com.zp.pharmacysys.service.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;
	/*
	 * 获得所有采购订单信息接口
	 * @return
	 * */
	@RequestMapping(value="/purchase/info" , method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getPurchaseList() throws Exception{
		List<Map<String, Object>> list = purchaseService.getPurchaseInfo();
		return list;
	}
	
	@RequestMapping(value = "/purchase/all", method = RequestMethod.GET)
	public String getpurchaseInfo(ModelMap modelMap)throws Exception{
		modelMap.addAttribute("purchase" , purchaseService.getPurchaseInfo());
		return "purchase";
	}
	/*
	 * 获得未审核采购订单信息接口
	 * @return
	 * */
	@RequestMapping("/purchase/uncheck")
	@ResponseBody
	public List<Map<String, Object>> getUnCheckPurchaseList() throws Exception{
		return purchaseService.getPurchaseNoState();
	}
	/*
	 * 审核通过采购订单信息接口
	 * @return
	 * */
	 @RequestMapping(value = "/checkpurchase/{id}", method = RequestMethod.GET)
	 @ResponseBody
	    public Map<String, Object> checkPurchase(@PathVariable("id") int id , ModelMap modelMap) throws Exception {  //@PathVariable用于定义自定义或动态请求URI
		  int count = purchaseService.checkPurchaseById(id);
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
	 
		/*
		 * 增加采购订单信息接口
		 */
		@RequestMapping(value = "/purchase/add" , method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> addPurchase(@RequestBody JSONObject jsonParam) throws Exception{
			System.out.println(jsonParam.toJSONString());
			int count = purchaseService.addPurchase(jsonParam);
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
		 * 审核不通过采购订单接口
		 */
		 @RequestMapping(value = "/notcheckpurchase/{id}", method = RequestMethod.GET)
		 @ResponseBody
		    public Map<String, Object> notCheckPurchase(@PathVariable("id") int id , ModelMap modelMap) throws Exception {  //@PathVariable用于定义自定义或动态请求URI
			  int count = purchaseService.notCheckPurchaseById(id);
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
