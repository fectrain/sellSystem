package com.homework.sellSystem;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.homework.sellSystem.dao.ContentDao;
import com.homework.sellSystem.dao.PersonDao;
import com.homework.sellSystem.dao.TransactionDao;
import com.homework.sellSystem.entity.Content;
import com.homework.sellSystem.entity.Person;
import com.homework.sellSystem.entity.Transaction;

public class mybatisTest {
	ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
	
	@Test
	public void mybatisTest_1() {
		ContentDao contentDao = context.getBean("contentDao", ContentDao.class);
		List<Content> list = contentDao.contentList();
		for (Content co : list) {
			System.out.println(co.getTitle());
		}
	}

	@Test
	public void mybatisTest_2() {
		PersonDao personDao = context.getBean("personDao", PersonDao.class);
		List<Person> list = personDao.getPersonByUserName("buyer");
		for (Person co : list) {
			System.out.println(co.getNickName());
		}
	}
	
	@Test
	public void mybatisTest_3() {
		TransactionDao transactionDao = context.getBean("transactionDao", TransactionDao.class);
		Transaction trx = new Transaction();
		trx.setContentId(1);
		trx.setPersonId(1);
		trx.setPrice(200);
		trx.setTime(new Long(00000));
		int flag = transactionDao.insert(trx);
		System.out.println(flag);
		System.out.println(trx.getId());
	}
}
