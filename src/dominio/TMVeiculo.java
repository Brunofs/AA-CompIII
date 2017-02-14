package dominio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.NameNotFoundException;

import dados.GrupoFinder;
import dados.GrupoGateway;
import dados.UsuarioFinder;
import dados.UsuarioGateway;
import dados.VeiculoFinder;
import dados.VeiculoGateway;
import entidades.Veiculo;
import excecoes.ConexaoException;
import excecoes.usuarioNaoPossuiVeiculos;

public class TMVeiculo {
	
	public static long CriarVeiculo(long userId,String modelo,String placa,String cor) throws ClassNotFoundException, SQLException, ConexaoException{
		if(modelo == null || modelo.isEmpty()){
			throw new IllegalArgumentException("modelo");
		}
		
		if(placa == null || placa.isEmpty()){
			throw new IllegalArgumentException("placa");
		}
		
		if(cor == null || cor.isEmpty()){
			throw new IllegalArgumentException("cor");
		}
		
		VeiculoGateway veiculo = new VeiculoGateway(modelo, placa, cor);
		veiculo.salvarVeiculo(userId);
		long id = veiculo.getId();
		return id;
	}
	
	public static void AlterarVeiculo(long id,long usuario_id,String cor) throws ClassNotFoundException, SQLException, ConexaoException{
		if(id < 0){
			throw new NumberFormatException("id");
		}
		
		if(cor == null || cor.isEmpty()){
			throw new IllegalArgumentException("cor");
		}

		VeiculoGateway veiculo = VeiculoFinder.recuperaPorId(id);
		
		if(usuario_id != veiculo.getUsurio_id()){
			throw new IllegalAccessError("Usuario ID");
		}
		
		veiculo.setCor(cor);
		try {
			veiculo.alterarVeiculo();
		} catch (ClassNotFoundException | ConexaoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<Veiculo> RecuperaTodosVeiculosDoUsuario(long userId) throws Exception{
		Collection<VeiculoGateway> veiculoGateway = VeiculoFinder.listarTodosDesseUsuario(userId);
		ArrayList<Veiculo> vei = new ArrayList<Veiculo>();
		System.out.println("PAss "+ veiculoGateway.size());
		if(veiculoGateway.size()<=0){
			throw new usuarioNaoPossuiVeiculos();
		}
		
		
		for(VeiculoGateway v : veiculoGateway){
			Veiculo veiculo = new Veiculo(v.getId(),v.getModelo(), v.getPlaca(), v.getCor(),v.getUsurio_id());
			vei.add(veiculo);
		}
		
		return (List<Veiculo>) vei;
	}
	
	public static Veiculo RecuperaVeiculo(long veiculoId) throws Exception{
		if(veiculoId <0){
			throw new IllegalArgumentException("id");
		}
		
		VeiculoGateway v = VeiculoFinder.recuperaPorId(veiculoId);
		Veiculo vRest = new Veiculo(v.getId(),v.getModelo(),v.getPlaca(),v.getCor(),v.getUsurio_id());
		return vRest;
	}	
	
}
