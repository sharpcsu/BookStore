package com.csu.bookstore.domain;

/**
 * 订单条目
 * Created by sharp on 2017/12/2 0002 - 16:20
 */
public class OderItem {
    
    private Product p;  //订单
    private int buynum;  //商品
    private Order order;  //购物数量
    
    public Order getOrder() {
        return order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public Product getP() {
        return p;
    }
    
    public void setP(Product p) {
        this.p = p;
    }
    
    public int getBuynum() {
        return buynum;
    }
    
    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }
}
