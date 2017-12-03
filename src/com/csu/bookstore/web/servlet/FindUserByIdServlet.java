package com.csu.bookstore.web.servlet;

import com.csu.bookstore.domain.User;
import com.csu.bookstore.exception.UserException;
import com.csu.bookstore.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sharp on 2017/12/3 0003 - 17:08
 */
public class FindUserByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String id = request.getParameter("id");
        
        try {
            //处理业务逻辑
            UserService userService = new UserService();
            User user = userService.findUserById(id);
            
            request.setAttribute("u", user);
            
            //分发转向
            request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request, response);
        } catch (UserException e) {
            e.printStackTrace();
//            response.getWriter().write(e.getMessage());
            //重定向到登录界面
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
