package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReservarCarona
 */
@WebServlet("/ReservarCarona")
public class ReservarCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservarCarona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailConvidado = request.getParameter("emailConvidado");
		long idVeiculo = Long.parseLong(request.getParameter("idVeiculo"));
		String CEP =  request.getParameter("cep");
		String endereco =  request.getParameter("endereco");
		String complemento =  request.getParameter("complemento");
		String bairro =  request.getParameter("bairro");
		String cidade =  request.getParameter("cidade");
		String estado =  request.getParameter("estado");
		
		
	}

}
