package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.GrupoGateway;
import dominio.TMGrupo;
import entidades.Grupo;

/**
 * Servlet implementation class ConvidarUsuario
 */
@WebServlet("/ConvidarUsuario")
public class ConvidarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvidarUsuario() {
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
				Grupo aux;
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
		long idGrupo = Long.parseLong(request.getParameter("id"));
		String emailConvidado = request.getParameter("email");
		TMGrupo novo =new  TMGrupo();
		novo.convidarUsuario(emailConvidado, idGrupo);
		doGet(request, response);
	}

}
