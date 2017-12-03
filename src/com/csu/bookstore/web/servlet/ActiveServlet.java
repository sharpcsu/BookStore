package com.csu.bookstore.web.servlet;

import com.csu.bookstore.exception.UserException;
import com.csu.bookstore.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sharp on 2017/12/2 0002 - 22:37
 */
@WebServlet(name = "ActiveServlet")
public class ActiveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取激活码
        String activeCode = request.getParameter("activeCode");
        
        UserService userService = new UserService();
        try {
            //处理业务逻辑
            userService.activeUser(activeCode);
            
            //分发转向
            request.getRequestDispatcher("/activesuccess.jsp").forward(request, response);
        } catch (UserException e) {
            e.printStackTrace();
            //用户提示失败信息
            response.getWriter().write(e.getMessage());
        }
    
        
    }
}
