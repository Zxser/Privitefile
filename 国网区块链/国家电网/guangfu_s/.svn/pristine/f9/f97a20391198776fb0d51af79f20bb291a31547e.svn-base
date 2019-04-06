package com.dh.system.base;
 
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dh.system.po.CmsInfoMongo;
 
/**
 * 继承自MongoRepository接口，MongoRepository接口包含了常用的CRUD操作，
 * 例如：save、insert、findall等等。我们可以定义自己的查找接口，
 * 例如根据demoInfo的name搜索，具体的DemoInfoRepository接口代码如下：
 * @version v.0.1
 * @date 2016年8月18日下午3:15:49
 */
public interface  MongodInfoRepository  extends MongoRepository<CmsInfoMongo, String> {
	// 接下来就是访问控制类，这个类中很简单，都是最基本的代码，看如下：
	CmsInfoMongo findByTitle(String title);
	CmsInfoMongo findById(String id);
	void deleteById(String id);
}
 


