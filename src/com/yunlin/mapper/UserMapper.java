package com.yunlin.mapper;

import com.yunlin.pojo.User;

public interface UserMapper {
   /*
    * ��ѭ�ĸ�ԭ��
    * 1�������� == user.xml�е�id��
    * 2.����ֵ���ͺ�mapper.xml�ļ��з���ֵһ��
    * 3��������������ͺ���Mapper.xml�ļ������һ��
    * 4�������ռ�󶨽ӿ�
    */
	public User findUserById(Integer id);
	
}
