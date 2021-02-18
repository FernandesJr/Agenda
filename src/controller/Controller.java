package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;


@WebServlet(urlPatterns = {"/Controller", "/main", "/insert"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//M�todo principal, a requisi��o do index vem direto para c�.
		
		String req = request.getServletPath();
		System.out.println("requisi��o: " + req);
		
		if(req.equals("/main")) {
			this.agenda(request, response);
		}else if(req.equals("/insert")){
			this.addContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void agenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<JavaBeans> listaContatos = this.dao.listarContatos();
		
		request.setAttribute("contatos", listaContatos); //Incluindo a lista na minha requisi��o
		
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp"); //Despachando a requisi��o para o caminho agenda.jsp 
		rd.forward(request, response); // Passando para a frente de fato, finalizando a requisi��o
		
	}
	
	private void addContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Inserindo um novo contato
		
		// Criando um novo contato -GETPARAMETER par�metros do formul�rio que requisita o servlet-
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		//Adicionar ele no BD
		this.dao.inserirContato(contato);
		
		// Redirecionando para a agenda de contatos
		response.sendRedirect("main");
		
	}

}
