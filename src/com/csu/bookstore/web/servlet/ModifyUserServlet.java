package com.csu.bookstore.web.servlet;

import com.csu.bookstore.domain.User;
import com.csu.bookstore.exception.UserException;
import com.csu.bookstore.service.UserService;

import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 修改用户信息
 *
 * @author sharp on 2017/12/3 0003 - 17:33
 */
public class ModifyUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            //封装表单数据
            BeanUtils.populate(user, request.getParameterMap());
            
            //处理业务逻辑
            UserService userService = new UserService();
            userService.modifyUser(user);
            
            //分发转向
            request.getSession().invalidate();//注销用户
            response.sendRedirect(request.getContextPath() + "/modifyUserInfoSuccess.jsp");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (UserException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
    }
}
