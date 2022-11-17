package Composicao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ListPessoa {
	
	List<Pessoa> lista = new ArrayList<Pessoa>();
	List<String> listanome = new ArrayList<String>();
	List<String> listaaniversariante = new ArrayList<String>();
	
	public List<String> aniversarianteMes(int monthparametro){
		GregorianCalendar nascimento = new GregorianCalendar();
		for(Pessoa item : getLista()) {
			 nascimento.setTime(item.getDatanascimento());
			 int month = nascimento.get(Calendar.MONTH) + 1;
			 if(month == monthparametro) {
				 listaaniversariante.add(item.getNome());
			 }
		}
		return listaaniversariante;
	}
	
	public List<String> buscaIdade(int idade){
		for(Pessoa item : getLista()) {
			int retornoidade = calculaIdade(item.getNome());
			if(retornoidade > idade) {
				listanome.add(item.getNome());
			}
		}
		return listanome;
	}
	
	public int calculaIdade(String nome) {
		GregorianCalendar dataatual = new GregorianCalendar();
		GregorianCalendar nascimento = new GregorianCalendar();
		Pessoa item = retornoObjeto(nome);
		nascimento.setTime(item.getDatanascimento());	
		int anoatual = dataatual.get(Calendar.YEAR);
		int anonascimento = nascimento.get(Calendar.YEAR);
		int resultado = anoatual - anonascimento;
		return resultado;
	}
	
	public boolean consultaNome(String letra) {
		for(Pessoa item : getLista()) {
			if(letra.equalsIgnoreCase(item.getNome().substring(0, 1))) {
				System.out.println(item.toString());
			}
		}
		return true;
	}
	
	public boolean alterarPessoa(String nomeatual, String novonome, String novoemail, Date nascimento) {
		for(Pessoa item : getLista()) {
			if(item == retornoObjeto(nomeatual)) {
				item.setNome(novonome);
				item.setEmail(novoemail);
				item.setDatanascimento(nascimento);
			}
		}
		return true;
	}
	
	public boolean adicionarLista(Pessoa pessoa) {
		boolean verifica = validarPessoa(pessoa);
		if(verifica == true) {
		lista.add(pessoa);
		}
		return true;
	}
	
	public boolean removerListaNome(String nome) {
			if(retornoObjeto(nome) != null) {
				Pessoa item = retornoObjeto(nome);
				lista.remove(item);
			}
			else {
				System.out.println("A pessoa não foi encontrada!");
			}
		return true;
	}
	
	public Pessoa retornoObjeto(String nome) {
		for(Pessoa item : lista) {
			if(item.getNome() == nome) {
				return item;
			}
		}
		return null;
	}
	
	public boolean validarPessoa(Pessoa pessoa) {
		for(Pessoa item : lista) {
			if(item.getNome() == pessoa.getNome() || item.getNome().length() < 3) {
				System.out.println("Não é possível adicionar na lista pois esse nome já existe!");
				return false;
			}
			else {
				return true;
			}
		}
		return true;
	}

	public List<Pessoa> getLista() {
		return lista;
	}

	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}
}
