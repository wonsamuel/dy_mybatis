package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface EmployeeDao {
	
	List<Map<String,String>> selectList(SqlSession session);
	
//	List<Map<String,String>> selectKeyList(SqlSession session, Map<String,String> param);
	List<Map<String,String>> selectKeyList(SqlSession session, Map<String,Object> param);
	
	//페이징 처리
	List<Map<String, String>> selectEmpList(SqlSession session, int cPage,int numperPage);
	int selectEmpCount(SqlSession session);

}
