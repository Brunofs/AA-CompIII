package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.TMUsuario;
import dominio.TMVeiculo;
import entidades.Usuario;
import entidades.Veiculo;

/**
 * Servlet implementation class SolicitarInformacoes
 */
@WebServlet("/SolicitarInformacoes")
public class SolicitarInformacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitarInformacoes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				long id= Long.parseLong(request.getParameter("idVeiculo"));
				
				try {
					Veiculo vei;
					vei = TMVeiculo.RecuperaVeiculo(id);
					Usuario user;
					user = TMUsuario.RecuperaUsuario(vei.getIdUser());
					request.setAttribute("Usuario",user);
			
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			request.getRequestDispatcher("./LerDadosUsuario.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
