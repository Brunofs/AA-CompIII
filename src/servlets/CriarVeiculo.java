package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.UsuarioFinder;
import dados.UsuarioGateway;
import dominio.TMGrupo;
import dominio.TMVeiculo;
import excecoes.ConexaoException;

/**
 * Servlet implementation class CriarVeiculo
 */
@WebServlet("/CriarVeiculo")
public class CriarVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarVeiculo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idd = request.getParameter("id");
		long id= Long.parseLong(idd);
		UsuarioGateway aux = UsuarioFinder.recuperaUsuario(id);
		request.setAttribute("Usuario",aux);
		request.getRequestDispatcher("veiculo/CriarVeiculo.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelo = request.getParameter("modelo");
		String placa = request.getParameter("placa");
		String cor = request.getParameter("cor");		
		long idUser = Long.parseLong(request.getParameter("id"));
		
		TMVeiculo novo = new TMVeiculo();
		try {
			novo.CriarVeiculo(idUser,modelo,placa,cor);
		} catch (NumberFormatException | ClassNotFoundException | ConexaoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/").forward(request,response);
	}

}
