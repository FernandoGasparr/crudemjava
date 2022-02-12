package crudemjava.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	
	//UPDATE 
	public contato update(contato contato) {
        try (Connection connection = ConnectionFactory.createConnectionToMySQL()) {
            String SQL = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setInt(2, contato.getIdade());
            preparedStatement.setDate(3, new Date(contato.getDataCadastro().getTime()));
            preparedStatement.setInt(4, contato.getId());
          

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return contato;
    }
	
	public void delete(int id) {
        try (Connection connection = ConnectionFactory.createConnectionToMySQL()) {
            String SQL = "DELETE FROM  contatos  WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
	
	public List<contato> findAll() {

        String SQL = "SELECT id, nome, idade, datacadastro FROM contatos";

        List<contato> contatos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.createConnectionToMySQL()){

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                Date datacadastro = rs.getDate("datacadastro");

                contato contato = new contato(id, nome, idade, datacadastro);
                contatos.add(contato);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return contatos;
    }
	
	public Optional<contato> findById(int id) {
        String SQL = "SELECT id, nome, idade, datacadastro FROM contatos WHERE id = ?";
        contato contato = null;
        try (Connection connection = ConnectionFactory.createConnectionToMySQL()){

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int pKey = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                Date datacadastro = rs.getDate("datacadastro");

                contato = new contato(pKey, nome, idade, datacadastro);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(contato);
    }

}
