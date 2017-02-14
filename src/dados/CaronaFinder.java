package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CaronaFinder {
	
	//Melhorar essa consulta para retornar somente caronas maior ou igual a data de hj e maior ou igual esse horario.
	public static List<CaronaGateway> listarTodosPorGrupo(long idGrupo){
		ArrayList<CaronaGateway> list = new ArrayList<CaronaGateway>();
		
		try {
			Conexao.initConnection();
			String sql = "SELECT * FROM carona where grupo_id="+idGrupo+";";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			
			while(result.next()) {
				long grupo_id = result.getLong("grupo_id");
				long veiculo_id = result.getLong("veiculo_id");
				long logorigem_id = result.getLong("logorigem_id");
				long logdestino_id = result.getLong("logdestino_id");
				String data = result.getString("data");
				String horariosaida = result.getString("horariosaida");
				Integer num_vagas = result.getInt("num_vagas");
				CaronaGateway carona =new CaronaGateway(grupo_id,veiculo_id,data,horariosaida,num_vagas,logorigem_id,logdestino_id);
				carona.setIdCarona(result.getLong("id"));
				list.add(carona);
			}
			
			Conexao.closeConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	return list;
	}

}
