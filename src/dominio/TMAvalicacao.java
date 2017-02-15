package dominio;

import java.sql.SQLException;

import dados.AvaliacaoGateway;
import dados.CaronaGateway;
import excecoes.ConexaoException;

public class TMAvalicacao {
	public void CriaAvalicao(long idUsuario, long avaliacao) throws ClassNotFoundException, ConexaoException, SQLException {
		AvaliacaoGateway av = new AvaliacaoGateway(idUsuario,avaliacao);
		av.salvarAvalicao();
	}
}
