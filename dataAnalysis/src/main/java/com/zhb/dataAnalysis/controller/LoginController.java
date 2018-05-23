package com.zhb.dataAnalysis.controller;

import com.zhb.dataAnalysis.common.repository.redis.RDict;
import com.zhb.dataAnalysis.common.shiro.api.TAuthorizedService;
import com.zhb.dataAnalysis.common.utils.Base64Util;
import com.zhb.dataAnalysis.validator.LoginCommand;
import com.zhb.dataAnalysis.validator.LoginValidator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Controller
public class LoginController {

	@Value("${cookieMaxAge}")
	private Integer maxAge;


	@Resource(name = "rDict")
	private RDict rDict;

	@Resource(name = "tAuthorizedService")
	private TAuthorizedService tAuthorizedService;

	private LoginValidator loginValidator = new LoginValidator();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model, @ModelAttribute LoginCommand loginCommand, BindingResult errors) {
		return "aiPinXuan/login";
	}
	public void printError(BindingResult bindingResult){
		List<ObjectError> errors = bindingResult.getAllErrors();
		if(!org.springframework.util.CollectionUtils.isEmpty(errors)){
			for(ObjectError oe :errors){
				System.out.println(oe);
			}
		}
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute LoginCommand loginCommand, BindingResult errors,HttpServletRequest request,HttpServletResponse response) {
		loginValidator.validate(loginCommand, errors);
		if (errors.hasErrors()) {
			System.out.println("validate-----------------------");
			printError(errors);
			return showLoginForm(model, loginCommand, errors);
		}
		//获取前台加密数据 重新加密
		Sha256Hash hash = new Sha256Hash(new String(Base64Util.decode(loginCommand.getPassword())),loginCommand.getUsername());
		String sha1 = hash.toBase64();
		loginCommand.setPassword(sha1);

		Subject sub = SecurityUtils.getSubject();
		Session se = sub.getSession();
		Object codeObj = se.getAttribute("code");
		if(codeObj == null || "".equals(codeObj)){
			errors.reject("登录失败","验证码过期，请刷新重试");
//			System.out.println("验证码过期----------");
			printError(errors);
		}else{
			String code = codeObj.toString().toLowerCase();
			if (!code.equals(loginCommand.getValidatorCode().toLowerCase())) {
				errors.reject("登录失败", "验证码输入不正确");
//				System.out.println("验证码错误----------");
				printError(errors);
			}
		}

		if (errors.hasErrors()) {
			return showLoginForm(model, loginCommand, errors);
		}

		UsernamePasswordToken token = new UsernamePasswordToken(loginCommand.getUsername(), loginCommand.getPassword());
		try {
			token.setRememberMe(true);
			sub.login(token);
			Cookie cookie = new SimpleCookie("username");
			cookie.setHttpOnly(false);
		    cookie.setValue(token.getPrincipal().toString());
		    cookie.setMaxAge(maxAge);
		    cookie.saveTo(request, response);
			//登录成功清除code验证码
//			rDict.clearCache(loginCommand.getValidatorCode().toLowerCase());
		} catch (AuthenticationException e) {
			e.printStackTrace();
			errors.reject("登录失败", "用户名或密码不正确");
//			System.out.println("用户名或密码不正确----------");
			printError(errors);
		}
		if (errors.hasErrors()) {
			return showLoginForm(model, loginCommand, errors);
		} else {
			String successUrl = null;
			SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);
	        if (savedRequest != null && savedRequest.getMethod().equalsIgnoreCase(AccessControlFilter.GET_METHOD)) {
	            successUrl = savedRequest.getRequestUrl().replaceFirst(request.getContextPath(),"");
	            
	        }
	        if(successUrl == null || successUrl.indexOf("/home") == -1){
	        	successUrl = "/home";
	        }
//			System.out.println("successUrl=="+successUrl);
			return "redirect:"+successUrl;
		}		
	}

	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @return
	 *
	 * 清空session  重定向到login
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		Subject sub = SecurityUtils.getSubject();
		sub.logout();
		return "redirect:" +"/login";
	}

	@RequestMapping("/home")
	public String home() {
		return "aiPinXuan/index";
	}
	
	@RequestMapping(value = "/redirect",method = {RequestMethod.GET,RequestMethod.POST})
	public String redirect(){
		System.out.println("RequestMethod==========redirect");
		return "aiPinXuan/redirect";
	}

	@SuppressWarnings({ "unused" })
	private void printSessionInfo() {
		Subject subject = SecurityUtils.getSubject();
		Session se = subject.getSession();
		Collection<Object> c = se.getAttributeKeys();
		System.out.println("开始打印shiro中的session key value");
		if (!c.isEmpty()) {
			Iterator<Object> iterator = c.iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				System.out.println("session中的key: " + key + "\t 值："
						+ se.getAttribute(key));
			}
		}
		System.out.println("结束打印shiro中的session key value");
	}

	public static void main(String[] args) {
		String str = "admin";
		String salt = "admin";
		Sha256Hash hash = new Sha256Hash(str,salt);
		String sha1 = hash.toBase64();
		System.out.println(sha1);
		
		Sha256Hash hash2 = Sha256Hash.fromBase64String(sha1);

		System.out.println(hash2.toString());
		//System.out.println();



		/*DefaultHashService hashService = new DefaultHashService();
		hashService.setGeneratePublicSalt(true);
		HashRequest request = new HashRequest.Builder().setAlgorithmName("MD5")
				.setSource(ByteSource.Util.bytes("uuu"))
				.setSalt(ByteSource.Util.bytes("uuu")).setIterations(3).build();
		String hex = hashService.computeHash(request).toHex();
		System.out.println(hex);*/
	}




}
