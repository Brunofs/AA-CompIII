package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.Constants;

public class ParadaFinder {
	
	
	public static List<ParadaGateway> listarTodosPorCarona(long carona_id){
		ArrayList<ParadaGateway> list = new ArrayList<ParadaGateway>();
		
		try {
			Conexao.initConnection();
			String sql = "Select * from parada where carona_id="+carona_id+";";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			
			while(result.next()) {
				long usuario_id = result.getLong("usuario_id");
				long logradouro_id = result.getLong("logradouro_id");
				long caronaid = result.getLong("carona_id");
				ParadaGateway parada =new ParadaGateway(usuario_id,logradouro_id,caronaid);
				list.add(parada);
			}
			
			Conexao.closeConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;
	}
	
	
	public static ParadaGateway retornaParadaJaCadastrada(long carona_id, long usuario_id,long logradouro_id){
		ParadaGateway list = null;
		
		try {
			Conexao.initConnection();
			String sql = "Select * from parada where carona_id="+carona_id+" and usuario_id="+usuario_id+" and logradouro_id="+logradouro_id+";";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			
			if(result.next()) {
				long usuario_idd = result.getLong("usuario_id");
				long logradouro_idd = result.getLong("logradouro_id");
				long caronaid = result.getLong("carona_id");
				ParadaGateway parada =new ParadaGateway(usuario_idd,logradouro_idd,caronaid);
				list =parada;
			}
			
			Conexao.closeConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;
	}
}
