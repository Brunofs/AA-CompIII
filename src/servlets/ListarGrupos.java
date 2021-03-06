package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.UsuarioGateway;
import dominio.TMGrupo;
import dominio.TMUsuario;
import entidades.Grupo;
import entidades.Usuario;

/**
 * Servlet implementation class ListarGrupos
 */
@WebServlet("/ListarGrupos")
public class ListarGrupos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarGrupos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		List<Grupo> grupo = new ArrayList<Grupo>();
		TMGrupo aux = new TMGrupo();
		TMUsuario auxU = new TMUsuario();
		try {
			grupo =  aux.RecuperaTodosGruposDoUsuario(id);
			Usuario  user = auxU.RecuperaUsuario(id);
			request.setAttribute("Grupo", grupo);
			request.setAttribute("Usuario", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("grupo/ListarGrupos.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
