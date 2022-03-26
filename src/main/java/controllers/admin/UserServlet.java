package controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import beans.form_data.RegisterData;
import dao.UserDAO;
import entities.User;

@WebServlet({
	"/users/index",
	"/users/show",
	"/users/create",
	"/users/store",
	"/users/edit",
	"/users/update",
	"/users/delete",
})
public class UserServlet extends HttpServlet {
	private UserDAO userDAO;
	
	public UserServlet() {
		this.userDAO = new UserDAO();
	}

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("show")) {
			this.show(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		} else {
			// 404
		}
	}

	private void index(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();
		request.setAttribute("ds", ds);
		request.setAttribute("now", new Date());
		request.setAttribute("view",
			"/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
		
	}

	private void create(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.setAttribute("view",
			"/views/admin/users/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}

	private void store(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		try {
			User entity = new User();
			BeanUtils.populate(entity,
				request.getParameterMap());
			
			this.userDAO.create(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void edit(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
	}

	private void show(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
	}

	private void delete(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String s = request.getParameter("id");
		int id = Integer.parseInt(s);
		User entity = this.userDAO.findById(id);
		this.userDAO.delete(entity);
	}

	private void update(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
	}
}
