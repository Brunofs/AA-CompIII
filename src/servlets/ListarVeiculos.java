package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.GrupoGateway;
import dados.VeiculoGateway;
import dominio.TMGrupo;
import dominio.TMVeiculo;
import entidades.Veiculo;

/**
 * Servlet implementation class ListarVeiculos
 */
@WebServlet("/ListarVeiculos")
public class ListarVeiculos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarVeiculos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));

		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		TMVeiculo aux = new TMVeiculo();
		try {
			veiculos =  aux.RecuperaTodosVeiculosDoUsuario(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("Veiculos", veiculos);
		request.getRequestDispatcher("veiculo/ListarVeiculos.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
