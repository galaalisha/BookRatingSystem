package swe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import swe.ConnectionManager;
import swe.DAO;
import swe.ValidBean;
/**
 * Servlet implementation class Form
 */
@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Form() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		DAO sd = new DAO();
		ValidBean bean = sd.getInfo(email, password);
		if(bean.isValid())
		{
			System.out.println("Valid User");
			RequestDispatcher rd = request.getRequestDispatcher("indexold.html");
        	rd.forward(request, response);
		}
		
		else
		{
			System.out.println("InValid User");
			RequestDispatcher rd = request.getRequestDispatcher("formtb.html");
        	rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Helo");
		try
		{
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
	    ValidBean declira = new ValidBean();
		
	    declira.setEmail(email);
	    declira.setPassword(password);
		
	    DAO.save(declira);
	    System.out.println("done");
		
		RequestDispatcher rd = request.getRequestDispatcher("logn.html");
    	rd.forward(request, response);
		
		
		
		
		}
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		/*if(email=="admin" && password=="admin")
		{
			RequestDispatcher rd = request.getRequestDispatcher("2.html");
        	rd.forward(request, response);
		}*/
	}

}
