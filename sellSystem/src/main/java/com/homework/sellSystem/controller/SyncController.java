package com.homework.sellSystem.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homework.sellSystem.dto.ProductDTO;
import com.homework.sellSystem.entity.Content;
import com.homework.sellSystem.entity.Transaction;
import com.homework.sellSystem.service.ProductService;
import com.homework.sellSystem.service.TransactionService;
import com.homework.sellSystem.service.UserService;
import com.mysql.jdbc.Blob;

@Controller
public class SyncController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping("/")
	public String index(HttpSession httpSession, ModelMap map,HttpServletResponse response) throws IOException{
		JSONObject user = (JSONObject) httpSession.getAttribute("user");
		int userType = -1;
		boolean isSell = false;
		boolean isBuy = false;
		if(user!=null) {
			userType = user.getInt("usertype");
		}
		List<Content> list = productService.getContentList();
		List<Object> productList = new ArrayList<Object>();
		for (Content co :list) {
			JSONObject product = new JSONObject();
			product.put("id", co.getId());
			product.put("title", co.getTitle());
			product.put("image", "123");
			product.put("price", co.getPrice());
			if (userType == 0) {
				isBuy = transactionService.isBuy(user.getInt("userId"),co.getId());
				product.put("isBuy", isBuy);
			}else if (userType == 1) {
				isSell = transactionService.isSell( co.getId());
				product.put("isSell", isSell);
			}
			productList.add(product);
		}
		map.addAttribute("productList", productList);
		return "index";
	}
	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "login";
	}
	
	@RequestMapping("/show")
	public String show(HttpSession session,@RequestParam int id, ModelMap map){
		
		JSONObject user = (JSONObject) session.getAttribute("user");
		int userType = -1;
		boolean isSell = false;
		boolean isBuy = false;
		if(user!=null) {
			userType = user.getInt("usertype");
		}
		Content cont = productService.getProduct(id);
		
//		ProductDTO productDTO = new ProductDTO();
		JSONObject product = new JSONObject();
		product.put("id", cont.getId());
		product.put("title", cont.getTitle());
		product.put("image", "123");
		product.put("price", cont.getPrice());
		if (userType == 0) {
			isBuy = transactionService.isBuy(user.getInt("userId"),cont.getId());
			product.put("isBuy", isBuy);
		}else if (userType == 1) {
			isSell = transactionService.isSell( cont.getId());
			product.put("sellNum", 10);
			product.put("isSell", isSell);
		}
		product.put("buyNum", 10);
//		int price = transactionService.
		product.put("detail", "details");
		product.put("buyPrice", 666);
		product.put("summary", "summary");
		map.addAttribute("product",product);
		return "show";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,@RequestParam int id, ModelMap map){
		Content cont = productService.getProduct(id);
		
		ProductDTO productDTO = new ProductDTO();
		
		JSONObject product = new JSONObject();
		product.put("id", cont.getId());
		product.put("title", cont.getTitle());
		product.put("image", "123");
		product.put("price", cont.getPrice());
		product.put("detail", "details");
		product.put("summary", "summary");
		product.put("buyPrice", 0);
		product.put("buyNum", 10);
		product.put("sellNum", 10);
		
		product.put("isBuy", true);
		product.put("isSell", true);
		
		map.addAttribute("product",product);
		return "edit";
	}
	
	@RequestMapping("/editSubmit")
	public String editSubmit(ModelMap map,HttpServletRequest request,@RequestParam int id,@RequestParam String title,@RequestParam String image,@RequestParam int price,@RequestParam String detail){
		Content product = new Content();
		product.set_abstract(detail);
		product.setPrice(Long.valueOf(price));
//		product.setText(new Blob(new byte[]);
		product.setTitle(title);
		
		productService.edit(product, id);
		
		Content _product = productService.getProduct(id);
		map.addAttribute("product", _product);
		return "editSubmit";
	}
	
	@RequestMapping("/public")
	public String _public(HttpServletRequest request){
		return "public";
	}
	
	@RequestMapping("/publicSubmit")
	public String publicSubmit(ModelMap map,@RequestParam String summary,@RequestParam String title,@RequestParam String image,@RequestParam int price,@RequestParam String detail){
		
		Content product = new Content();
		product.set_abstract(detail);
		product.setPrice(Long.valueOf(price));
//		product.setText(new Blob(new byte[]);
		product.setTitle(title);
		
		int flag = productService.add(product);
		int id = product.getId();
		
		Content _product = productService.getProduct(id);
		map.addAttribute("product", _product);
		return "publicSubmit";
	}
	
	@RequestMapping("/account")
	public String account(HttpSession httpSession,ModelMap map){
		JSONObject user = (JSONObject) httpSession.getAttribute("user");
		int userId = -1;
		if(user != null) {
			userId = user.getInt("userId");
		}
		List<Transaction> list = transactionService.getTrx(userId);
		int totle = 0;
		List<JSONObject> result = new ArrayList<JSONObject>();
		for(Transaction t :list) {
			JSONObject trx = new JSONObject();
			trx.put("id", t.getContentId());
			trx.put("title", "title");
			trx.put("image", "123");
			trx.put("buyPrice", t.getPrice());
			trx.put("buyNum", "123");
			trx.put("buyTime", t.getTime());
			trx.put("totle", 1234);
			result.add(trx);
		}
		map.addAttribute("buyList", result);
		return "account";
	}
	
	@RequestMapping("/settleAccount")
	public String settleAccount(ModelMap map){
		
		return "settleAccount";
	}
}
