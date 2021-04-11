package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Album;
import model.JDBC;

/**
 * Servlet implementation class Connexion
 */

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 response.setContentType("text/html");
		 String error = new String("label.def");
	     try {
			JDBC jdbc =new JDBC();
			if(jdbc.connexion(request.getParameter("email"), request.getParameter("mdp")))  {
				Cookie cookie = new Cookie("cookie_tp_mvc", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				Cookie cookie2 = new Cookie("cookie_tp_mvc", request.getParameter("email"));
				response.addCookie(cookie2);
					
					
				request.getRequestDispatcher("acceuil.jsp").forward(request, response);
			}
			else {
				error = "label.elogin";
				request.setAttribute("error", error);
				request.getRequestDispatcher("connecter.jsp").forward(request, response);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
