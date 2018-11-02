/**
 * 
 */
/**
 * @author xy7
 *
 */
package com.ssm01.ssm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ssm01.ssm.entity.User;
import com.ssm01.ssm.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:beans.xml")
public class MainTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void selectUserList() {
		System.out.println(this.userMapper.slelectUserList().size());
		List<User> list = userMapper.slelectUserList();
		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			System.out.println(
					"id:" + user.getId() + "---account:" + user.getUsername() + "----pwd:" + user.getPassword());
		}
	}

	@Test
	public void selectUser() {
		System.out.println(this.userMapper.slelectUserList().size());
		User user = userMapper.selectByKey("admin");

		System.out.println("id:" + user.getId() + "---account:" + user.getUsername() + "----pwd:" + user.getPassword());

	}

}
