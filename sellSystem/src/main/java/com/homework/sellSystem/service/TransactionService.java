package com.homework.sellSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.sellSystem.dao.TransactionDao;
import com.homework.sellSystem.entity.Transaction;

@Service
public class TransactionService {

	@Autowired
	TransactionDao transactionDao;
	
	public List<Transaction> getTrx(int id) {
		return transactionDao.selectById(id);
	}
	
	public boolean isBuy(int userId, int productId) {
		List<Integer> _userId = transactionDao.getpersonId(productId);
		for (Integer id :_userId){
			if(id == userId) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isSell(int productId) {
		int count = transactionDao.selectCount(productId);
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	public boolean add(List<Transaction> list) {
		for(Transaction trx: list) {
			int flag = transactionDao.insert(trx);
		}
		return true;
	}
	
}
