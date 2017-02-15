package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LogradouroFinder {
	
	public static LogradouroGateway recuperaLogradouro(String cepBusca,int numeroBusca){
		LogradouroGateway logradouroR = new LogradouroGateway();
		
		try {
			Conexao.initConnection();
			String sql = "SELECT * FROM logradouro where cep='"+cepBusca+"', numero="+numeroBusca+";";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			if(result.next()) {
				String cep = result.getString("cep");
				String estado = result.getString("estado");
				String cidade = result.getString("cidade");
				String distrito = result.getString("distrito");
				String endereco = result.getString("endereco");
				Integer numero = result.getInt("numero");
				
				LogradouroGateway logradouro = new LogradouroGateway(cep, estado, cidade, distrito, endereco, numero);
				logradouro.setId(result.getLong("id"));
				logradouroR = logradouro;
			}
			
			Conexao.closeConnection();
		
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	return logradouroR;
	}

	public static LogradouroGateway recuperaLogradouroPorID(long id){
		LogradouroGateway logradouroR = new LogradouroGateway();
		
		try {
			Conexao.initConnection();
			String sql = "SELECT * FROM logradouro where id="+id+";";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			if(result.next()) {
				String cep = result.getString("cep");
				String estado = result.getString("estado");
				String cidade = result.getString("cidade");
				String distrito = result.getString("distrito");
				String endereco = result.getString("endereco");
				Integer numero = result.getInt("numero");
				
				LogradouroGateway logradouro = new LogradouroGateway(cep, estado, cidade, distrito, endereco, numero);
				logradouro.setId(result.getLong("id"));
				logradouroR = logradouro;
			}
			
			Conexao.closeConnection();
		
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	return logradouroR;
	}
	
	public static ArrayList<LogradouroGateway> recuperaLogarouroPorUser(long id){
		ArrayList<LogradouroGateway> list = new ArrayList<LogradouroGateway>();
		
		try {
			Conexao.initConnection();
			String sql = "SELECT * FROM parada p join logradouro l on p.usuario = " + id + ";";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			if(result.next()) {
				String cep = result.getString("cep");
				String estado = result.getString("estado");
				String cidade = result.getString("cidade");
				String distrito = result.getString("distrito");
				String endereco = result.getString("endereco");
				Integer numero = result.getInt("numero");
				
				LogradouroGateway logradouro = new LogradouroGateway(cep, estado, cidade, distrito, endereco, numero);
				logradouro.setId(result.getLong("id"));
				list.add(logradouro);
			}
			
			Conexao.closeConnection();
		
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return list;
	}
}
