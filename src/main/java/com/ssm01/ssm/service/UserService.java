package com.ssm01.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm01.ssm.entity.User;
import com.ssm01.ssm.mapper.UserMapper;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	
	public List<User> getUserList(){
		List<User> list = userMapper.selectAll();
		return list;
	}
	
	public User getUser(String username){
		User user = userMapper.selectByKey(username);
		return user;
	}
}
