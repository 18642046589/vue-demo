package com.neuedu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.pojo.ResponseBean;

/**
 * Servlet implementation class AddNoticeServlet
 */
@WebServlet("/addNotice")
public class AddNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newsname=request.getParameter("newsName");
		String newscontent=request.getParameter("newscontent");
		String visible=request.getParameter("visible");
		String ordernum=request.getParameter("orderNum");
		
		//校验前台传输的数据是否拿到
		System.out.println("公告名称为"+newsname);
		System.out.println("公告内容"+newscontent);
		System.out.println("公开"+visible);
		System.out.println("显示排序"+ordernum);
		//存库
		
		response.getWriter().print("success");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
