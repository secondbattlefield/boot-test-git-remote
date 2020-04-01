package com.zcs.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@WebFilter(urlPatterns = "/**", filterName = "monitorFilter")
public class TokenAuthorFilter implements Filter {
    /*@Autowired
    private SysusertokenMapper sysusertokenMapper;
    @Autowired
    private SysloginuserMapper sysloginuserMapper;
    @Autowired
    private SysuserMapper sysuserMapper;*/

    private static final String[] excludePathPatterns = { "/monitor/account/login", "/monitor/account/register" };

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        // 在请求处理之前进行调用（Controller方法调用之前）,返回true才会继续往下执行，返回false取消当前请求
        boolean isFilter = false;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 不拦截登陆和注册
        String url = request.getRequestURI();
        if (Arrays.asList(excludePathPatterns).contains(url)) {
            chain.doFilter(request, response);
            return;
        }

        String tokenCode = request.getHeader("Token");
        /*if (tokenCode != null && !"".equals(tokenCode)) {
            // 查询未过期的
            Sysusertoken sysusertoken = sysusertokenMapper.selectByTokenCode(tokenCode);
            if (sysusertoken != null) {
                Sysloginuser sysloginuser = sysloginuserMapper.selectByPrimaryKey(sysusertoken.getLoginid());
                Sysuser sysuser = sysuserMapper.selectByPrimaryKey(sysloginuser.getUserid());
                request.getSession().setAttribute("user", sysuser);
                request.getSession().setAttribute("token", tokenCode);
                isFilter = true;
            }
        }*/
        if (isFilter) {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}