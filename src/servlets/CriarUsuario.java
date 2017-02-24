package servlets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.beans.finder.FieldFinder;

import dados.UsuarioFinder;
import dados.UsuarioGateway;
import dominio.TMUsuario;
import excecoes.ConexaoException;
import excecoes.EmailInvalida;
import excecoes.campoInvalida;

import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class CriarUsuario
 */
@WebServlet("/CriarUsuario")
public class CriarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("CriarUsuarios.jsp").forward(request, response);
		
		
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		String nome = (String) request.getParameter("nome");
		String email = (String) request.getParameter("email");
		String telefone = (String) request.getParameter("telefone");
		UsuarioFinder.recuperaUsuarioPorEmail(email);
		UsuarioGateway userCriacao =new  UsuarioGateway(nome,email,telefone);
		TMUsuario user = new TMUsuario();
		long ret=user.CriarUsuario(userCriacao);
		
		if(ret!=-1){
			request.getRequestDispatcher("/").forward(request, response);
		}else{
			request.getRequestDispatcher("/erro666.jsp").forward(request, response);
		}
	}
}
