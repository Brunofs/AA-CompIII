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
			String sql = "Select carona_id from parada  carona_id="+carona_id+";";
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
}
