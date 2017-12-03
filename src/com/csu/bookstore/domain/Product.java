package com.csu.bookstore.domain;

/**
 * 商品实体
 *
 * Created by sharp on 2017/12/2 0002 - 16:18
 */
public class Product {
    
    /**
     * 商品编号
     */
    private String name;
    
    /**
     * 名称
     */
    private double price;
    
    /**
     * 价格
     */
    private String category;
    
    /**
     * 分类
     */
    private int pnum;
    
    /**
     * 数量
     */
    private String img_url;
    
    /**
     * 图片路径
     */
    private String description;
    
    /**
     * 描述
     */
    private String id;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public int getPnum() {
        return pnum;
    }
    
    public void setPnum(int pnum) {
        this.pnum = pnum;
    }
    
    public String getImg_url() {
        return img_url;
    }
    
    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
