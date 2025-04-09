package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ItemService.ItemListService;

public class IndexFrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/")) {
		
			ItemListService action = new ItemListService();
			action.excute(request);
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}
