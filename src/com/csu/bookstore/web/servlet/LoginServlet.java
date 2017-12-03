package com.csu.bookstore.web.servlet;

import com.csu.bookstore.domain.User;
import com.csu.bookstore.exception.UserException;
import com.csu.bookstore.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录
 *
 * @author sharp on 2017/12/1 0001 - 23:50
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserService userService = new UserService();
        try {
            //处理业务逻辑
            User user = userService.login(username, password);
            request.getSession().setAttribute("user", user);
            
            //分发转向 权限管理
            String path = "";
            if ("普通用户".equals(user.getRole())) {
                path = "/index.jsp";
            } else if ("admin".equals(user.getRole())) {
                path = "/admin/login/home.jsp";
            }
            request.getRequestDispatcher(path).forward(request, response);
            
        } catch (UserException e) {
            e.printStackTrace();
            request.setAttribute("user_msg", e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
