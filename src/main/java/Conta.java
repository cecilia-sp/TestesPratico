public class Conta {
	private int conta;
	private int saldo;
	private int vl_recarga;

	public Conta(int conta, int saldo) {
		this.conta = conta;
		this.saldo = saldo;
	}
	
	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getConta() {
		return this.conta;
	}
	

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getSaldo() {
		return this.saldo;
	}

	public void setRecarga(int vl_recarga) {
		this.vl_recarga = vl_recarga;
	}

	public int getRecarga() {
		return this.vl_recarga;
	}
	
	public boolean recarga(int vl_recarga) {
		if (this.saldo >= vl_recarga) {
			this.saldo -= vl_recarga;
			return true;
		}
		return false;
	}

}
