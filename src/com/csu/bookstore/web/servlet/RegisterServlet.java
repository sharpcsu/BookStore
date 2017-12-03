package com.csu.bookstore.web.servlet;

import com.csu.bookstore.domain.User;
import com.csu.bookstore.exception.UserException;
import com.csu.bookstore.service.UserService;

import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注册
 * @author sharp on 2017/12/2 0002 - 16:50
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理验证码
        String ckcode = request.getParameter("ckcode"); //自己输入的
        String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");//系统生成的
        
        //如果两个验证码不一致， 跳回注册界面
        if (!checkcode_session.equals(ckcode)) {
            request.setAttribute("ckcode_msg", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        
        
        //获取表单数据
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            user.setActiveCode(UUID.randomUUID().toString()); //手动设置激活码
            
            //调整业务逻辑
            UserService userService = new UserService();
            userService.register(user);
    
            //分发转向
            //要求用户激活后才能登录， 所以不能把用户信息保存session中
            request.setAttribute("user", user); //把用户信息封装到session对象中
            request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (UserException e) {
            request.setAttribute("user_msg", e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
    
    }
}
