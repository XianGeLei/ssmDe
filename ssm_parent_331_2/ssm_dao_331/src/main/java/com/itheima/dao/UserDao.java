package com.itheima.dao;

import com.itheima.domain.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserDao {
    //根据用户名查询用户对象(唯一的对象)
    @Select("select * from sys_user where username = #{username}")
    SysUser findByUsername(String username);
}
