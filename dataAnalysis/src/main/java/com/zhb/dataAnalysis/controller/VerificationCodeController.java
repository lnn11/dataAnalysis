package com.zhb.dataAnalysis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhb.dataAnalysis.common.utils.VerificationCodeUtil;

@RequestMapping("verificationCode")
@Controller
public class VerificationCodeController {

	@RequestMapping("getVerificationCode")
	public String getVerificationCode(HttpServletRequest request,HttpServletResponse response){
		String code = VerificationCodeUtil.setPeg(request,response);
		SecurityUtils.getSubject().getSession().setAttribute("code", code);
		return "aiPinXuan/image";
	}
}
