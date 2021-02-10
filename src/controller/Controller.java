package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;


@WebServlet(urlPatterns = {"/Controller", "/main"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//M�todo principal, a requisi��o do index vem direto para c�.
		
		String req = request.getServletPath();
		System.out.println("requisi��o: " + req);
		
		if(req.equals("/main")) {
			this.agenda(request, response);
		}
	}
	
	protected void agenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Envia a dire��o para
		response.sendRedirect("agenda.jsp");
	}

}
