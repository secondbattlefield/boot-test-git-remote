package com.zcs.config;

import com.zcs.interceptor.UserTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author: zcs
 * @data: 2020/4/2
 * @description:
 */
@Component
public class MyConfig extends WebMvcConfigurationSupport {

    @Autowired
    private UserTokenInterceptor userTokenInterceptor;

    /**
     *
     * 添加拦截器
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(userTokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/account/login","/account/register");
        super.addInterceptors(registry);
    }



}
