package crudemjava.aplicacao;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import crudemjava.dao.ContatoDAO;
import crudemjava.model.contato;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContatoDAO contatoDAO = new ContatoDAO();
		Scanner scan = new Scanner(System.in);
		
		
		// PARA ATUALIZAR
		
		System.out.print("Digite o ID do contato que deseja atualizar: ");
        Optional<contato> contatoOptional = contatoDAO.findById(scan.nextInt());
        contato contato = contatoOptional.get();
        System.out.print("Nome: ");
        scan.nextLine();
        contato.setNome(scan.nextLine());
        System.out.print("Idade: ");
        contato.setIdade(scan.nextInt());
        contato.setDataCadastro(new Date(contato.getDataCadastro().getTime()));
        contatoDAO.update(contato);
		
		
		
		
		// PARA VISUALIZAR
        
        
		//List<contato> contatos = contatoDAO.findAll();
		//for(contato contato : contatos) {
			//System.out.println("ID: " + contato.getId());
             //System.out.println("Nome: " + contato.getNome());
             //System.out.println("Idade: "  + contato.getIdade());
             //System.out.println("Data de cadastro: " + contato.getDataCadastro());
             //System.out.println();	
			
		}
		
		
		
	// PARA EXCLUIR
		
		//System.out.print("Digite o Id que vc deseja excluir");
		//contatoDAO.delete(scan.nextInt());
		
		
	
	
	
	//  PARA CRIAR
	
	//contato contato =new contato();
		//contato.setNome("Maria Cristina");
		//contato.setIdade(55);
		//contato.setDataCadastro(new Date());
		
		//contatoDAO.save(contato);
		
		
	}


