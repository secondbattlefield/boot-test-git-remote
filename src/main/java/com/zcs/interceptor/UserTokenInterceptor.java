package com.zcs.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zcs
 * @data: 2020/4/2
 * @description:
 */
@Component
public class UserTokenInterceptor implements HandlerInterceptor {
    /*@Autowired
    private SysusertokenMapper sysusertokenMapper;
    @Autowired
    private SysloginuserMapper sysloginuserMapper;
    @Autowired
    private SysuserMapper sysuserMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 在请求处理之前进行调用（Controller方法调用之前）,返回true才会继续往下执行，返回false取消当前请求
        boolean isAccess = false;
        String tokenCode = request.getHeader("Token");
        if (tokenCode != null && !"".equals(tokenCode)) {
            //查询未过期的
            Sysusertoken sysusertoken = sysusertokenMapper.selectByTokenCode(tokenCode);
            if (sysusertoken != null) {
                Sysloginuser sysloginuser  = sysloginuserMapper.selectByPrimaryKey(sysusertoken.getLoginid());
                Sysuser sysuser = sysuserMapper.selectByPrimaryKey(sysloginuser.getUserid());
                request.getSession().setAttribute("user",sysuser);
                request.getSession().setAttribute("token",tokenCode);
                isAccess = true;
            }
        }
        return isAccess;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }*/

}
