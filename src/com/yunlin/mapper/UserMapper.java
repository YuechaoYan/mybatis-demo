package com.yunlin.mapper;

import com.yunlin.pojo.User;

public interface UserMapper {
   /*
    * 遵循四个原则
    * 1，方法名 == user.xml中的id名
    * 2.返回值类型和mapper.xml文件中返回值一致
    * 3，方法的入参类型和于Mapper.xml文件中入参一致
    * 4，命名空间绑定接口
    */
	public User findUserById(Integer id);
	
}
