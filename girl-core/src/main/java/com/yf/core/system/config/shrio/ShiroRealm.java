package com.yf.core.system.config.shrio;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取用户的角色和权限信息
 * @ClassName ShiroRealm
 * @Description
 * @Date 2018/5/3 10:28
 * @Author jinghan
 * @Version 1.0
 */
public class ShiroRealm extends AuthorizingRealm {

    /**
     * 授权信息
     * 权限认证
     *@Params: [principalCollection]
     *@Date: 2018/5/3 10:37
     *@Author: jinghan
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

                //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
//        //        String loginName = (String) super.getAvailablePrincipal(principalCollection);
//                UUser user = (UUser) principalCollection.getPrimaryPrincipal();
//        //        //到数据库查是否有此对象
//        //        User user = null;// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        //        user = userMapper.findByName(loginName);
//                if (user != null) {
//                    //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
//                    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//                    //用户的角色集合
//                    info.addRoles(user.getRoleStrlist());
//                    //用户的权限集合
//                    info.addStringPermissions(user.getPerminsStrlist());
//
//                    return info;
//                }
        return null;
    }

    /**
     * 登录认证
     *认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        logger.info("验证当前Subject时获取到token为：" + token.toString());
//        //查出是否有此用户
//        UUser hasUser = uUserDao.findByName(token.getUsername());
////        String md5Pwd = new Md5Hash("123", "lucare",2).toString();
//        if (hasUser != null) {
//            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//            List<URole> rlist = uRoleDao.findRoleByUid(hasUser.getId());//获取用户角色
//            List<UPermission> plist = uPermissionDao.findPermissionByUid(hasUser.getId());//获取用户权限
//            List<String> roleStrlist=new ArrayList<String>();////用户的角色集合
//            List<String> perminsStrlist=new ArrayList<String>();//用户的权限集合
//            for (URole role : rlist) {
//                roleStrlist.add(role.getName());
//            }
//            for (UPermission uPermission : plist) {
//                perminsStrlist.add(uPermission.getName());
//            }
//            hasUser.setRoleStrlist(roleStrlist);
//            hasUser.setPerminsStrlist(perminsStrlist);
////            Session session = SecurityUtils.getSubject().getSession();
////            session.setAttribute("user", hasUser);//成功则放入session
//            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//            return new SimpleAuthenticationInfo(hasUser, hasUser.getPswd(), getName());
//        }
        return null;
    }
}
