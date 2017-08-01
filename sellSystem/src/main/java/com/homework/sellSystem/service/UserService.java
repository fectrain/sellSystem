package com.homework.sellSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.sellSystem.dao.PersonDao;
import com.homework.sellSystem.entity.Person;

@Service
public class UserService {
	
	@Autowired
	PersonDao personDao;
	
	public Person getPerson(String userName) {
		List<Person> list = personDao.getPersonByUserName(userName);
		for (Person p: list) {
			p.getPassword();
		}
		return list.get(0);
	}
	
}
