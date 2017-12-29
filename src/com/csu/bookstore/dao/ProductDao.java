package com.csu.bookstore.dao;

import com.csu.bookstore.domain.PageBean;
import com.csu.bookstore.domain.Product;
import com.csu.bookstore.util.C3P0Util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 持久层
 * 产品相关
 * @author sharp on 2017/12/4 0004 - 19:59
 */
public class ProductDao {
    QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
    
    /**
     * 查找所有产品信息
     * @return 所有书籍信息
     */
    public List<Product> findProductBySearch() throws SQLException {
        return queryRunner.query("select * from products", new BeanListHandler<Product>(Product.class));
    }
    
    /**
     * 根据id查找书籍信息
     * @param id 书籍id
     * @return 书籍信息
     */
    public Product findProductById(String id) throws SQLException {
        return queryRunner.query("select * from products where id=?", new BeanHandler<Product>(Product.class), id);
    }
    
    /**
     * 返回当前页信息
     * @param currentPage 当前页
     * @param pageSize 每页大小
     * @param category 类别
     * @return 一页信息
     */
    public List<Product> findProductsPage(int currentPage, int pageSize, String category) throws SQLException {
        String sql = "select * from products where 1=1";
        ArrayList list = new ArrayList();
    
        if (!"".equals(category)) {
            sql += " and category=?";
            list.add(category);
        }
    
        sql += " limit ?,?";
        
        //select * from products where 1=1 and category=? limit ?,?;
        list.add((currentPage - 1) * pageSize);
        list.add(pageSize);
        
        return queryRunner.query(sql, new BeanListHandler<Product>(Product.class), list.toArray());
    }
    
    /**
     * 获得该类别的总条数
     * @param category 书籍类别
     * @return 数目
     */
    public int count(String category) throws SQLException {
        String sql = "select count(*) from products";
        
        //如果category不是null,就把条件加上
        if (!"".equals(category)) {
            sql += " where category='" + category + "'";
        }
    
        long l = (Long) queryRunner.query(sql, new ScalarHandler(1));
        return (int)l;
    }
}
