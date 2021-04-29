package com.wang.dao;

import com.wang.pojo.User;

import java.util.List;

/**
 * @author 王航
 * @QQ 954544828
 * @since 2021/4/28 0028
 */
public interface UserDao {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //insert一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);
}
