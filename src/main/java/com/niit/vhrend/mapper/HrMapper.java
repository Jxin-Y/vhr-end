package com.niit.vhrend.mapper;

import com.niit.vhrend.model.Hr;
import org.apache.ibatis.annotations.Select;

/**
 * @author Lenovo
 */
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    @Select("select * from hr where username=#{username}")
    Hr loadUserByUsername(String username);
}
