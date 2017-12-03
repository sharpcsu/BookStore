package com.csu.bookstore.web.servlet;

import com.csu.bookstore.domain.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 我的账户
 *
 * @author sharp on 2017/12/3 0003 - 16:32
 */
public class MyAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        User user = (User) request.getSession().getAttribute("user");
        
        //分发转向
        String path = "";
        if (user == null) {
            //转向long.jsp
            path = "/login.jsp";
        } else if ("admin".equals(user.getRole())) {
            //转向管理员界面
            path = "/admin/login/home.jsp";
        } else if ("普通用户".equals(user.getRole())) {
            //转向普通用户界面
            path = "myAccount.jsp";
        } else {
            //抛出异常
            throw new RuntimeException("账户权限错误");
        }
    
        request.getRequestDispatcher(path).forward(request, response);
    }
}
