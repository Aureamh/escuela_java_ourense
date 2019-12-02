package com.vn.appusuarios.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Descriptores de servles
@WebServlet({ "/saludo", "/otraurl" })
public class SaludoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);

		String nombre = req.getParameter("nombre");
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>" + nombre);
		Cookie[] todasCookies = req.getCookies();
		Cookie nombreCookie;
		if (todasCookies.length == 0) {

			nombreCookie = new Cookie("nombre_cookie ", " Valor de la cookie " + nombre);
			nombreCookie.setMaxAge(4600);
		} else {
			nombreCookie = todasCookies[0];	
		}
		System.out.println("Cookie desde navegador: " + todasCookies[0].getValue());
		if(todasCookies.length >0) {
			System.out.println("Cookie desde navegador: " + todasCookies[1].getValue());
		}
		
		resp.addCookie(nombreCookie);
		resp.getWriter().println("<div id='divC'></div>");
		resp.getWriter().println("<script>");
		resp.getWriter().println("document.getElementById('divC').innerHTML=document.cookie;");
		resp.getWriter().println("document.cookie='nombre_coockie=\"Modificada en JS: \" '; ");
		resp.getWriter().println("</script></body></html>");

	}

}
