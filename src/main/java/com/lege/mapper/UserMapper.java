package com.lege.mapper;

import com.lege.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lege
 * @Description
 * @create 2022-06-06 13:58
 */
@Mapper
public interface UserMapper {
    @Select("select count(*) from user")
    Integer count();

    @Select("Select * from user")
    List<User> getAllUser();
}
