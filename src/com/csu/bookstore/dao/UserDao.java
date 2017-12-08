package com.csu.bookstore.dao;

import com.csu.bookstore.domain.User;
import com.csu.bookstore.util.C3P0Util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * 持久层
 * 用户相关操作
 * Created by sharp on 2017/12/1 0001 - 23:47
 */
public class UserDao {
    
    QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
    
    /**
     * 添加用户
     *
     * @param user
     */
    public void addUser(User user) throws SQLException {
        String sql = "insert into user(username,PASSWORD,gender,email,telephone,introduce,activecode,state,registTime) " +
                "VALUES(?,?,?,?,?,?,?,?,?)";
        queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getGender(),
                user.getEmail(), user.getTelephone(), user.getIntroduce(),
                user.getActiveCode(), user.getState(), user.getRegistTime());
    }
    
    /**
     * 根据激活码查找用户
     *
     * @param activeCode 激活码
     * @return 对应激活码的用户
     */
    public User findUserByActiveCode(String activeCode) throws SQLException {
        String sql = "select * from user where activeCode=?";
        
        return queryRunner.query(sql, new BeanHandler<User>(User.class), activeCode);
    }
    
    /**
     * 激活用户
     *
     * @param activeCode 激活码
     */
    public void activeUser(String activeCode) throws SQLException {
        String sql = "update user set state=1 where activeCode=?";
        queryRunner.update(sql, activeCode);
    }
    
    /**
     * 根据用户名和密码查找用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 对应的用户
     */
    public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "select * from user where username=? and password=?";
        return queryRunner.query(sql, new BeanHandler<User>(User.class), username, password);
    }
    
    /**
     * 根据id查找用户信息
     *
     * @param id 用户id
     * @return 用户
     */
    public User findUserById(String id) throws SQLException {
        return queryRunner.query("select * from user where id=?", new BeanHandler<User>(User.class), id);
    }
    
    /**
     * 修改用户信息
     *
     * @param user 修改的用户信息
     * @return 影响的行数
     */
    public int modifyUser(User user) throws SQLException {
        return queryRunner.update("update user set password=?, gender=?, telephone=? where id=?",
                user.getPassword(), user.getGender(), user.getTelephone(), user.getId());
    }
}
