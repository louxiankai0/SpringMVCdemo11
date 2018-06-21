package com.lxk.springmvc.controller;

import java.util.Map;

import javax.print.attribute.standard.MediaPrintableArea;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
//将对应key值得对象设置到httpsession中
@SessionAttributes("user")
public class HomeController {
	
	@RequestMapping(value = "/")
	public String main(Map<String,Object>map){
		if(map.get("user")==null){
			return "redirect:/login";
		}
		return "main";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login (String userName , String password,Map<String, Object>map){
		
		if("admin".equals(userName)&&"123".equals(password)){
			//在servlet开发中，设置session: request,getSession().setAttribute("user",userName);
			//在springmvc中，设置session需要在类上面加上SessionAttributes
			map.put("user", userName);
			return"main";
		}
		map.put("msg", "错误");
		return "login";
	}
	
	
	@RequestMapping("/logout")
	public String logout (Map<String,Object>map, SessionStatus status){
		//从session中删除用户信息
		map.remove("user");
		//表示更新session
		status.setComplete();
		//重定向到登录页面
		return "redirect:/login";
	}
}
