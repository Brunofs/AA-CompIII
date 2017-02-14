package dominio;

import java.sql.SQLException;

import dados.CaronaGateway;
import dados.UsuarioGateway;
import excecoes.ConexaoException;

public class TMCarona {
	
	public static Long CriarCarona(String nome,String email,String telefone) throws ClassNotFoundException, ConexaoException, SQLException{
		if(nome == null || nome.isEmpty()){
			throw new IllegalArgumentException("nome");
		}
		
		if(email == null || email.isEmpty()){
			throw new IllegalArgumentException("email");
		}
		
		if(telefone == null || telefone.isEmpty()){
			throw new IllegalArgumentException("telefone");
		}
		
		UsuarioGateway usuario = new UsuarioGateway(nome, email, telefone);
		usuario.salvarUsuario();
		long id = usuario.getId();
		return id;
	}

	public void CriarCarona( long idGrupo, long idVeiculo, String data, String horarioSaida, int numVagas,	long logOrigem, long logDestino) throws ClassNotFoundException, ConexaoException, SQLException {
		System.out.println("DSAASSADD");
		
		CaronaGateway caronaGate = new CaronaGateway(idGrupo,idVeiculo,data,horarioSaida,numVagas,logOrigem,logDestino);
		caronaGate.salvarUsuario();
	}

}
