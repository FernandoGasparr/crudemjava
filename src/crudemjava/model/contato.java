package crudemjava.model;

import java.util.Date;
public class contato {
	
	private int id;
	private String nome;
	private int idade;
	private Date DataCadastro;
	public contato(int id, String nome, int idade, Date DataCadastro) {
		this.id=id;
		this.nome=nome;
		this.idade=idade;
		this.DataCadastro=DataCadastro;
		
	}
	
	public contato() {
		
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getDataCadastro() {
		return DataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		DataCadastro = dataCadastro;
	}
	
	

}
