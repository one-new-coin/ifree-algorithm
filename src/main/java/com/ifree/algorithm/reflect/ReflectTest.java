package com.ifree.algorithm.reflect;

import org.junit.Test;

import com.ifree.algorithm.entity.User;

public class ReflectTest {


	@Test
	public void test1() {
		User user = new User("username1","password1");
		System.out.println(user.toString());
	}
	
	@Test
	public void test2() throws Exception, IllegalAccessException {
		User user = User.class.newInstance();
		user.setPassword("test");
		user.setUsername("test");
		System.out.println(user);
	}
	
	
	@Test
	public void test3()  throws Exception{
		Class<User> clazz = (Class<User>) Class.forName("com.ifree.algorithm.entity.User");
		User user = clazz.newInstance();
		user.setPassword("test1");
		user.setUsername("test1");
		System.out.println(user);
	}
}
