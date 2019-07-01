package com.hospital.config;

/**
 * 2019年东软睿道实训项目-东软云医院项目
 *
 * @ClassName ShiroConfig
 * @Description 请输入你的简化描述！
 * @Author 方聪
 * @Date 2019/6/6 10:49
 * @Version 1.0
 **/
import com.hospital.shiro.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:23
 */
@Configuration
public class ShiroConfig {

    /**
     * 凭证匹配器,先不设计凭证认证加密系统，开发时先不涉及到密码加密
     * @return
     */
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        //md5加密1次
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        hashedCredentialsMatcher.setHashIterations(1);
//        return hashedCredentialsMatcher;
//    }

    /**
     * 自定义realm
     *
     * @return
     */
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        // 不进行涉及其加密
        //userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    /**
     * 安全管理器
     * 注：使用shiro-spring-boot-starter 1.4时，返回类型是SecurityManager会报错，
     * 直接引用shiro-spring则不报错
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }


//    /**
//     * 设置过滤规则
//     *
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        shiroFilterFactoryBean.setSuccessUrl("/");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
//
//        // 必须设置 SecurityManager
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//        shiroFilterFactoryBean.setLoginUrl("/login");  // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
//        shiroFilterFactoryBean.setSuccessUrl("/");// 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");//设置无权限跳转页面
//        Map<String, String> chains = new LinkedHashMap<>();
//        chains.put("/logout","logout");//退出的返回的控制器
//        chains.put("/login", "anon");//anon表示可以匿名访问
//        //对PermissionAction.class 中的url进行权限控制
//      //-----------------角色控制，我们仅仅做到角色控制即可，无需考虑权限控制，把角色控制好就ok---------
//
//        //需要门诊角色才可以访问
//        chains.put("/od/*", "roles[od]");
//        chains.put("/**","anon");
//        chains.put("/**", "authc");//authc 表示必须认证才能进行访问
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(chains);
//        return shiroFilterFactoryBean;
//
//    }
//
//

}
