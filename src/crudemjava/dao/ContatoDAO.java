package crudemjava.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import crudemjava.factory.ConnectionFactory;
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
			//criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			//Criamos uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			// adicionar os valores que são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//executar a query
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			//fechar as conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}	
}
