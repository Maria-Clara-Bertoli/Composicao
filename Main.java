package Composicao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ParseException{
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Pessoa pessoa = new Pessoa("Maria", "@email", df.parse("08/05/2006"));
		ListPessoa listpessoa = new ListPessoa();
		
		listpessoa.adicionarLista(pessoa);
		
		pessoa = new Pessoa("Marcela", "@Marcela", df.parse("08/07/2005"));
		
		listpessoa.adicionarLista(pessoa);
		
		pessoa = new Pessoa("João", "Joao@gmail.com", df.parse("06/05/2006"));
		
		listpessoa.adicionarLista(pessoa);
		
		listpessoa.removerListaNome("Marcela");
		
		Date parametrodata = df.parse("28/06/2003");
		
		listpessoa.alterarPessoa("João", "Ana" , "ana@gmail.com", parametrodata);
		
		List<Pessoa> lista = listpessoa.getLista();
		
		for(Pessoa item : lista) {
			System.out.println(item.toString());
		}
		
		System.out.println("Cnsulta por 'like': ");
		listpessoa.consultaNome("M");
		
		System.out.println("Idade das pessoas: ");
		
		System.out.println(listpessoa.calculaIdade("Ana"));
		
		System.out.println("Pessoas com idades maiores que o parâmetro informado: ");
		
		System.out.println(listpessoa.buscaIdade(10));
		
		System.out.println("Aniversariantes no mês passado como parâmetro: ");
		
		System.out.println(listpessoa.aniversarianteMes(1));

	}

}
