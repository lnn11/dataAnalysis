package com.zhb.dataAnalysis.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhb.dataAnalysis.common.shiro.api.TUserService;
import com.zhb.dataAnalysis.common.shiro.model.TUser;

@RequestMapping("/passwordManager")
@Controller
public class PasswordManagerController {

	@Resource(name="tUserServiceImpl")
	private TUserService tUserService;
	
	/**
	 * 跳转到个人信息页面
	 */
	@RequestMapping("toUserInfo")
	public String toUserInfo(HttpServletRequest request,String username) {
		TUser tUser = tUserService.getUserByName(username);
		if(tUser!=null){
			request.setAttribute("tUser", tUser);
		}
		return "aiPinXuan/user/userInfo";
	}
	/**
	 * 跳转到修改页面
	 */
	@RequestMapping("toUpdatePassword")
	public String toUpdatePassword(HttpServletRequest request,String username) {
		TUser tUser = tUserService.getUserByName(username);
		if(tUser!=null){
			request.setAttribute("tUser", tUser);
		}
		return "aiPinXuan/user/updatePassword";
	}
	/**
	 * 忘记密码跳转到修改密码页面
	 */
	@RequestMapping("toUpdatePasswordForget")
	public String toUpdatePasswordForget(HttpServletRequest request,String username) {
//		TUser tUser = tUserService.getUserByName(username);
//		if(tUser!=null){
//			request.setAttribute("tUser", tUser);
//		}
		request.setAttribute("username", username);
		return "aiPinXuan/forgetUpdatePassword";
	}
	/**
	 * 用户修改密码
	 * @param tUser
	 * @return
	 */
	@RequestMapping("updateUser")
	@ResponseBody
	public Boolean updateUser(TUser tUser) {
		tUser.setPassword(new Sha256Hash(tUser.getPassword(), tUser.getUserName()).toBase64());
		return tUserService.updateUserPassword(tUser);
	}
	/**
	 * 跳转到左侧用户信息
	 */
	@RequestMapping("toUserInfoLeft")
	public String toUserInfoLeft() {
		return "aiPinXuan/left/userInfo";
	}
	/**
	 * 验证旧密码是否正确
	 */
	@RequestMapping("checkPassword")
	@ResponseBody
	public Boolean checkPassword(String id,String password,String username) {
		password = new Sha256Hash(password,username).toBase64();
		return tUserService.checkPassword(id,password);
	}
	/**
	 * 验证是否有此用户名
	 */
	@RequestMapping("checkUserName")
	@ResponseBody
	public TUser checkUserName(String username) {
		
		return tUserService.getUserByName(username);
	}
}
