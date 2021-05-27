package com.etc.utils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

/**
* @author hyh
* @version 创建时间：2021年5月27日 下午2:19:55
*/
public class BaseDao<T> {
	
	private String namespace = "";

    /*public BaseDao(Class clazz){
        namespace = clazz.getName();
    }*/
    public BaseDao(){
        Class<T> clazz = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        namespace = clazz.getName();
        System.out.println("namespace:"+namespace);
    }

    public void insertEntity(T t ){
        SqlSession session = SessionUtil.getSqlSession();
        session.insert(namespace+".insert",t);
        SessionUtil.closeSqlSession(session);
    }
    public void deleteEntity(int id){

    }
    public void updateEntity(T t){

    }
    public List<T> selectAllEntity(){
        List<T> resultList = new ArrayList<>();
        SqlSession session = SessionUtil.getSqlSession();
        resultList = session.selectList(namespace+".select");
        return resultList;
    }
	
	

}
