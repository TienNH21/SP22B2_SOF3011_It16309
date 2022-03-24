package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import beans.form_data.RegisterData;
import dao.UserDAO;
import entities.User;
import utils.JpaUtil;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

    public RegisterServlet() {
        super();
        this.userDAO = new UserDAO();
    }

    protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
    	request.getRequestDispatcher("/views/register.jsp")
    		.forward(request, response);
	}
    
    protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
    	User entity = new User();
    	try {
    		BeanUtils.populate(entity, request.getParameterMap());
    		this.userDAO.create(entity);
    		// Thông báo thành công
    	} catch (Exception e) {
    		e.printStackTrace();
    		// Thông báo thất bại
    	}

	}
}
