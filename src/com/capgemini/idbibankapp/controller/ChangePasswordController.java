package com.capgemini.idbibankapp.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.idbibankapp.model.Customer;
import com.capgemini.idbibankapp.service.CustomerService;
import com.capgemini.idbibankapp.service.impl.CustomerServiceImpl;

@WebServlet("/changePassword.do")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private CustomerService service;

	public ChangePasswordController() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
		service = (CustomerService) context.getAttribute("service");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		HttpSession session = request.getSession();
		//
		request.setAttribute("success", false);
		Customer customer = (Customer) session.getAttribute("customer");
		if (confirmPassword.equals(newPassword)) {
			boolean done = service.updatePassword(customer, oldPassword, newPassword);
			if (done) {
				request.setAttribute("success", true);
				RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("success", false);
				request.setAttribute("error", "Old password error");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
				dispatcher.forward(request, response);
			}
			
		}
	}

}