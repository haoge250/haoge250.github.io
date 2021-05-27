package com.etc.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
* @author hyh
* @version 创建时间：2021年5月27日 上午10:11:05
*/
public class SessionUtil {
	private static SqlSessionFactory ssf = null;
	
	/**
	 * 从xml中构建SqlSessionFactory
	 * 1.每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的。
	 * 2.SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。
	 * 3. SqlSessionFactoryBuilder则可以从 XML 配置文件或
	 * 一个预先配置的 Configuration 实例来构建出 SqlSessionFactory 实例。
	 * 4.MyBatis 包含一个名叫 Resources 的工具类，它包含一些实用方法，
	 * 使得从类路径或其它位置加载资源文件更加容易。
	 **/
	
	static {
		String resource = "configuration.xml";
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
		    ssf = ssfb.build(inputStream);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * 得到SqlSession
	 * 单例模式
	 * ***/
	
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = ssf.openSession();
		return sqlSession;
	}
	
	public static void closeSqlSession (SqlSession sqlSession) {
		sqlSession.close();
	}
	
	private SessionUtil() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
