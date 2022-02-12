package crudemjava.aplicacao;

import java.util.Date;

import crudemjava.dao.ContatoDAO;
import crudemjava.model.contato;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContatoDAO contatoDAO = new ContatoDAO();
		
		contato contato =new contato();
		contato.setNome("Maria Cristina");
		contato.setId(55);
		contato.setDataCadastro(new Date());
		
		contatoDAO.save(contato);
		
		
	}

}
