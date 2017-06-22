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
     * ����id��ѯ����
     */
    public void testMybatis() throws Exception{
    	//���غ��������ļ�
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //ִ��sql���
        User user = sqlSession.selectOne("test.findUserById", 1);
        
        System.out.println(user);
    }
  
    /*
     * ��ѯ��������
     */
    public void testMybatis1() throws Exception{
    	//���غ��������ļ�
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //ִ��sql���
        List<User> userList = sqlSession.selectList("test.findAll");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
		}
    }
    /*
     * insert 
     */
   
    public void testMybatis2() throws Exception{
    	//���غ��������ļ�
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //ִ��sql���
        User user = new User(  "Tommy", "��", new Date(), "zhejiang");
        sqlSession.insert("test.insert", user);
      
        sqlSession.commit();
    }
    
    /*
     * �����û���ģ����ѯ����
     */
    
    public void testMybatis3() throws Exception{
    	//���غ��������ļ�
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //ִ��sql���
        List<User> userList = sqlSession.selectList("test.findUserByUsername", "��");
        	
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
		}
    }
    /*
     * insert 
     */
    
    public void testMybatis4() throws Exception{
    	//���غ��������ļ�
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //ִ��sql���
        User user = new User( "Tommy2", "��", new Date(), "zhejiang");
        sqlSession.insert("com.yunlin.mapper.UserMapper.insertAndBackId", user);
      
        sqlSession.commit();
        
        System.out.println(user.getId());
    }
    /*
     * update
     */
    
    public void testMybatis5() throws Exception{
    	//���غ��������ļ�
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //ִ��sql���
        User user = new User( "Tommy2", "��", new Date(), "zhejiang");
        user.setId(20170622);
        sqlSession.update("com.yunlin.mapper.UserMapper.update", user);
      
        sqlSession.commit();
        
    }
    /*
     * 
     */
    
    public void testMybatis6() throws Exception{
    	//���غ��������ļ�
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        //ִ��sql���
        User user = new User( "Tommy2", "��", new Date(), "zhejiang");
        user.setId(20170622);
        sqlSession.delete("com.yunlin.mapper.UserMapper.delete",user.getId());
      
        sqlSession.commit();
        
    }
    /*
     * ����mapper��̬������
     */
    @Test
    public void testMapper() throws Exception{
    	//���غ��������ļ�
    	String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        
    	//����SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    
        //����SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        User user = userMapper.findUserById(10);
        
        System.out.println(user);
    }
}