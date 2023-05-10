package cadastros;

import java.util.List;

public class Menu {
	public static void main(String[] args){
		
		PessoaDao pd = new PessoaDao();
		try {
			
			// Incluir uma pessoa
			Pessoa p1 = new Pessoa(1,"jose", "jose@gmail.com");
			Pessoa p2 = new Pessoa(2,"joao", "joao@gmail.com");
			Pessoa p3 = new Pessoa(3,"maria", "maria@gmail.com");
			pd.incluirPessoa(p1);
			pd.incluirPessoa(p2);
			pd.incluirPessoa(p3);
			
			try {
				
				// Listando todas as pessoas
				List<Pessoa> listaPessoas = pd.ListarPessoas();
				for(Pessoa p : listaPessoas){
					System.out.println("Id.: " + p.getIdPessoa());
					System.out.println("Nome : "  +p.getNomePessoa());
					System.out.println("Email : " +p.getEmail());
				}
				
				
				// Alterar uma pessoa
				Pessoa pes = pd.consultarPessoaIndividual(4);
				if(pes != null) {
					// - Alterar a informação desejada usando o set(Classe encapsulada)
					pes.setEmail("maria@hotmail.com");	
					// chamar o método de contém o comando update
					pd.alterarPessoa(pes);
				}else {
					System.out.println("Pessoa não encontrada ou falha no acesso ao banco de dados");
				}
				
				
			}catch (Exception ex ){
		        System.out.println("Alguma coisa deu errado no acesso ao banco de dados.");
			}
			
			
			//excluir
			// Verifica se a pessoa existe por código
			Pessoa pessoa1 = pd.consultarPessoaIndividual(3);
			
			// chama o método que contem o comando delete
			pd.excluirPessoa(pessoa1);
			
		
		} catch (Exception e) {
			System.out.println("Error:  " + e.getMessage());
		}		

	}
}