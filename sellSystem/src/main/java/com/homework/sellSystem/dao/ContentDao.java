package com.homework.sellSystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.homework.sellSystem.entity.Content;

public interface ContentDao {

	/**
	 * 获取所有商品列表
	 * @return
	 */
	@Select("select * from Content")
	public List<Content> contentList();
	
	/**
	 * 根据主键获取商品
	 * @param id
	 * @return
	 */
	@Select("select * from Content where id= ${id}")
	public Content content(@Param("id") int id);

	/**
	 * 更新事务  异常 则回滚
	 * @param content
	 * @param id
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Update("update Content c set c.price='${co.price}',c.title='${co.title}',c.abstract='${co._abstract}' where c.id=${id}")
	public int update(@Param("co") Content content,@Param("id") int id);
	
	/**
	 * 新增数据  异常则回滚
	 * @param content
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Insert("insert into Content(price,title,abstract) values('${price}','${title}','${_abstract}')")
	@Options(useGeneratedKeys = true, keyProperty = "id") //返回插入id
	public int insert(Content content);
	
	/**
	 * 删除产品
	 * @param id
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Delete("delete from Content where id =${id}")
	public int delete(@Param("id") int id);
}
