package com.sunxc.community.mapper;

import com.sunxc.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @projectname:community
 * @classname:UserMapper
 * @description:UserMapper
 * @auhtor: sunxc
 * @date: 2019/12/26-18:59
 * @version: 1.0
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
      void insert(User user);
}
