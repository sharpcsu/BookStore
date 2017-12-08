package com.csu.bookstore.dao;

import com.csu.bookstore.domain.Product;
import com.csu.bookstore.util.C3P0Util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
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
     * @return
     */
    public List<Product> findProductBySearch() throws SQLException {
        return queryRunner.query("select * from products", new BeanListHandler<Product>(Product.class));
    }
}
