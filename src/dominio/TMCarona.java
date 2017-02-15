package dominio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dados.CaronaFinder;
import dados.CaronaGateway;
import dados.GrupoFinder;
import dados.GrupoGateway;
import dados.LogradouroFinder;
import entidades.Carona;
import entidades.Grupo;
import excecoes.ConexaoException;

public class TMCarona {
	

	public void CriarCarona(long idUsuario, long idGrupo, long idVeiculo, String data, String horarioSaida, int numVagas,	long logOrigem, long logDestino) throws ClassNotFoundException, ConexaoException, SQLException {
		
		
		CaronaGateway caronaGate = new CaronaGateway(idGrupo,idVeiculo,data,horarioSaida,numVagas,logOrigem,logDestino);
		caronaGate.salvarCarona();
	}
	
	
	public static List<Carona> RecuperaTodasCaronasDoGrupo(long idGrupo,long idUsuario) throws Exception{
		
		Collection<CaronaGateway> caronaGateway = CaronaFinder.listarTodosPorGrupo(idGrupo);
		ArrayList<Carona> caronas = new ArrayList<Carona>();
		
		for(CaronaGateway c : caronaGateway){
			Carona carona = new Carona(c.getIdCarona(),c.getData(),c.getHorarioSaida(),c.getNumVagas(),c.getIdVeiculo(),c.getIdGrupo(),c.getLogOrigem(),c.getLogDestino());
			caronas.add(carona);
		}
		
		return (List<Carona>) caronas;
	}
	
	public static Carona RecuperaCarona(long caronaId) throws Exception{
		if(caronaId <0){
			throw new IllegalArgumentException("id");
		}
		CaronaGateway c = CaronaFinder.recuperaPorId(caronaId);
		Carona cRet =  new Carona(c.getIdCarona(),c.getData(),c.getHorarioSaida(),c.getNumVagas(),c.getIdVeiculo(),c.getIdGrupo(),c.getLogOrigem(),c.getLogDestino());
		return cRet;
}

}
