package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.UsuarioGateway;
import dados.VeiculoGateway;
import dominio.TMGrupo;
import dominio.TMUsuario;
import dominio.TMVeiculo;
import excecoes.ConexaoException;

/**
 * Servlet implementation class AlterarVeiculo
 */
@WebServlet("/AlterarVeiculo")
public class AlterarVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarVeiculo() {
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
				
				TMVeiculo novo = new TMVeiculo();
				VeiculoGateway aux;
				try {
					aux = novo.RecuperaVeiculo(id);
					request.setAttribute("Veiculo",aux);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("veiculo/AlterarVeiculo.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TMVeiculo veiculo = new TMVeiculo();
		long id = Long.parseLong(request.getParameter("id"));
		long usuario_id = Long.parseLong(request.getParameter("usuario_id"));
		String cor = request.getParameter("cor");
		try {
			veiculo.AlterarVeiculo(id,usuario_id,cor);
		} catch (NumberFormatException | ClassNotFoundException | SQLException | ConexaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/").forward(request,response);

	}
}
