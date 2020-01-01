package com.sunxc.community.mapper;

import com.sunxc.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
      void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);
    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Integer id);
}
