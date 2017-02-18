package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.TMCarona;
import dominio.TMGrupo;
import dominio.TMParada;
import dominio.TMUsuario;
import dominio.TMVeiculo;
import entidades.Grupo;
import entidades.Usuario;
import entidades.Veiculo;
import excecoes.ConexaoException;
import excecoes.emailInvalido;
import excecoes.usuarioJaCadastradoaCarona;
import javafx.scene.chart.PieChart.Data;

/**
 * Servlet implementation class CriarCarona
 */
@WebServlet("/CriarCarona")
public class CriarCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarCarona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TMCarona carona = new TMCarona();
		TMVeiculo veiculo = new TMVeiculo();
		long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
		request.setAttribute("Usuario", request.getParameter("idUsuario"));
		request.setAttribute("Grupo", request.getParameter("idGrupo"));
		try {
			request.setAttribute("Veiculos", veiculo.RecuperaTodosVeiculosDoUsuario(idUsuario));
			request.setAttribute("Logradouros", carona.RecuperaLogradouros(idUsuario));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		request.getRequestDispatcher("carona/CriarCarona.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
		long idGrupo = Long.parseLong(request.getParameter("idGrupo"));
		long idVeiculo = Long.parseLong(request.getParameter("idVeiculo"));
		String data = (String) request.getParameter("dia");
		String horarioSaida = (String) request.getParameter("horarioSaida");
		int numVagas = Integer.parseInt(request.getParameter("numVagas"));
		String logOrigem = request.getParameter("logOrigem");
		String logDestino = request.getParameter("logDestino");
		
		TMCarona carona = new TMCarona();
		long idCarona = 0;
		try {
			idCarona = carona.CriarCarona(idUsuario,idGrupo,idVeiculo,data,horarioSaida,numVagas,(long)99,(long)99);
		} catch (ClassNotFoundException | ConexaoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TMParada parada = new TMParada();
		
		if(logOrigem.equals("adc-ori")){
			String cep =  request.getParameter("cep-ori");
			String endereco =  request.getParameter("endereco-ori");
			Integer complemento = Integer.parseInt(request.getParameter("complemento-ori"));
			String bairro =  request.getParameter("bairro-ori");
			String cidade =  request.getParameter("cidade-ori");
			String estado =  request.getParameter("estado-ori");
			logOrigem = "99";
			try {
				parada.CriarParadaN(cep, endereco, complemento, bairro, cidade, estado, idUsuario, idCarona);
			} catch (ClassNotFoundException | ConexaoException | SQLException | usuarioJaCadastradoaCarona
					| emailInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				parada.CriarParadaN(idUsuario,idCarona,Long.parseLong(logOrigem));
			} catch (NumberFormatException | ClassNotFoundException | ConexaoException | SQLException
					| usuarioJaCadastradoaCarona | emailInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(logDestino.equals("adc-dest")){
			String cep =  request.getParameter("cep-dest");
			String endereco =  request.getParameter("endereco-dest");
			Integer complemento = Integer.parseInt(request.getParameter("complemento-dest"));
			String bairro =  request.getParameter("bairro-dest");
			String cidade =  request.getParameter("cidade-dest");
			String estado =  request.getParameter("estado-dest");
			logDestino = "99";
			try {
				parada.CriarParadaN(cep, endereco, complemento, bairro, cidade, estado, idUsuario, idCarona);
			} catch (ClassNotFoundException | ConexaoException | SQLException | usuarioJaCadastradoaCarona
					| emailInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				parada.CriarParadaN(idUsuario,idCarona,Long.parseLong(logDestino));
			} catch (NumberFormatException | ClassNotFoundException | ConexaoException | SQLException
					| usuarioJaCadastradoaCarona | emailInvalido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		doGet(request, response);
	}

}
