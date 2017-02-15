package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import dominio.TMCarona;
import dominio.TMGrupo;
import dominio.TMUsuario;
import entidades.Grupo;
import entidades.Usuario;
import excecoes.ConexaoException;
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
		long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
		request.setAttribute("Usuario", request.getParameter("idUsuario"));
		request.setAttribute("Grupo", request.getParameter("idGrupo"));
		try {
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
		long logOrigem = Long.parseLong(request.getParameter("logOrigem"));
		long logDestino = Long.parseLong(request.getParameter("logDestino"));
		
		TMCarona carona = new TMCarona();
		
		try {
			carona.CriarCarona(idUsuario,idGrupo,idVeiculo,data,horarioSaida,numVagas,logOrigem,logDestino);
		} catch (ClassNotFoundException | ConexaoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
