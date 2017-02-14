package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.TMGrupo;
import dominio.TMUsuario;
import entidades.Grupo;
import entidades.Usuario;

/**
 * Servlet implementation class LerGrupo
 */
@WebServlet("/LerGrupo")
public class LerGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LerGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idGrupo = Long.parseLong(request.getParameter("id"));
		long idUser  = Long.parseLong(request.getParameter("idUser"));
		TMGrupo aux = new TMGrupo();
		TMUsuario user = new TMUsuario();
		try {
			Grupo grupo = aux.RecuperaGrupo(idGrupo);
			Usuario userD = user.RecuperaUsuario(idUser);
			request.setAttribute("Grupo",grupo);
			request.setAttribute("Usuario",userD);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("grupo/Grupo.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
