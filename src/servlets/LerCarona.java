package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.TMCarona;
import dominio.TMGrupo;
import dominio.TMUsuario;
import entidades.Carona;
import entidades.Grupo;
import entidades.Usuario;

/**
 * Servlet implementation class LerCarona
 */
@WebServlet("/LerCarona")
public class LerCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LerCarona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idCarona = Long.parseLong(request.getParameter("idCarona"));
		long idUser  = Long.parseLong(request.getParameter("idUsuario"));
		TMCarona aux = new TMCarona();
		try {
			Carona carona = aux.RecuperaCarona(idCarona);
			request.setAttribute("Carona",carona);
			request.setAttribute("Usuario",request.getParameter("idUsusuario"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("carona/Carona.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
