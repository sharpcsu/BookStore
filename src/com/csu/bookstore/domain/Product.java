package com.csu.bookstore.domain;

/**
 * 商品实体
 *
 * Created by sharp on 2017/12/2 0002 - 16:18
 */
public class Product {
    
    private String name;    //商品编号
    private double price;    //名称
    private String category;    //价格
    private int pnum;    //分类
    private String imgurl;    //数量
    private String description;    //图片路径
    private String id;    //描述
    
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
    
    public String getImgurl() {
        return imgurl;
    }
    
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
}
