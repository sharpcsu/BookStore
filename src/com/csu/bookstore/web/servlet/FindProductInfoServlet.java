package com.csu.bookstore.web.servlet;

import com.csu.bookstore.domain.Product;
import com.csu.bookstore.exception.ProductException;
import com.csu.bookstore.service.ProductService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 查找书籍的详细信息
 * @author sharp on 2017/12/8 0008 - 17:34
 */
public class FindProductInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求数据
        String id = request.getParameter("id");
    
        //处理业务逻辑
        ProductService productService = new ProductService();
        try {
            Product product = productService.findProductById(id);
            
            //分发转向
            request.setAttribute("p", product);
            request.getRequestDispatcher("/product_info.jsp").forward(request, response);
        } catch (ProductException e) {
            e.printStackTrace();
        }
        
    }
}
