package com.capgemini.idbibankapp.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.idbibankapp.exceptions.NegetiveBalanceException;
import com.capgemini.idbibankapp.exceptions.UserNotFoundException;
import com.capgemini.idbibankapp.service.BankAccountService;

@WebServlet("/sendmoney")
public class GetMoneyApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private BankAccountService service;

	public GetMoneyApiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
		service = (BankAccountService) context.getAttribute("bankAccountService");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long accountId = Long.parseLong(request.getParameter("accountid"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		String redirectUrl = request.getParameter("url");

		try {
			service.withdraw(accountId, amount);
			response.sendRedirect(redirectUrl + "?success=true");
		} catch (UserNotFoundException | NegetiveBalanceException e) {
			PrintWriter out = response.getWriter();
			out.println("Error:" + e.toString());
		}
	}

}
