package com.csu.bookstore.web.servlet;

import com.csu.bookstore.domain.Product;
import com.csu.bookstore.exception.ProductException;
import com.csu.bookstore.service.ProductService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 查询所有产品信息
 * @author sharp on 2017/12/4 0004 - 19:50
 */
@WebServlet(name = "FindProductBySearchServlet")
public class FindProductBySearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //处理业务逻辑
        ProductService productService = new ProductService();
        try {
            List<Product> ps = productService.findProductBySearch();
            request.setAttribute("ps", ps);
            request.getRequestDispatcher("/product_list.jsp").forward(request, response);
        } catch (ProductException e) {
            e.printStackTrace();
        }
    }
}
