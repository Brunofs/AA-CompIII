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
import entidades.Grupo;
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
	
	public static  GrupoGateway validaAlterarGrupo(long idGrupo,String nome,String descricao,int limite){
		GrupoGateway grupo = null;
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
		
		grupo = GrupoFinder.recuperaPorId(idGrupo);
		
		grupo.setNome(nome);
		grupo.setDescricao(descricao);
		grupo.setLimAvalicao(limite);
		
		
		return grupo;	
	}
	
	
	
	public static List<Grupo> RecuperaTodosGruposDoUsuario(long userId) throws Exception{
		Collection<GrupoGateway> gruposGateway = GrupoFinder.listarTodosPorUsuario(userId);
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		
		for(GrupoGateway g : gruposGateway){
			Grupo grupo = new Grupo(g.getId(),g.getNome(), g.getDescricao(), g.getRegras(),g.getLimAvalicao());
			grupos.add(grupo);
		}
		
		return (List<Grupo>) grupos;
	}
	
	public static Grupo RecuperaGrupo(GrupoGateway g) throws Exception{
			if(g.getId() <0){
				throw new IllegalArgumentException("id");
			}
			
			Grupo gRet = new Grupo(g.getId(),g.getNome(),g.getDescricao(),g.getRegras(),g.getLimAvalicao());
			return gRet;
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
