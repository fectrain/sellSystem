package com.homework.sellSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.homework.sellSystem.entity.Person;

public interface PersonDao {
	/**
	 * 根据用户名查询用户
	 * @param userName
	 * @return
	 */
	@Select("select * from person p where p.username = #{uerName}")
	public List<Person> getPersonByUserName(String userName);
}
