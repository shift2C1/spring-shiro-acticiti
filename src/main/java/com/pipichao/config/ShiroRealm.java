package com.pipichao.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//@Component
@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("授权中。。。");
        String username = (String) principalCollection.getPrimaryPrincipal();

        // 从数据库中根据用户名获取角色数据
        Set<String> roles = getRolesByUsername(username);
        // 从数据库中根据用户名获取权限数据
        Set<String> permissions = getPermissionbyUsername(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       log.info("认证中。。。");
        // 1.从主体传过来的认证信息中，获取用户名
        String username = (String) authenticationToken.getPrincipal();

        // 2.通过用户名去到数据库中获取凭证
        String password = getPasswordByUsername(username);
        if(password == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, "costomRealm");
//        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("pyy"));//设置盐salt

        return authenticationInfo;
    }

    // 模拟用户数据库数据
    Map<String,String> userMap = new HashMap<String, String>(16);
    {
        // 数据库中密码123456的md5密文
        userMap.put("admin", "123");
        super.setName("costomRealm");
    }

    /**
     * 模拟用户权限信息
     * @param username
     * @return
     */
    private Set<String> getPermissionbyUsername(String username) {
        Set<String> sets = new HashSet<String>();
        sets.add("user:delete");
        sets.add("user:add");
        return sets;
    }



    /**
     * 模拟根据用户名获取数据库中的角色数据
     * @param username
     * @return
     */
    private Set<String> getRolesByUsername(String username) {
        Set<String> sets = new HashSet<String>();
        sets.add("admin");
        sets.add("user");
        return sets;
    }
    /**
     * 模拟数据库查询凭证
     * @param username
     * @return
     */
    private String getPasswordByUsername(String username) {
        return userMap.get(username);
    }
}
