package com.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.entity.Health;
public interface HealthMapper {
    //添加
    public int insert(Health health);  
    //删除
    public void delete(int id);  
    //根据id获取数据
    public Health get(int id);  
    //修改
    public int update(Health health);   
     //列表
    public List<Health> list(@Param("where") String where);
    //分页
    public List<Health> sealist(@Param("where") String where);
    //统计
    public int total(); 
public void updatesql(@Param("value")String value);
   public void deletesql(@Param("value")String value);
	
}