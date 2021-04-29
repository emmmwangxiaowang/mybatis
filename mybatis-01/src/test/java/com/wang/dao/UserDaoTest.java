package com.wang.dao;

import com.wang.pojo.User;
import com.wang.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 王航
 * @QQ 954544828
 * @since 2021/4/28 0028
 */
public class UserDaoTest {
    @Test
    public void test(){

        //1.获取sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();

        try{
               
            //方式一:getMapper----反射
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<User> userList = userDao.getUserList();
            //方式二:
            List<User> userList = sqlSession.selectList("com.awng.dao.UserDao.getUserList");
            for (User user : userList) {
                System.out.println(user);
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();;
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.addUser(new User(2,"小小王","123"));

        //增删改---必须提交事务
        sqlSession.commit();
        sqlSession.close();;
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.updateUser(new User(2,"蒋莹莹","123"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.deleteUser(2);

        sqlSession.commit();
        sqlSession.close();
    }
}
