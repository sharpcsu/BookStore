package com.csu.bookstore.domain;

import java.util.List;

/**
 * 分页实体
 * Created by sharp on 2017/12/2 0002 - 16:21
 */
public class PageBean {
    
    /**
     * 当前页码
     */
    private int totalCount;
    
    /**
     * 总条数
     */
    private int totalPage;
    
    /**
     * 总页数
     */
    private int currentCount;
    
    /**
     * 每页条数
     */
    private List<Product> ps;
    
    /**
     * 每页显示的数据
     */
    private String category;
    
    /**
     * 分类
     */
    private int currentPage;
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public int getTotalCount() {
        return totalCount;
    }
    
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    
    public int getTotalPage() {
        return totalPage;
    }
    
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
    public int getCurrentCount() {
        return currentCount;
    }
    
    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }
    
    public List<Product> getPs() {
        return ps;
    }
    
    public void setPs(List<Product> ps) {
        this.ps = ps;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}