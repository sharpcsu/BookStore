package com.csu.bookstore.web.servlet;

import com.csu.bookstore.domain.PageBean;
import com.csu.bookstore.service.ProductService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 分页查找商品信息
 * @author sharp on 2017/12/8 0008 - 19:05
 */
public class PageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //导航按钮的查询条件
        String category = request.getParameter("category");
        if (category == null) {
            category = "";
        }
    
        //初始化每页显示的记录数
        int pageSize = 4;
        
        int currentPage = 1; //当前页
        String currPage = request.getParameter("currentPage");//从上一页到下一页得到的数据
        if (currPage != null && !"".equals(currentPage)) { //第一次访问资源时currentPage可能是null
            currentPage = Integer.parseInt(currPage);
        }
    
        ProductService productService = new ProductService();
    
        //分页查询,并返回PageBean对象
        PageBean pageBean = productService.findProductsPage(currentPage, pageSize, category);
    
        request.setAttribute("pb", pageBean);
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);
    }
}
