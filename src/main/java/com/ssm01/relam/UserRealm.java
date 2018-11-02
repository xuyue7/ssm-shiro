/**
 * 
 */
/**
 * @author xy7
 *
 */
package com.ssm01.relam;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm01.ssm.entity.User;
import com.ssm01.ssm.service.UserService;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	public String getName() {
		return "UserRealm";
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 授权操作
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// System.out.println(token);
		String username = (String) token.getPrincipal();
		User user = userService.getUser(username);
		if (user == null) {
			return null;
		}
		String password = user.getPassword();

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
		return info;
	}

}