package br.edu.infnet.leandraassis;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import br.edu.infnet.leandraassis.model.domain.Cliente;

@SpringBootTest
class ClienteTests {

	private Cliente cliente;
	private final String NOME = "Leandra";
	private final String INSUFICIENTE = "Erro ao efetuar o pagamento";
	private final String SUFICIENTE = "Pagamento efetuado";
	
	@BeforeEach
	void setUp() {
		cliente = new Cliente();
		cliente.setNome("Leandra");
		cliente.setSaldo(1000);
		cliente.setVip(false);
		cliente.setDivida(500);
	}

	@Test
	void dividaComVIP() {
		cliente.setVip(true);
		assertEquals(450, cliente.calcularDivida());
	}
	
	@Test
	void dividaSemVIP() {
		assertEquals(500, cliente.calcularDivida());
	}
	
	@Test
	void saldoComVIP() {
		cliente.setVip(true);
		assertEquals(550, cliente.calcularSaldo());
	}
	
	@Test
	void saldoSemVIP() {
		assertEquals(500, cliente.calcularSaldo());
	}
	
	@Test
	void saldoInsuficiente() {
		cliente.setSaldo(500);
		cliente.setDivida(1000);
		assertEquals(INSUFICIENTE, cliente.verificacaoSaldo());
	}
	
	@Test
	void saldoSuficiente() {
		assertEquals(SUFICIENTE, cliente.verificacaoSaldo());
	}
	
	@Test
	void retornarDados() {
		assertEquals(NOME, cliente.getNome());
		assertEquals(500, cliente.getDivida());
		assertEquals(false, cliente.isVip());
		assertEquals(1000, cliente.getSaldo());
	}
}
