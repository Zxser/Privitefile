package com.dh.system.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 * 公共dao用与数据库交互，提供save（保存）、update（修改）、delete（删除）、findOne（查询单个对象）、findList（查询集合）
 * @author 
 *
 * @param <T>（要操作的实体类类型）
 */

public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao {

	/** 操作的实体类类型 */
	private Class<T> clazz;
	
	/** mapper命名空间 */
	private String namespace;

	/**
	 * 注入SqlSessionFactory用于创建sqlSession
	 * @param sqlSessionFactory
	 */
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * 根据创建对象时传入的对象T, 初始化clazz、namespace.
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		System.out.println("clazz ---> " + clazz.getCanonicalName());
		namespace = clazz.getCanonicalName()+"Mapper.";
	}
	
	/**
	 * 更新
	 * @param spaceId（参数：MyBatis.mapper配置文件中的标签ID）
	 * @param input（参数：更新的实体类）
	 */
	@Override
	public <I> Integer update(String spaceId, I input) {
		return  this.getSqlSession().update(namespace + spaceId, input);
	}
	
	/**
	 * 删除
	 * @param spaceId（参数：MyBatis.mapper配置文件中的标签ID）
	 * @param input（参数：删除的条件）
	 */
	@Override
	public <I> Integer delete(String spaceId, I input) {
		return this.getSqlSession().delete(namespace + spaceId, input);
	}

	/**
	 * 保存
	 * @param spaceId（参数：MyBatis.mapper配置文件中的标签ID）
	 * @param input（参数：要保存的实体类可以是单个实体也可以是一个集合）
	 */
	@Override
	public <I> Integer save(String spaceId, I input) {
		return this.getSqlSession().insert(namespace + spaceId, input);
	}

	/**
	 * 返回一个集合
	 * @param spaceId（参数：MyBatis.mapper配置文件中的标签ID）
	 * @param input（参数：查询条件）
	 * @param output（参数：指定返回值类型）
	 * @return
	 */
	@Transactional(readOnly=true)
	public <I, O> List<O> findList(String spaceId, I input, Class<O> output) {
		return this.getSqlSession().selectList(namespace + spaceId, input);
	}

	/**
	 * 返回一个对象
	 * @param spaceId（参数：MyBatis.mapper配置文件中的标签ID）
	 * @param input（参数：查询条件）
	 * @param output（参数：指定集合中数据的类型）
	 * @return
	 */
	@Transactional(readOnly=true)
	public <I, O> O findOne(String spaceId, I input, Class<O> output) {
		return this.getSqlSession().selectOne(namespace + spaceId, input);
	}
}
