package com.csu.bookstore.service;

import com.csu.bookstore.dao.ProductDao;
import com.csu.bookstore.domain.Product;
import com.csu.bookstore.exception.ProductException;

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
}
