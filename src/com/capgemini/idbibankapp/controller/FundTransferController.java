package com.capgemini.idbibankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.idbibankapp.exceptions.NegetiveBalanceException;
import com.capgemini.idbibankapp.exceptions.UserNotFoundException;
import com.capgemini.idbibankapp.model.BankAccount;
import com.capgemini.idbibankapp.model.Customer;
import com.capgemini.idbibankapp.service.BankAccountService;
import com.capgemini.idbibankapp.service.CustomerService;
import com.capgemini.idbibankapp.service.impl.BankAccountServiceImpl;
import com.capgemini.idbibankapp.service.impl.CustomerServiceImpl;

@WebServlet("/fundtransfer.do")
public class FundTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private CustomerService service;
	BankAccountService bankAccountService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		bankAccountService = new BankAccountServiceImpl();
		context = config.getServletContext();
		service = (CustomerService) context.getAttribute("service");
	}

	public FundTransferController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		long toAccount = Long.parseLong(request.getParameter("toAccount"));
		long amount = Long.parseLong(request.getParameter("amount"));
		context.setAttribute("bankService", bankAccountService);
//		String bank = request.getParameter("bank");

		Customer customer = (Customer) session.getAttribute("customer");
		request.setAttribute("success", false);

//		System.out.println(bank);

		// request.getParameter("narrator");
//		if (bank.equals("safe")) {

			try {
				bankAccountService.fundTransfer(customer.getAccount().getAccountId(), toAccount, amount);
				customer.setAccount(new BankAccount(customer.getAccount().getAccountId(),customer.getAccount().getAccountType(),bankAccountService.getBalance(customer.getAccount().getAccountId())));
				session.setAttribute("customer", customer);
				
				request.setAttribute("success", true);
				RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
				dispatcher.forward(request, response);

			} catch (NegetiveBalanceException | UserNotFoundException e) {
				// TODO Auto-generated catch block
				request.setAttribute("success", false);
				request.setAttribute("error", e.toString());
				RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
				dispatcher.forward(request, response);
				e.printStackTrace();
			}
		}


}
