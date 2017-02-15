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
import dados.LogradouroGateway;
import dados.VeiculoGateway;
import dados.GrupoGateway;
import dados.LogradouroFinder;
import dados.LogradouroGateway;
import dados.UsuarioFinder;
import dados.UsuarioGateway;
import entidades.Carona;
import entidades.Grupo;
import entidades.Logradouro;
import entidades.Usuario;
import entidades.Veiculo;
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
	
	public static void FinalizarCarona(long idCarona, long idUsuario){
		try {
			List<Veiculo> listVeiculos=TMVeiculo.RecuperaTodosVeiculosDoUsuario(idUsuario);
			Carona carona=RecuperaCarona(idCarona);
			for(Veiculo veiculoi: listVeiculos){
				if(veiculoi.getId()== carona.getIdVeiculo()){
					CaronaGateway novo= CaronaFinder.recuperaPorId(idCarona);
					novo.FinalizarCarona();
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<Logradouro> RecuperaLogradouros(long idUsuario) throws Exception{
		if(idUsuario <0){
			throw new IllegalArgumentException("id");
		}
		
		Collection<LogradouroGateway> logradrouros = LogradouroFinder.recuperaLogarouroPorUser(idUsuario);
		ArrayList<Logradouro> l = new ArrayList<Logradouro>();
		
		for(LogradouroGateway logradrouro : logradrouros){
			Logradouro log = new Logradouro(logradrouro.getId(),logradrouro.getCep(),logradrouro.getEndereco(),logradrouro.getDistrito(),logradrouro.getCidade(),logradrouro.getEstado(), logradrouro.getNumero());
			l.add(log);
		}
		
		return l;
	}
	
	public static List<Usuario> RecuperaUserPorCarona(long idCarona) throws Exception{
		if(idCarona <0){
			throw new IllegalArgumentException("id");
		}
		
		Collection<UsuarioGateway> uList = UsuarioFinder.recuperaUsuariosPorCarona(idCarona);
		ArrayList<Usuario> us = new ArrayList<Usuario>();
		
		for(UsuarioGateway user : uList){
			Usuario u = new Usuario(user.getId(),user.getNome(),user.getEmail(),user.getTelefone());
			us.add(u);
		}
		
		return us;
	}

}
