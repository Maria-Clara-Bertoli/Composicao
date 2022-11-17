package PessoaList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
	
	private String nome;
	private String email;
	private Date datanascimento;

	public Pessoa(String nome, String email, Date datanascimento) {
		setNome(nome);
		setEmail(email);
		setDatanascimento(datanascimento);
	}
	
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=");
		builder.append(nome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", datanascimento=");
		builder.append(df.format(datanascimento));
		builder.append("]");
		return builder.toString();
	}
}
