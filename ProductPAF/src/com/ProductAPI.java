package com;

import com.product;
import java.io.IOException; 
import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class PaymentService
*/
@WebServlet("/ProductAPI")
public class ProductAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	product productObj = new product();
   /**
    * @see HttpServlet#HttpServlet()
    */
   public ProductAPI() {
       super();
       // TODO Auto-generated constructor stub
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = productObj.insertProduct(request.getParameter("proCode"),      
				request.getParameter("desc"),
				request.getParameter("qty"),
				request.getParameter("price"), 
				request.getParameter("category")); 
	 
				response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method

		Map paras = getParasMap(request); 
		 
		 String output = productObj.updateProduct(paras.get("hidProductIDSave").toString(),     
		    		paras.get("proCode").toString(),     
		    		paras.get("desc").toString(),
		    		paras.get("qty").toString(),
		    		paras.get("price").toString(),
		    		paras.get("category").toString()); 
		 
		 			response.getWriter().write(output);
	}
	
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request); 
		 
		 String output = productObj.deleteProduct(paras.get("pro_ID").toString());  
		 
		 response.getWriter().write(output);
	}