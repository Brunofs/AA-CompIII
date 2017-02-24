package servlets; 
import dados.GrupoGateway;
import dados.UsuarioGateway;
import dominio.TMGrupo;
import dominio.TMUsuario;
import entidades.Usuario;
import dados.UsuarioFinder;
import excecoes.ConexaoException;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CriarGrupo
 */
@WebServlet("/CriarGrupo")
public class CriarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("idUsuario",request.getParameter("id"));
		request.getRequestDispatcher("grupo/CriarGrupo.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TMGrupo novo = new TMGrupo();
		long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
		String nome = request.getParameter("nome");
		String descricao =request.getParameter("descricao");
		String regras =request.getParameter("regras");
		int limite = Integer.parseInt(request.getParameter("limite"));
		try {
			long idGrupo=novo.CriarGrupo(idUsuario,nome,descricao,regras,limite);
			request.getRequestDispatcher("./LerGrupo?id="+idGrupo+"&idUser="+idUsuario).forward(request,response);

		} catch (NumberFormatException | ClassNotFoundException | ConexaoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
