/**
 * 
 */
/**
 * @author xy7
 *
 */
package com.ssm01.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm01.ssm.entity.User;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User>{
	public List<User> slelectUserList();

	public User selectByKey(@Param("username")String username);
}