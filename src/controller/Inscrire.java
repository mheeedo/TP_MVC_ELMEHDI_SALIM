package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.JDBC;

/**
 * Servlet implementation class Inscrire
 */

public class Inscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String reg_email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	String reg_nom="[A-Za-z ]+";
	String reg_cp="[0-9 ]+";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscrire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 try {
			 JDBC jdbc = new JDBC();
			 boolean temp = false;
		
			String nom = new String("label.enom");
		
			String ville = new String("label.eville");
			String prenom = new String("label.eprenom");
			String email = new String("label.eemail1");
		
			String codepostal = new String("label.ecodepostal");
			if(!request.getParameter("nom").matches(reg_nom)) {
				request.setAttribute("nom", nom);
				temp = true;
			 }
			if(!request.getParameter("prenom").matches(reg_nom)) {
				request.setAttribute("prenom", prenom);
				temp = true;
			 }
			if(!request.getParameter("ville").matches(reg_nom)) {
				request.setAttribute("ville", ville);
				temp = true;
			 }
			if(!request.getParameter("codepostal").matches(reg_cp)) {
				request.setAttribute("codepostal", codepostal);
				temp = true;
			 }
			if(!request.getParameter("email").matches(reg_email)) {
				
				request.setAttribute("email", email);
				temp = true;
			 }
		if(temp == true || (jdbc.validate_email(request.getParameter("email")) && request.getParameter("email").matches(reg_email) )) {
			if(jdbc.validate_email(request.getParameter("email")) && request.getParameter("email").matches(reg_email) ) {
				email = "label.eemail2";
				request.setAttribute("email", email);
				
			}
			request.getRequestDispatcher("inscrire.jsp").forward(request, response);
			
		}else {
			
			
			jdbc.inscription(request.getParameter("email").trim(),
					request.getParameter("nom").trim(),
					request.getParameter("prenom").trim(),
					request.getParameter("adresse").trim(),
					Integer.parseInt(request.getParameter("codepostal").trim().replaceAll("\\s+","")), 
					request.getParameter("ville").trim(),
					request.getParameter("mdp").trim());
			Cookie cookie = new Cookie("cookie_tp_mvc", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			Cookie cookie2 = new Cookie("cookie_tp_mvc", request.getParameter("email"));
			response.addCookie(cookie2);
			request.getRequestDispatcher("acceuil.jsp").forward(request, response);
			
			
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
