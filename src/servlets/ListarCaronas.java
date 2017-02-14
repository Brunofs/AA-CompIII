package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ListarCaronas
 */
@WebServlet("/ListarCaronas")
public class ListarCaronas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCaronas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long idGrupo = Long.parseLong(request.getParameter("idGrupo"));
		long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
		List<Carona> caronas = new ArrayList<Carona>();
		TMCarona aux = new TMCarona();
		try {
			caronas =  aux.RecuperaTodasCaronasDoGrupo(idGrupo,idUsuario);
			request.setAttribute("Caronas", caronas);
			request.setAttribute("idUsuario", request.getParameter("idUsuario"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("carona/ListarCaronas.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
