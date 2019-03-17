package com.zp.pharmacysys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.pharmacysys.service.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;
	
	@RequestMapping("/purchase/info")
	@ResponseBody
	public List<Map<String,Object>> getPurchaseList() throws Exception{
		return purchaseService.getPurchaseInfo();
	}
	
	@RequestMapping(value = "/purchase/all", method = RequestMethod.GET)
	public String getpurchaseInfo(ModelMap modelMap)throws Exception{
		modelMap.addAttribute("purchase" , purchaseService.getPurchaseInfo());
		return "purchase";
	}

}
