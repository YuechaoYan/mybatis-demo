package com.yunlin.test;


import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yunlin.mapper.UserMapper;
import com.yunlin.pojo.User;


public class MybatisTest {
	/*
     * 根据id查询数据
     */
    public void testMybatis() throws Exception{
    	//加载核心配置文件
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //执行sql语句
        User user = sqlSession.selectOne("test.findUserById", 1);
        
        System.out.println(user);
    }
  
    /*
     * 查询所有数据
     */
    public void testMybatis1() throws Exception{
    	//加载核心配置文件
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //执行sql语句
        List<User> userList = sqlSession.selectList("test.findAll");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
		}
    }
    /*
     * insert 
     */
   
    public void testMybatis2() throws Exception{
    	//加载核心配置文件
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //执行sql语句
        User user = new User(  "Tommy", "男", new Date(), "zhejiang");
        sqlSession.insert("test.insert", user);
      
        sqlSession.commit();
    }
    
    /*
     * 根据用户名模糊查询数据
     */
    
    public void testMybatis3() throws Exception{
    	//加载核心配置文件
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //执行sql语句
        List<User> userList = sqlSession.selectList("test.findUserByUsername", "五");
        	
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
		}
    }
    /*
     * insert 
     */
    
    public void testMybatis4() throws Exception{
    	//加载核心配置文件
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //执行sql语句
        User user = new User( "Tommy2", "男", new Date(), "zhejiang");
        sqlSession.insert("com.yunlin.mapper.UserMapper.insertAndBackId", user);
      
        sqlSession.commit();
        
        System.out.println(user.getId());
    }
    /*
     * update
     */
    
    public void testMybatis5() throws Exception{
    	//加载核心配置文件
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //执行sql语句
        User user = new User( "Tommy2", "男", new Date(), "zhejiang");
        user.setId(20170622);
        sqlSession.update("com.yunlin.mapper.UserMapper.update", user);
      
        sqlSession.commit();
        
    }
    /*
     * 
     */
    
    public void testMybatis6() throws Exception{
    	//加载核心配置文件
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //执行sql语句
        User user = new User( "Tommy2", "男", new Date(), "zhejiang");
        user.setId(20170622);
        sqlSession.delete("com.yunlin.mapper.UserMapper.delete",user.getId());
      
        sqlSession.commit();
        
    }
    /*
     * 测试mapper动态代理开发
     */
    @Test
    public void testMapper() throws Exception{
    	//加载核心配置文件
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        User user = userMapper.findUserById(10);
        
        System.out.println(user);
    }
}