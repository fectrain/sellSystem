package com.homework.sellSystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.homework.sellSystem.entity.Person;
import com.homework.sellSystem.entity.Transaction;
import com.homework.sellSystem.service.ProductService;
import com.homework.sellSystem.service.TransactionService;
import com.homework.sellSystem.service.UserService;

@Controller
@RequestMapping("/api")
public class AjaxController {

	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	TransactionService transactionService;

	@RequestMapping("/login")
	@ResponseBody
	public void login(JsonObject user,ModelMap map,HttpSession httpSession, @RequestParam String userName, @RequestParam String password,HttpServletResponse response) throws IOException {
		Person p = userService.getPerson(userName);
		String _password = p.getPassword();
		JsonObject jsonObject = new JsonObject();
		if (_password.equals(password)) {
			jsonObject.addProperty("code", "200");
			jsonObject.addProperty("message", "登录成功");
			jsonObject.addProperty("result", true);
			
			// 放入user对象
			JSONObject json = new JSONObject();
			json.put("usertype", p.getUserType());
			json.put("username", p.getUserName());
			json.put("userId", p.getId());
			httpSession.setAttribute("user", json);
		} else {
			jsonObject.addProperty("result", false);
			jsonObject.addProperty("code", "-1");
			jsonObject.addProperty("message", "密码错误");
		}
		response.setContentType("application/json;charset=UTF-8");// 防止数据传递乱码
		response.getWriter().write(jsonObject.toString());
	}
	
	@RequestMapping("/delete")
	public void delete(ModelMap map, @RequestParam int id) {
		
		int flag = productService.delete(id);
		if(flag == 1) {
			map.addAttribute("code", 200);
			map.addAttribute("message", "删除成功");
			map.addAttribute("result", true);
		}else {
			map.addAttribute("code", -1);
			map.addAttribute("message", "删除失败");
			map.addAttribute("result", false);
		}
	}
	
	@RequestMapping("/buy")
	public void buy(HttpSession httpSession,ModelMap map, @RequestBody String data) {
		JSONObject user = (JSONObject) httpSession.getAttribute("user");
		int userId = user.getInt("userId");
		List<Transaction> trxList = new ArrayList<Transaction>();
		 List<com.alibaba.fastjson.JSONObject> buyList = JSON.parseArray(data, com.alibaba.fastjson.JSONObject.class);
		 
		for(com.alibaba.fastjson.JSONObject json :buyList) {
			Transaction trx = new Transaction();
			trx.setContentId(json.getIntValue("id"));
			trx.setPersonId(userId);
			trx.setPrice(json.getIntValue("price"));
			trx.setTime(new Date().getTime());
			trxList.add(trx);
		}
		boolean result = transactionService.add(trxList);
		if(result) {
			map.addAttribute("code", 200);
			map.addAttribute("message", "购买成功");
			map.addAttribute("result", true);
		} else {
			map.addAttribute("code", -1);
			map.addAttribute("message", "购买失败");
			map.addAttribute("result", false);
		}
	}
}
