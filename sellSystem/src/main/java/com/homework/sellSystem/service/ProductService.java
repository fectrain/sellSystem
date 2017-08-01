package com.homework.sellSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.sellSystem.dao.ContentDao;
import com.homework.sellSystem.entity.Content;

@Service
public class ProductService {
	@Autowired
	ContentDao contentDao;
	
	public List<Content> getContentList() {
		
		List<Content> list = contentDao.contentList();
		return list;
	}
	
	public Content getProduct(int id) {
		return contentDao.content(id);
	}
	
	public int edit(Content content,int id) {
		return contentDao.update(content, id);
	}
	
	public int add(Content content) {
		return contentDao.insert(content);
	}
	
	public int delete(int id) {
		return contentDao.delete(id);
	}
}
