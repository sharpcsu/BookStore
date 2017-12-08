package com.csu.bookstore.domain;

import java.util.Date;

/**
 * 订单类实体
 * Created by sharp on 2017/12/2 0002 - 16:19
 */
public class Order {
    
    private double money;    //订单编号
    private String receiverAddress;    //订单总价
    private String receiverName;    //送货地址
    private String receiverPhone;    //收货人姓名
    private int paystate;    //收货人电话
    private Date ordertime;    //订单状态
    private String id;    //下单时间
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public double getMoney() {
        return money;
    }
    
    public void setMoney(double money) {
        this.money = money;
    }
    
    public String getReceiverAddress() {
        return receiverAddress;
    }
    
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
    
    public String getReceiverName() {
        return receiverName;
    }
    
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    
    public String getReceiverPhone() {
        return receiverPhone;
    }
    
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
    
    public int getPaystate() {
        return paystate;
    }
    
    public void setPaystate(int paystate) {
        this.paystate = paystate;
    }
    
    public Date getOrdertime() {
        return ordertime;
    }
    
    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }
}
