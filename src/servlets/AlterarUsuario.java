package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.UsuarioGateway;
import dominio.TMUsuario;
import entidades.Usuario;
import excecoes.ConexaoException;

/**
 * Servlet implementation class AlterarUsuario
 */
@WebServlet("/AlterarUsuario")
public class AlterarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idd = request.getParameter("id");
		long id= Long.parseLong(idd);
		TMUsuario novo = new TMUsuario();
		Usuario aux;
		try {
			aux = novo.RecuperaUsuario(id);
			request.setAttribute("Usuario",aux);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("./AlterarUsuario.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idd = (String) request.getParameter("id");
		long id= Long.parseLong(idd);
		String nome = request.getParameter("nome");
		String telefone =  request.getParameter("telefone");
		TMUsuario aux = new TMUsuario();
		aux.alterarUsuario(id,nome,telefone);
		request.getRequestDispatcher("/").forward(request,response);

	}

}
