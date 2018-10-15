package com.example.demo4.shiro;

import com.example.demo4.entity.User;
import com.example.demo4.repository.UserRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserRepository userRepository;

    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        Set<String> roles=new HashSet<>();
        roles.add("user");
        if (user.getName().equals("admin")) {
            roles.add("admin");
        }
        if (user.getName().equals("dev")) {
            roles.add("dev");
        }
        if (user.getName().equals("test")) {
            roles.add("test");
        }
        simpleAuthorizationInfo.setRoles(roles);
        Set<String> permissions=new HashSet<>();
        permissions.add("1");
        if (user.getName().equals("dev")||user.getName().equals("test")) {
            permissions.add("2");
        }
        if (user.getName().equals("admin")) {
            permissions.add("2");
            permissions.add("3");
        }
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }
    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户输入的用户名和密码
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        // 通过用户名到数据库查询用户信息
        User user = userRepository.getUserByName(userName);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
