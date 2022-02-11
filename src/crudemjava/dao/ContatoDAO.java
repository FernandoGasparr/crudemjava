package crudemjava.dao;

import crudemjava.model.contato;

public class ContatoDAO {
	
	/*
	 * CRUD
	 */

	public void save (contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn
		}
	}
}
