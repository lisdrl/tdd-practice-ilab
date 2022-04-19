package com.testes.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.testes.poc.model.Cliente;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PocApplicationTests {

	@Test
	void validarCpfValidoComPonto() {
		var cliente = new Cliente();
		cliente.setCpf("030.750.650-99");

		assertEquals(true, cliente.validarCpf());
	}

	@Test
	void validarCpfValidoSemPonto() {
		var cliente = new Cliente();
		cliente.setCpf("03075065099");

		assertEquals(true, cliente.validarCpf());
	}

	@Test
	void validarCpfInvalidoComEspaco() {
		var cliente = new Cliente();
		cliente.setCpf(" 03075065 099 ");

		assertEquals(true, cliente.validarCpf());
	}

	@Test
	void validarCpfInvalidoComPonto() {
		var cliente = new Cliente();
		cliente.setCpf("030.750.000-00");

		assertEquals(false, cliente.validarCpf());
	}

	@Test
	void validarCpfInvalidoSemPonto() {
		var cliente = new Cliente();
		cliente.setCpf("03075000000");

		assertEquals(false, cliente.validarCpf());
	}

	@Test
	void validarCpfInvalidoNull() {
		var cliente = new Cliente();
		cliente.setCpf(null);

		assertEquals(false, cliente.validarCpf());
	}

	@Test
	void validarCpfInvalidoOutrosCaracteres() {
		var cliente = new Cliente();
		cliente.setCpf("adijaoi");

		assertEquals(false, cliente.validarCpf());
	}
}
