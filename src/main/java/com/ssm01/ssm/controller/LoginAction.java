package com.ssm01.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAction {

	private static Logger log = Logger.getLogger(LoginAction.class);
	
	@RequiresPermissions("user:delete")
	@RequestMapping(value="/delete")
	@ResponseBody
	public String delete() {
		log.info("这是删除方法");
		return "delete";
	}
	
	@RequiresPermissions("user:delete")
	@RequestMapping(value="/add")
	@ResponseBody

	public String add() {
		log.info("这是新增方法方法");
		return "add";
	}
	
	@RequiresPermissions("user:edit")
	@RequestMapping(value="/edit")
	@ResponseBody
	@RequiresRoles("admin")
	public String edit() {
		log.info("这是编辑方法方法");
		return "edit";
	}
	
	@RequestMapping(value="/index")
	@RequiresPermissions("user:edit")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping(value="/loginCheck")
	public String loginloginCheck(Model model,HttpServletRequest req) throws Exception {
		String excetionClassName = (String) req.getAttribute("shiroLoginFailure");
		if(excetionClassName != null) {
			if(UnknownAccountException.class.getName().equals(excetionClassName)) {
				model.addAttribute("errormsg","账号错误");
			}else if (IncorrectCredentialsException.class.getName().equals(excetionClassName)) {
				model.addAttribute("errormsg","密码错误");
			}else {
				model.addAttribute("errormsg","其它错误类型");
			}
		}
		return "login";
	}
	
	@RequestMapping("shiroException")
	public String shiroException(){
		return "shiroException";
	}
}
