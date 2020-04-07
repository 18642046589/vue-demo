package com.neuedu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.pojo.ResponseBean;
import com.neuedu.pojo.SysRole;
import com.neuedu.service.IRoleService;
import com.neuedu.service.impl.RoleServiceImpl;
import com.neuedu.utils.UUIDUtil;

/**
 * Servlet implementation class AddRoleServlet
 */
@WebServlet("/addRole")
public class AddRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roleName=request.getParameter("roleName");
		String roleSort=request.getParameter("roleSort");
		String status=request.getParameter("status");
		String menuids=request.getParameter("menuids");
		String[] menuArray=menuids.split(",");
		
		//拼装对象
		String roleId=UUIDUtil.generateUUID();
		SysRole obj=new SysRole();
		obj.setRoleId(roleId);
		obj.setRoleName(roleName);
		obj.setRoleSort(roleSort);
		obj.setStatus(status);
		obj.setDelFlag("0");
		//传给servcie进行存储
		IRoleService rs=new RoleServiceImpl();
		ResponseBean rb = null;
	    rb = rs.save(obj,menuArray);
		ObjectMapper om=new ObjectMapper();
		String json=om.writeValueAsString(rb);
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
