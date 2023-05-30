package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/jsp/contact")
public class Contact extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String name = request.getParameter("name");
//		request.setAttribute("name", name);
//		
//		String campany = request.getParameter("campany");
//		request.setAttribute("campany", campany);
//		
//		String mail = request.getParameter("mail");
//		request.setAttribute("mail", mail);
		
		
//		String inquiry = request.getParameter("inquiry");
//		request.setAttribute("inquiry", inquiry);
		
		String[] merumagas = request.getParameterValues("merumaga");
		String merumaga = "";
		if(merumagas != null) {
		for(String meru : merumagas) {
			merumaga = merumaga + meru + " ";	
		}
		request.setAttribute("merumaga", merumaga);
		}else{
		 String nasi = "ご希望のメルマガはありません";
		 request.setAttribute("merumaga", nasi);
		}
		
		String siryou = request.getParameter("siryou");
		request.setAttribute("siryou", siryou);
		
		if(siryou == "yes"){
			request.getRequestDispatcher("siryouari.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("siryounasi.jsp").forward(request, response);
		}
		
	
		
	}

}
