package com.mybatis.model.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	
	List<Map<String,String>> selectList();
	
//	List<Map<String,String>> selectKeyList(Map<String,String> param);
	List<Map<String,String>> selectKeyList(Map<String,Object> param);
	
	//페이징 처리
	List<Map<String, String>> selectEmpList(int cPage,int numperPage);
	int selectEmpCount();
}
