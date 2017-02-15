package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.TMParada;
import excecoes.ConexaoException;
import excecoes.emailInvalido;
import excecoes.usuarioJaCadastradoaCarona;

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
		long idCarona= Long.parseLong(request.getParameter("idCarona"));
		String cep =  request.getParameter("cep");
		String endereco =  request.getParameter("endereco");
		Integer complemento = Integer.parseInt(request.getParameter("complemento"));
		String bairro =  request.getParameter("bairro");
		String cidade =  request.getParameter("cidade");
		String estado =  request.getParameter("estado");
		
		TMParada par = new TMParada();
		try {
			par.CriarParada(cep, endereco, complemento,bairro,cidade,estado, emailConvidado,idCarona);
		} catch (ClassNotFoundException | ConexaoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (usuarioJaCadastradoaCarona e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (emailInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
