package com.dh.system.base;

import java.util.List;

public interface BaseDao {

	/**
	 * 更新
	 * @param spaceId（参数：MyBatis.mapper配置文件中的标签ID）
	 * @param input（参数：更新的实体类）
	 */
	public <I> Integer update(String spaceId, I input);

	/**
	 * 删除
	 * @param spaceId（参数：MyBatis.mapper配置文件中的标签ID）
	 * @param input（参数：删除的条件）
	 */
	public <I> Integer delete(String spaceId, I input);

	/**
	 * 保存
	 * @param spaceId（参数：MyBatis.mapper配置文件中的标签ID）
	 * @param input（参数：要保存的实体类可以是单个实体也可以是一个集合）
	 */
	public <I> Integer save(String spaceId, I input);

	/**
	 * 返回一个集合
	 * @param spaceId（参数：MyBatis.mapper配置文件中的标签ID）
	 * @param input（参数：查询条件）
	 * @param output（参数：指定返回值类型）
	 * @return
	 */
	public <I, O> List<O> findList(String spaceId, I input, Class<O> output);

	/**
	 * 返回一个对象
	 * @param spaceId（参数：MyBatis.mapper配置文件中的标签ID）
	 * @param input（参数：查询条件）
	 * @param output（参数：指定集合中数据的类型）
	 * @return
	 */
	public <I, O> O findOne(String spaceId, I input, Class<O> output);
}