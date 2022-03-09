public class Cliente {
	private String nome_cliente;
	private String telefone;
	private int conta;

	public Cliente(String nome_cliente, String telefone, int conta) {
		this.nome_cliente = nome_cliente;
		this.telefone = telefone;
		this.conta = conta;
	}

	public void setNome(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getNome() {
		return this.nome_cliente;
	}

	public void setLinha(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getConta() {
		return this.conta;
	}

}
