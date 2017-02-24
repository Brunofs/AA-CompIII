package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.UsuarioFinder;
import dados.UsuarioGateway;
import dominio.TMUsuario;
import entidades.Usuario;

/**
 * Servlet implementation class LerUsuario
 */
@WebServlet("/LerUsuario")
public class LerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LerUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String email = request.getParameter("email");
				UsuarioGateway userEncontrado= UsuarioFinder.recuperaUsuarioPorEmail(email);
				TMUsuario novo = new TMUsuario();
				Usuario aux;
				
				if(userEncontrado==null){
					throw new IllegalArgumentException("Você não esta convidado!");
				}
				
				try {
					aux = novo.RecuperaUsuario(userEncontrado.getId());
					Cookie idLogado= new Cookie("idLogado",""+aux.getId());
					response.addCookie(idLogado);
					
					request.setAttribute("Usuario",aux);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				request.getRequestDispatcher("usuario/Usuario.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
