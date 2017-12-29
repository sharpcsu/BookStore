package com.csu.bookstore.service;

import com.csu.bookstore.dao.ProductDao;
import com.csu.bookstore.domain.PageBean;
import com.csu.bookstore.domain.Product;
import com.csu.bookstore.exception.ProductException;
import com.sun.deploy.panel.ITreeNode;

import java.sql.SQLException;
import java.util.List;

/**
 * 业务层
 * 产品相关
 * @author sharp on 2017/12/4 0004 - 19:57
 */
public class ProductService {
    private ProductDao productDao = new ProductDao();
    
    /**
     * 查找所有产品信息
     * @return 所有商品信息
     */
    public List<Product> findProductBySearch() throws ProductException {
        try {
            return productDao.findProductBySearch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ProductException("查询商品失败");
        }
    }
    
    /**
     * 根据id查找书籍信息
     * @param id 书籍id
     * @return 书籍信息
     */
    public Product findProductById(String id) throws ProductException {
        try {
            return productDao.findProductById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ProductException("查询信息失败");
        }
    }
    
    /**
     * 根据分页查找一页信息
     * @param currentPage 当前页
     * @param pageSize 每页大小
     * @param category 类别
     * @return 一页信息
     */
    public PageBean findProductsPage(int currentPage, int pageSize, String category) {
        PageBean pageBean = null;
        try {
            //得到总记录数
            int count = productDao.count(category);
            //求出总页数
            int totalPage = (int) Math.ceil(count * 1.0 / pageSize);
            List<Product> products = productDao.findProductsPage(currentPage, pageSize, category);
        
            //把pageSize个变量封装到PageBean中,作为返回值
            pageBean = new PageBean();
            pageBean.setProducts(products);
            pageBean.setCount(count);
            pageBean.setCurrentPage(currentPage);
            pageBean.setPageSize(pageSize);
            pageBean.setTotalPage(totalPage);
        
            //在PageBean中添加属性,用于点击上一页或下一页时使用
            pageBean.setCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return pageBean;
    }
}
