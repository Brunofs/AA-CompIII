package dominio;

import java.sql.SQLException;
import java.util.List;

import dados.CaronaFinder;
import dados.CaronaGateway;
import dados.LogradouroFinder;
import dados.LogradouroGateway;
import dados.ParadaFinder;
import dados.ParadaGateway;
import dados.UsuarioFinder;
import dados.UsuarioGateway;
import excecoes.ConexaoException;
import excecoes.emailInvalido;
import excecoes.usuarioJaCadastradoaCarona;

public class TMParada {
	
	public static void CriarParada(String cep, String endereco, Integer complemento, String bairro, String cidade,
			String estado,String email, long idCarona) throws ClassNotFoundException, ConexaoException, SQLException, usuarioJaCadastradoaCarona, emailInvalido{
		UsuarioGateway userR = UsuarioFinder.recuperaUsuarioPorEmail(email);
		if(userR==null){
			throw new emailInvalido();
		}
		CaronaGateway carR = CaronaFinder.recuperaPorId(idCarona);
		List<ParadaGateway> paradas = ParadaFinder.listarTodosPorCarona(idCarona);
		
		if(paradas.size()-2>=carR.getNumVagas()){
			System.out.println("j� esta lotado");
		}
		
		LogradouroGateway logR = LogradouroFinder.recuperaLogradouro(cep, complemento);
		
		if(logR ==null){
			logR = new LogradouroGateway(cep,estado,cidade,bairro,endereco,complemento);
			logR.salvarLogradouro();
		}

		ParadaGateway paradaExistente = ParadaFinder.retornaParadaJaCadastrada(idCarona, userR.getId(), logR.getId());
		if(paradaExistente !=null){
			throw new usuarioJaCadastradoaCarona();
		}
		ParadaGateway parada = new ParadaGateway(userR.getId(),logR.getId(),idCarona);
		parada.salvarParada();
	}

}
