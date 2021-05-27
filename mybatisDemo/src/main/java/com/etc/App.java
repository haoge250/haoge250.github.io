package com.etc;

import org.apache.ibatis.session.SqlSession;

import com.etc.dao.UserDao;
import com.etc.entity.User;
import com.etc.utils.BaseDao;
import com.etc.utils.SessionUtil;

/**
* @author hyh
* @version 创建时间：2021年5月27日 上午10:41:03
*/
public class App {
	public static void main(String[] args) {
		SqlSession sqlSession = SessionUtil.getSqlSession();
		/**
		 * selectOne(String statement, Object parameter) //statement是命名空间
		 * ***/
		//插入报错可能是主键重复，这里主键是id，此时id为203。
		int number = sqlSession.insert("com.etc.entity.UserMapper.insertUser", new User(204,"a","b","c"));
		System.out.println(number);
		
		User user = (User) sqlSession.selectOne("com.etc.entity.UserMapper.selectUser",204);
		System.out.println(user);
		/**
		 * 关闭连接
		 * **/
		//增，删，改要提交。
		sqlSession.commit();
		SessionUtil.closeSqlSession(sqlSession);
		
		//UserDao userDao = new UserDao();
		//userDao.deleteEntity(1);
	}

}
