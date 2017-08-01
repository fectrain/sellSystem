package com.homework.sellSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.homework.sellSystem.entity.Transaction;

public interface TransactionDao {

	@Insert("insert into trx(contentId,personId,price,time) values(#{contentId},#{personId},#{price},#{time})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int insert(Transaction transaction);
	
	@Select("select * from trx where personId = #{id}")
	public List<Transaction> selectById(@Param("id")int userId);
	
	@Select("select t.personId from trx t where t.contentId=${contentId}")
	public List<Integer> getpersonId(@Param("contentId")int contentId);
	
	@Select("select * from trx where contentId = ${contentId}")
	public List<Transaction> selectTrx(@Param("contentId") int id);
	
	@Select("select count(*) from trx where contentId = ${contentId}")
	public int selectCount(@Param("contentId") int id);
}
