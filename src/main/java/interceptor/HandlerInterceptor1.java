package interceptor;

import domain.Student;
import domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理未登录情况下能访问后台页面的情况
 */
public class HandlerInterceptor1 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===========================prehandle拦截器1111起作用了");
        //false代表不放行，true代表放行
        User user = (User) request.getSession().getAttribute("user");
        Student student = (Student)request.getSession().getAttribute("student");
        //如果登录成功则name和password都有值，否则都没有值
        if(user != null){
            return true;
        }else{//
            response.sendRedirect(request.getContextPath()+"/loginPage");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===========================postHandle方法1111执行了");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===========================afterCompletion方法1111执行了");
    }
}
