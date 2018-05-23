package com.zhb.dataAnalysis.common.shiro.authorized;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyUserFilter extends UserFilter {
	
	/*@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		HttpServletRequest HttpRequest = WebUtils.toHttp(request);
		System.out.println(HttpRequest.getScheme()+"://"+HttpRequest.getServerName()+":"+HttpRequest.getServerPort()+HttpRequest.getContextPath()+HttpRequest.getServletPath());
		
        if (isLoginRequest(request, response)) {
            return true;
        } else {
            Subject subject = getSubject(request, response);
            // If principal is not null, then the user is known and should be allowed access.
            return subject.getPrincipal() != null;
        }
    }*/

	@Override
	protected boolean onAccessDenied(ServletRequest request,ServletResponse response) throws Exception {

		HttpServletRequest HttpRequest = WebUtils.toHttp(request);

		boolean isAjax = "XMLHttpRequest".equals(HttpRequest.getHeader("X-Requested-With"));
		Subject subject = getSubject(request, response);

		if (subject.getPrincipal() == null && isAjax) {// 用户为空
			/*response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Map<String, String> map = new HashMap<String, String>(1);
			map.put("msg", "您尚未登录或登录时间过长,请重新登录!");
			String jsonStr = JSON.toJSONString(map);
			out.write(jsonStr);*/
			saveRequest(request);
		    WebUtils.issueRedirect(request, response, "/redirect");
			return false;
		}
		saveRequestAndRedirectToLogin(request, response);
		return false;
	}

}
