package com.reclamation.rweb.filter;

import com.reclamation.rweb.util.ReadConfigUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterOpenid" , urlPatterns = {"/*"})
public class FilterOpenid implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

         HttpServletRequest req = (HttpServletRequest) request;
         HttpServletResponse res = (HttpServletResponse) response;

        String currentUrl = req.getRequestURI();

        Object openid = req.getSession().getAttribute("openid");

        if(openid == null && currentUrl.indexOf("weixin") < 0){

            req.getSession().setAttribute("currentUrl", "https://"+ ReadConfigUtil.config.get("config").get("local") +currentUrl);
                //重定向获取openid
            res.sendRedirect("https://"+ ReadConfigUtil.config.get("config").get("local") +"/weixin/oauth2");
        }
        chain.doFilter(req, res);
    }
}
