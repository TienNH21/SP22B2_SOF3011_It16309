package controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entities.Category;
import entities.User;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

    public CategoryServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();
		request.setAttribute("dsUser", ds);
		request.getRequestDispatcher(
			"/views/admin/categories/create.jsp"
		).forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String ten = request.getParameter("ten");
		int userId = Integer.parseInt(
			request.getParameter("user_id")
		);
		
		User user = this.userDAO.findById(userId);
		System.out.println( user.getCategories().size() );
		Category cate = new Category();
		cate.setTen(ten);
		cate.setUser(user);
		
		// TODO: this.categoryDAO.create(cate);
	}
}
