package com.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.EmployeeService;
import com.mybatis.model.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmpSearchKeyServlet
 */
@WebServlet("/searchKeyList")
public class EmpSearchKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private EmployeeService service = new EmployeeServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearchKeyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String type = request.getParameter("searchType");
		String key = request.getParameter("searchKeyword");
		String gender = request.getParameter("gender");
		String salary = request.getParameter("salary");
		String salaryFlag = request.getParameter("salary_le_ge");
		String[] jobs = request.getParameterValues("job_code");
		
		Map<String,Object> param = new HashMap();
		param.put("type", type);
		param.put("key",key);
		param.put("gender",gender);
		param.put("salary", salary);
		param.put("flag", salaryFlag);
		param.put("jobs", jobs);
		
		List<Map<String,String>> list = service.selectKeyList(param);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/empList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
