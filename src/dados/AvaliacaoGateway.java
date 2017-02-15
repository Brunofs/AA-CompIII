package dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import excecoes.ConexaoException;

public class AvaliacaoGateway {
	long idUsuario;
	long avaciacao;
	
	public AvaliacaoGateway(long idUsuario, long avaliacao){
		this.idUsuario = idUsuario;
		this.avaciacao = avaliacao;
	}
	
	public void salvarAvalicao()  throws ConexaoException, SQLException, ClassNotFoundException {
		Conexao.initConnection();
		String sql = "INSERT INTO public.carona(avalicao, id_usuario) VALUES(?,?);";
			PreparedStatement psmt = Conexao.prepare(sql);
			psmt.setLong(1, this.getAvaciacao());
			psmt.setLong(2, this.getIdUsuario());
			int linhasAfetadas = psmt.executeUpdate();
			
			if (linhasAfetadas == 0) {
				throw new ConexaoException();
			}
			
	        Conexao.commit();
			Conexao.closeConnection();
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getAvaciacao() {
		return avaciacao;
	}
	
	public void setAvaciacao(long avaciacao) {
		this.avaciacao = avaciacao;
	}
}
