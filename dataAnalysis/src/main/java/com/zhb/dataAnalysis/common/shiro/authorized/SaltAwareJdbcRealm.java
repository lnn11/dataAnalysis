package com.zhb.dataAnalysis.common.shiro.authorized;

import com.zhb.dataAnalysis.common.shiro.api.TAuthorizedService;
import com.zhb.dataAnalysis.common.shiro.database.TAuthorizedDao;
import com.zhb.dataAnalysis.common.shiro.model.TRole;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

@Component("saltAwareJdbcRealm")
public class SaltAwareJdbcRealm extends JdbcRealm {

	@Resource(name = "tAuthorizedDao")
	private TAuthorizedDao tAuthorizedDao;

	@Resource(name = "tAuthorizedService")
	private TAuthorizedService tAuthorizedService;


	public SaltAwareJdbcRealm() {
		System.out.println("======================实例化了SaltAwareJdbcRealm======================");
		setName("saltAwareJdbcRealm");
		setPermissionsLookupEnabled(true);
		HashedCredentialsMatcher hcm = new HashedCredentialsMatcher("SHA-256");
		hcm.setStoredCredentialsHexEncoded(false);
		//不加密验证  手动加密
//		setCredentialsMatcher(hcm);
//		CredentialsMatcher();
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//		System.out.println("doGetAuthenticationInfo begin 登录开始");
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String userName = upToken.getUsername();

		if (userName == null) {
			throw new AccountException("Null usernames are not allowed by this realm.");
		}

		List<Map<String,String>> list = tAuthorizedDao.findUser(userName);

		if (list != null && list.size() > 0) {
			Map<String,String> map = list.get(0);

			if (StringUtils.isBlank(map.get("PASSWORD"))) {
                throw new UnknownAccountException("No account found for user [" + map.get("USERNAME") + "]");
            }
			SimpleAuthenticationInfo saInfo =  new SimpleAuthenticationInfo(map.get("ID"),map.get("PASSWORD"),getName());
			saInfo.setCredentialsSalt(ByteSource.Util.bytes(userName));
//			System.out.println("登录ok");
			return saInfo;
		} else {
			return null;
		}
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
//		System.out.println("验权开始");
        String userId = (String) getAvailablePrincipal(principals);
        List<TRole> roles = tAuthorizedService.getRoleNamesForUser(userId);//先使用redis读取

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(roles != null && roles.size() > 0){
        	for (TRole tRole : roles) {
        		info.addRole(tRole.getRoleName());
			}
        }

        if (permissionsLookupEnabled) {
        	List<String> permissions = tAuthorizedService.getPermissions(userId, roles);//先使用redis读取
            if(permissions != null){
            	info.addStringPermissions(permissions);
            }
        }

        return info;
	}

}
