package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class EmloyeeDaoImpl implements EmployeeDao {

	@Override
	public List<Map<String, String>> selectList(SqlSession session) {
		return session.selectList("emp.selectList");
	}
	
//	@Override
//	public List<Map<String, String>> selectKeyList(SqlSession session, Map<String,String> param) {
//		return session.selectList("emp.selectKeyList",param);
//	}
	@Override
	public List<Map<String, String>> selectKeyList(SqlSession session, Map<String,Object> param) {
		return session.selectList("emp.selectKeyList",param);
	}

	@Override
	public List<Map<String, String>> selectEmpList(SqlSession session, int cPage, int numperPage) {
		//마이바티스에서 페이징처리를 하기 위해서
		//RowBounds객채를 이용
		//RowBounds객채를 생성할 때 매개변수로 데이터의 갯수를 설정
		//매개변수 있는 생성자를 이용 (2개의 매개변수를 이용함)
		//1. offset : 자료의 시작을 의미 -> (cPage-1)*numPerPage
		//2. limit : 페이지당 게시물의 갯수 -> numPerPage
		RowBounds row = new RowBounds((cPage-1)*numperPage, numperPage);
		return session.selectList("emp.selectEmpList",null,row);  //매개변수가 없으면 null넣오 됨
	}

	@Override
	public int selectEmpCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("emp.selectEmpCount");
	}
	
	
	
	
	
	
}
