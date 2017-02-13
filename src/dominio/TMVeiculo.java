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
import excecoes.ConexaoException;

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
		System.out.println("@#@"+veiculo.getCor());
		try {
			veiculo.alterarVeiculo();
		} catch (ClassNotFoundException | ConexaoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<VeiculoGateway> RecuperaTodosVeiculosDoUsuario(long userId) throws Exception{
		Collection<VeiculoGateway> veiculoGateway = VeiculoFinder.listarTodosDesseUsuario(userId);
		ArrayList<VeiculoGateway> vei = new ArrayList<VeiculoGateway>();
		
		for(VeiculoGateway v : veiculoGateway){
			VeiculoGateway veiculo = new VeiculoGateway(v.getModelo(), v.getPlaca(), v.getCor());
			veiculo.setId(v.getId());
			vei.add(veiculo);
		}
		
		return (List<VeiculoGateway>) vei;
	}
	
	public static VeiculoGateway RecuperaVeiculo(long veiculoId) throws Exception{
		if(veiculoId <0){
			throw new IllegalArgumentException("id");
		}
		
		VeiculoGateway v = VeiculoFinder.recuperaPorId(veiculoId);
		return v;
	}	
	
}
