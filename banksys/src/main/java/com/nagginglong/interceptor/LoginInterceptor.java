package com.nagginglong.interceptor;

import com.nagginglong.entity.User;
import com.nagginglong.utils.ConstantsQantity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.handler.Handler;

/**
 * description: 拦截器，类似与Filter
 *
 * @author:像大山一样
 * @Date:2020/9/12 17:01
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //获取请求资源
        String requestURI = request.getRequestURI();

        //uri  统一资源标识符
        //url 统一资源定位符

        System.out.println("拦截到request请求是-----" + requestURI);

        User user = (User)request.getSession().getAttribute(ConstantsQantity.USER_NAME);

        if (requestURI.equals("/banksys/register.do")){
            return true;
        }
        if (requestURI.equals("/banksys/forgetPassword.do")){
            return true;
        }





//        判断请求的所带的session是否有user进而判断是否登录
        //等于null说明没有登录
        if (user == null) {
            //如果是ajax请求也得跳转到login.html
            //如果是jquery的ajax请求的话，浏览器会带有一个特殊的请求头
//            String header = request.getHeader("X-Requested-With");
//            //如果不为空，且这个"X-Requested-With"的值为XHLHttpRequest，标明是AJAX请求
//            if (header != null && header.equals("XHLHttpRequest")) {
//                //直接返回JSON数据表示登录！
//                response.getWriter().print("{\"code\":0,\"info\":\"未登录\"}");
//            }else {
//                没有登录，直接跳转到 login.html  非ajax请求的时候直接登录页面
                response.sendRedirect(request.getContextPath()+"/login.html");
//            }
            //返回false就表示拦截
        return false;

        }


        //user不为空就放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
