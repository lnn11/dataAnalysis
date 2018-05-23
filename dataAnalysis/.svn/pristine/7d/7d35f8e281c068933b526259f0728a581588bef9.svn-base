package com.zhb.dataAnalysis.common.shiro.authorized;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MyPermissionFilter extends PermissionsAuthorizationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {

		HttpServletRequest HttpRequest = WebUtils.toHttp(request);
		boolean isAjax = "XMLHttpRequest".equals(HttpRequest.getHeader("X-Requested-With"));

		Subject subject = getSubject(request, response);
		// If the subject isn't identified, redirect to login URL
		if (subject.getPrincipal() == null) {
			if(isAjax){
				WebUtils.issueRedirect(request, response, "/redirect");
			}else{
				saveRequestAndRedirectToLogin(request, response);
			}
		} else {
			if(isAjax){
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter out = response.getWriter();
				Map<String, String> map = new HashMap<String, String>(1);
				map.put("msg", "您没有获取该资源的访问权限！");
				String jsonStr = JSON.toJSONString(map);
				out.write(jsonStr);
			}else{
				// If subject is known but not authorized, redirect to the unauthorized URL if there is one
				// If no unauthorized URL is specified, just return an unauthorized HTTP status code
				String unauthorizedUrl = getUnauthorizedUrl();
				//SHIRO-142 - ensure that redirect _or_ error code occurs - both cannot happen due to response commit:
				if (StringUtils.hasText(unauthorizedUrl)) {
					WebUtils.issueRedirect(request, response, unauthorizedUrl);
				} else {
					WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		}
		return false;
	}
}
