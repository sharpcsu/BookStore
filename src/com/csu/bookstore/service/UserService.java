package com.csu.bookstore.service;

import com.csu.bookstore.dao.UserDao;
import com.csu.bookstore.domain.User;
import com.csu.bookstore.exception.UserException;

import java.sql.SQLException;

/**
 * 业务层
 * 用户相关操作
 * @author sharp on 2017/12/1 0001 - 23:47
 */
public class UserService {
    private UserDao userDao = new UserDao();
    
    /**
     * 注册用户
     *
     * @param user 需要注册的用户信息
     */
    public void register(User user) throws UserException {
        try {
            //用户注册
            userDao.addUser(user);
            
            //            String emailMsg = "注册成功，请<a href='http://bookstore.com?activeCode="+user.getActiveCode()+"'>激活</a>后登录。";
            //            SendJMail.sendMail(user.getEmail(), emailMsg);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("注册失败！");
        }
    }
    
    /**
     * 激活用户
     *
     * @param activeCode 激活码
     */
    public void activeUser(String activeCode) throws UserException {
        try {
            User user = userDao.findUserByActiveCode(activeCode);
            if (user != null) {
                userDao.activeUser(activeCode);
                return;
            }
            throw new UserException("用户激活失败");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("用户激活失败");
        }
    }
    
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户实体信息
     */
    public User login(String username, String password) throws UserException {
        try {
            User user = userDao.findUserByUsernameAndPassword(username, password);
            if (user == null) {
                throw new UserException("用户名或者密码错误");
            }
            
            if (user.getState() == 0) {
                throw new UserException("用户状态未激活");
            }
            
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("用户名或者密码错误");
        }
    }
    
    /**
     * 根据id查找用户信息
     *
     * @param id 用户编码
     * @return 用户
     */
    public User findUserById(String id) throws UserException {
        try {
            User user = userDao.findUserById(id);
            if (user == null) {
                throw new UserException("获取用户信息失败");
            }
            
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("获取用户信息失败");
        }
    }
    
    /**
     * 修改用户信息
     *
     * @param user 需要修改的用户信息
     */
    public int modifyUser(User user) throws UserException {
        try {
            int num = userDao.modifyUser(user);
            if (num == 0) {
                throw new UserException("修改用户信息失败");
            }
            
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("修改用户信息失败");
        }
    }
}
