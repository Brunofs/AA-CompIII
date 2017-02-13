package dominio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dados.GrupoFinder;
import dados.GrupoGateway;
import dados.UsuarioFinder;
import dados.UsuarioGateway;
import dados.UsuarioGrupoGateway;
import excecoes.ConexaoException;

public class TMGrupo {
	
	public TMGrupo(){
	}
	
	public static Long CriarGrupo(long idUser,String nome,String descricao,String regras,int limite) throws ClassNotFoundException, ConexaoException, SQLException{
		if(nome == null || nome.isEmpty()){
			throw new IllegalArgumentException("nome");
		}
		
		if(descricao == null || descricao.isEmpty()){
			throw new IllegalArgumentException("descricao");
		}
		
		if(regras == null || regras.isEmpty()){
			throw new IllegalArgumentException("regras");
		}
		
		if(limite<0){
			throw new IllegalArgumentException("limite");
		}
		
		
		GrupoGateway grupo = new GrupoGateway(nome, descricao, regras,limite);
		grupo.salvarGrupo(idUser);
		long id = grupo.getId();
		return id;
	}
	
	public static  void AlterarGrupo(long idGrupo,String nome,String descricao,int limite){
		if(idGrupo <0){
			throw new IllegalArgumentException("id");
		}
		
		if(nome == null || nome.isEmpty()){
			throw new IllegalArgumentException("nome");
		}
		
		if(descricao == null || descricao.isEmpty()){
			throw new IllegalArgumentException("descricao");
		}
		
		if(limite<0){
			throw new NumberFormatException("limite");
		}
		
		GrupoGateway grupo = GrupoFinder.recuperaPorId(idGrupo);
		
		grupo.setNome(nome);
		grupo.setDescricao(descricao);
		grupo.setLimAvalicao(limite);
		try {
			grupo.alterarGrupo();
		} catch (ClassNotFoundException | ConexaoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<GrupoGateway> RecuperaTodosGruposDoUsuario(long userId) throws Exception{
		Collection<GrupoGateway> gruposGateway = GrupoFinder.listarTodosPorUsuario(userId);
		ArrayList<GrupoGateway> grupos = new ArrayList<GrupoGateway>();
		
		for(GrupoGateway g : gruposGateway){
			GrupoGateway grupo = new GrupoGateway(g.getNome(), g.getDescricao(), g.getRegras(),g.getLimAvalicao());
			grupo.setId(g.getId());
			grupos.add(grupo);
		}
		
		return (List<GrupoGateway>) grupos;
	}
	
	public static GrupoGateway RecuperaGrupo(long grupoId) throws Exception{
			if(grupoId <0){
				throw new IllegalArgumentException("id");
			}
			
			GrupoGateway g = GrupoFinder.recuperaPorId(grupoId);
			System.out.println("###MT"+g.getNome()+" "+ g.getDescricao());
			return g;
	}
	
	
	public static void convidarUsuario(String email,long idGrupo){
		
		if(idGrupo <0){
			throw new NumberFormatException("id");
		}
		
		if(email == null || email.isEmpty()){
			throw new IllegalArgumentException("email");
		}
		
		UsuarioGrupoGateway insert = new UsuarioGrupoGateway(idGrupo);
		insert.convidarUsuario(email);
	}
}
