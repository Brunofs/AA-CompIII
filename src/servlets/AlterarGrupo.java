package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.GrupoGateway;
import dados.UsuarioGateway;
import dominio.TMGrupo;
import dominio.TMUsuario;
import excecoes.ConexaoException;

/**
 * Servlet implementation class AlterarGrupo
 */
@WebServlet("/AlterarGrupo")
public class AlterarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarGrupo() {
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
		TMGrupo novo = new TMGrupo();
		GrupoGateway aux;
		try {
			aux = novo.RecuperaGrupo(id);
			request.setAttribute("Grupo",aux);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("grupo/AlterarGrupo.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TMGrupo novo = new TMGrupo();
		long idUser = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String descricao =request.getParameter("descricao");
		int limite = Integer.parseInt(request.getParameter("limite"));
		try {
			novo.AlterarGrupo(idUser,nome,descricao,limite);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request,response);
	}

}
