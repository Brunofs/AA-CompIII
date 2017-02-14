package dominio;

import java.sql.SQLException;
import java.util.List;

import dados.CaronaFinder;
import dados.CaronaGateway;
import dados.LogradouroFinder;
import dados.LogradouroGateway;
import dados.ParadaFinder;
import dados.ParadaGateway;
import dados.UsuarioFinder;
import dados.UsuarioGateway;
import excecoes.ConexaoException;

public class TMParada {
	
	public static void CriarParada(String cep, String estado, String cidade, String distrito, String endereco,
			Integer numero,String email, long idCarona) throws ClassNotFoundException, ConexaoException, SQLException{
		
		UsuarioGateway userR = UsuarioFinder.recuperaUsuarioPorEmail(email);
		CaronaGateway carR = CaronaFinder.recuperaPorId(idCarona);
		List<ParadaGateway> paradas = ParadaFinder.listarTodosPorCarona(idCarona);
		
		if(paradas.size()-2>=carR.getNumVagas()){
			
		}
		
		LogradouroGateway logR = LogradouroFinder.recuperaLogradouro(cep, numero);
		if(logR==null){
			logR = new LogradouroGateway(cep,estado,cidade,distrito,endereco,numero);
		}
		
		ParadaGateway parada = new ParadaGateway(userR.getId(),logR.getId(),idCarona);
		parada.salvarParada();
	}

}
