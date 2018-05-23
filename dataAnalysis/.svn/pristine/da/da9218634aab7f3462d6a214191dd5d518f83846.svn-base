package com.zhb.dataAnalysis.common.shiro.authorized;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.subject.WebSubjectContext;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyCookieRemember extends CookieRememberMeManager {
	private static transient final Logger logger = LoggerFactory
			.getLogger(CookieRememberMeManager.class);

	@Value("${cookieMaxAge}")
	private Integer maxAge;

	@Override
	public void rememberSerializedIdentity(Subject subject, byte[] serialized) {

		if (!WebUtils.isHttp(subject)) {
			String msg = "Subject argument is not an HTTP-aware instance.  This is required to obtain a servlet "
					+ "request and response in order to set the rememberMe cookie. Returning immediately and "
					+ "ignoring rememberMe operation.";
			logger.debug(msg);
			return;
		}
		HttpServletRequest request = WebUtils.getHttpRequest(subject);
		HttpServletResponse response = WebUtils.getHttpResponse(subject);
		// base 64 encode it and store as a cookie:
		String base64 = Base64.encodeToString(serialized);
		Cookie template = getCookie(); // the class attribute is really a
										// template for the outgoing cookies
		template.setMaxAge(maxAge);
		Cookie cookie = new SimpleCookie(template);
		cookie.setValue(base64);
		cookie.saveTo(request, response);
	}

	@Override
	public byte[] getRememberedSerializedIdentity(SubjectContext subjectContext) {
		WebSubjectContext wsc = (WebSubjectContext) subjectContext;
		HttpServletRequest request = WebUtils.getHttpRequest(wsc);
		
		if(subjectContext.getPrincipals() == null){
			javax.servlet.http.Cookie cookie = getCookie(request,"token");
			if(cookie != null && StringUtils.isNotBlank(cookie.getValue())){				
				getCookie(request, "token").setValue(null);
			}
		}		

		return super.getRememberedSerializedIdentity(subjectContext);
	}

	private javax.servlet.http.Cookie getCookie(HttpServletRequest request,String cookieName) {
		javax.servlet.http.Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					return cookie;
				}
			}
		}
		return null;
	}
}
