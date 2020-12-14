package com.mybatis.controller;

import java.io.IOException;
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
 * Servlet implementation class SelectEmployeeListServlet
 */
@WebServlet("/selectList")
public class SelectEmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeService service = new EmployeeServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectEmployeeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Map방식 사용 (나중이 일반 list로도 해봐야 함)
		List<Map<String,String>> list = service.selectList();
		
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
