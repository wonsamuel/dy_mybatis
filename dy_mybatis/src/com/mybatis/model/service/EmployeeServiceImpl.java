package com.mybatis.model.service;

import static com.mybatis.common.SqlSessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.EmloyeeDaoImpl;
import com.mybatis.model.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao dao = new EmloyeeDaoImpl();

	@Override
	public List<Map<String, String>> selectList() {
		SqlSession session = getSession();
		List<Map<String, String>> list = dao.selectList(session);
		session.close();
		return list;	
	}

//	@Override
//	public List<Map<String, String>> selectKeyList(Map<String,String> param) {
//		SqlSession session = getSession();
//		List<Map<String, String>> list = dao.selectKeyList(session, param);
//		session.close();
//		return list;	
//	}
	@Override
	public List<Map<String, String>> selectKeyList(Map<String,Object> param) {
		SqlSession session = getSession();
		List<Map<String, String>> list = dao.selectKeyList(session, param);
		session.close();
		return list;	
	}

	@Override
	public List<Map<String, String>> selectEmpList(int cPage, int numperPage) {
		SqlSession session = getSession();
		List<Map<String,String>> list = dao.selectEmpList(session, cPage, numperPage);
		session.close();
		return list;
	}

	@Override
	public int selectEmpCount() {
		SqlSession session = getSession();
		int count = dao.selectEmpCount(session);
		session.close();
		return count;
	}
	
	
	
	
	

}
