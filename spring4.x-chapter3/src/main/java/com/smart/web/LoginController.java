package com.smart.web;

import com.smart.domain.User;
import com.smart.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@EnableAutoConfiguration
@RequestMapping("/login")
public class LoginController{
	private UserService userService;
    
	@RequestMapping(value = {"/","/index.html"}) //可以配置多个mapping路径
	public ModelAndView loginPage(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
		boolean isValidUser =  userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login", "error", "用户名或密码错误。");
		} else {
			User user = userService.findUserByUserName(loginCommand
					.getUserName());
			user.setLastIp(request.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
