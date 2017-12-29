package com.csu.bookstore.domain;

import java.util.List;

/**
 * 分页实体
 * Created by sharp on 2017/12/2 0002 - 16:21
 */
public class PageBean {
    
    private int currentPage;// 当前页码
    private int count;// 总条数
    private int totalPage;// 总页数
    private int pageSize;// 每页条数
    private List<Product> products;// 每页显示的数据
    private String category; //分类
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public int getTotalPage() {
        return totalPage;
    }
    
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}
