import org.junit.Test;

import static org.junit.Assert.*;

public class TesteRecarga {

	public void main(String[] args) {

		Telefone telefoneUm = new Telefone("11998765432", 100);
		Conta contaUm = new Conta(01, 40);
		Cliente cliente = new Cliente("Maria", telefoneUm.getNumeroLinha(), contaUm.getConta());
		contaUm.setRecarga(10);
		String telefone = telefoneUm.getNumeroLinha();
		int saldoConta = contaUm.getSaldo();
		int recarga = contaUm.getRecarga();

		boolean sucessoRecarga = contaUm.recarga(contaUm.getRecarga());

		if (telefone != null && !telefone.isEmpty() && recarga > 0 && saldoConta >recarga) {
			if (sucessoRecarga) {
				telefoneUm.saldoAtual(recarga);
				System.out.println(cliente.getNome() + " foi realizado uma recarga com sucesso para a linha " + telefone
						+ " no valor de R$" + recarga + ", saldo atual da sua linha é R$" + telefoneUm.getSaldo()
						+ " para usar como quiser!!! \n" + "Saldo disponivel em sua conta R$" + contaUm.getSaldo());

			} else {
				System.out.println("Saldo indisponivel");
			}

		} else {
			System.out.println("Linha não existente ou recarga incompativel");
		}

	}

	@Test
	public void recargaSucesso() {
		Telefone telefoneUm = new Telefone("11998765432", 100);
		Conta contaUm = new Conta(01, 40);
		Cliente cliente = new Cliente("Maria", telefoneUm.getNumeroLinha(), contaUm.getConta());
		contaUm.setRecarga(10);
		String telefone = telefoneUm.getNumeroLinha();
		int recarga = contaUm.getRecarga();

		if (telefone != null && !telefone.isEmpty() && recarga > 0 ) {
			boolean sucessoRecarga = contaUm.recarga(contaUm.getRecarga());
			if (sucessoRecarga) {
				telefoneUm.saldoAtual(recarga);

				System.out.println(cliente.getNome() + " foi realizado uma recarga com sucesso para a linha " + telefone
						+ " no valor de R$" + recarga + ", saldo atual da sua linha e R$" + telefoneUm.getSaldo()
						+ " para usar como quiser!!! \n" + "Saldo disponivel em sua conta R$" + contaUm.getSaldo());
			}
			assertTrue(sucessoRecarga);
		}
	}

	@Test
	public void recargaInsucessoSaldoMenorRecarga() {
		Telefone telefoneUm = new Telefone("11998765432", 50);
		Conta contaUm = new Conta(01, 40);
		Cliente cliente = new Cliente("Maria", telefoneUm.getNumeroLinha(), contaUm.getConta());
		contaUm.setRecarga(100);
		String telefone = telefoneUm.getNumeroLinha();
		int recarga = contaUm.getRecarga();
		if (telefone != null && !telefone.isEmpty() && recarga > 0) {
			boolean sucessoRecarga = contaUm.recarga(contaUm.getRecarga());
			if (sucessoRecarga == false) {

				System.out.println(cliente.getNome() + " nao foi possivel realizar a recarga para a linha " + telefone
						+ " no valor de R$" + recarga + ", saldo atual da sua linha e R$" + telefoneUm.getSaldo()
						+ " para usar como quiser!!! \n" + "Saldo disponivel em sua conta R$" + contaUm.getSaldo());
			}
			assertFalse(sucessoRecarga);
		}
	}
}
