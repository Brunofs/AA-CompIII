package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.Constants;

public class GrupoFinder {
	
	public static List<GrupoGateway> listarTodos(){
		ArrayList<GrupoGateway> list = new ArrayList<GrupoGateway>();
		
		try {
			Conexao.initConnection();
			String sql = "SELECT * FROM grupo;";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			
			while(result.next()) {
				String nome = result.getString("nome");
				String descricao = result.getString("descricao");
				String regras = result.getString("regra");
				int limite	=	result.getInt("limite");
				GrupoGateway grupo =new GrupoGateway(nome,descricao,regras,limite);
				grupo.setId(result.getLong("id"));
				list.add(grupo);
			}
			
			Conexao.closeConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	return list;
	}
	
	public static List<GrupoGateway> listarTodosPorUsuario(long idUser){
		ArrayList<GrupoGateway> list = new ArrayList<GrupoGateway>();
		
		try {
			Conexao.initConnection();
			String sql = "Select id,nome,descricao,regra,limite from usuario_grupo u join grupo g on u.usuario_id = "+idUser+" and u.grupo_id = g.id and u.situacao ='"+Constants.ATIVO+"';";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			
			while(result.next()) {
				String nome = result.getString("nome");
				String descricao = result.getString("descricao");
				String regras = result.getString("regra");
				int limite	=	result.getInt("limite");
				GrupoGateway grupo =new GrupoGateway(nome,descricao,regras,limite);
				grupo.setId(result.getLong("id"));
				list.add(grupo);
			}
			
			Conexao.closeConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	return list;
	}
	
	public static GrupoGateway recuperaPorId(long id){
		GrupoGateway grup = new GrupoGateway();
		
		try {
			Conexao.initConnection();
			String sql = "SELECT * FROM grupo where id="+id+";";
			Statement psmt = Conexao.prepare();
			ResultSet result = psmt.executeQuery(sql);
			
			
			if(result.next()) {
				String nome = result.getString("nome");
				String descricao = result.getString("descricao");
				String regras = result.getString("regra");
				int limite	=	result.getInt("limite");
				GrupoGateway grupo =new GrupoGateway(nome,descricao,regras,limite);
				grupo.setId(result.getLong("id"));
				grup=grupo;
			}
			
			Conexao.closeConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return grup;
	}

}
