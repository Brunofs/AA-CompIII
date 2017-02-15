package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeiculoFinder {
	
	
	public static VeiculoGateway recuperaPorId(long id){
		VeiculoGateway veic = new VeiculoGateway();
		
		try {
			Conexao.initConnection();
			String sql = "SELECT * FROM veiculo where id="+id+";";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			if(result.next()) {
				String modelo = result.getString("modelo");
				String placa = result.getString("placa");
				String cor = result.getString("cor");
				long usuario_id =result.getLong("usuario_id");
				VeiculoGateway veiculo =new VeiculoGateway(modelo,placa,cor,usuario_id);
				veiculo.setId(result.getLong("id"));
				veic=veiculo;
			}
			
			Conexao.closeConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return veic;
	}
	
	public static List<VeiculoGateway> listarTodos(){
			ArrayList<VeiculoGateway> list = new ArrayList<VeiculoGateway>();
			
			try {
				Conexao.initConnection();
				String sql = "SELECT * FROM veiculo;";
				Statement psmt = Conexao.prepare();
				ResultSet result = psmt.executeQuery(sql);
				
				while(result.next()) {

					String modelo = result.getString("modelo");
					String placa = result.getString("placa");
					String cor = result.getString("cor");
					VeiculoGateway veiculo =new VeiculoGateway(modelo,placa,cor);
					veiculo.setId(result.getLong("id"));
					list.add(veiculo);
				}
				
				Conexao.closeConnection();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		return list;
	}
	
		public static List<VeiculoGateway> listarTodosDesseUsuario(long idUser){
			ArrayList<VeiculoGateway> list = new ArrayList<VeiculoGateway>();
			
			try {
				Conexao.initConnection();
				String sql = "SELECT * FROM veiculo where usuario_id="+idUser+";";
				Statement psmt = Conexao.prepare();
				ResultSet result = psmt.executeQuery(sql);
				
				while(result.next()) {
	
					String modelo = result.getString("modelo");
					String placa = result.getString("placa");
					String cor = result.getString("cor");
					VeiculoGateway veiculo =new VeiculoGateway(modelo,placa,cor);
					veiculo.setId(result.getLong("id"));
					list.add(veiculo);
				}
				
				Conexao.closeConnection();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		return list;
	}
}
