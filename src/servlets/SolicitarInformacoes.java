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
				TMVeiculo novo = new TMVeiculo();
				Veiculo vei = novo.RecuperaVeiculo(id);
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
		doGet(request, response);
	}

}
