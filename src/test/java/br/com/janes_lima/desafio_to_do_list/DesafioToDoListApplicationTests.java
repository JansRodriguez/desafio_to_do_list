package br.com.janes_lima.desafio_to_do_list;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.janes_lima.desafio_to_do_list.Model.To_Do;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DesafioToDoListApplicationTests {
// EXPLORAR CENÁRIO DE SUCESSO (CAMINHO FELIZ) PARA CRIAÇÃO DE TO_DO

	@Autowired
	private WebTestClient clienteTesteReativo; 
	// O WebTestCliente não é como o RestTemplate, pois não é sincrona. Ele é Assincrona.
		// No entanto, necessário adicionar o WebFlux nas dependecias para utilizar.

	@Test
	void testeCriarToDoSucesso() {
		var toDo = new To_Do("task1", "descrição da task1", true, 3);

		// Chegar - EndPoint de criação das toDos	
		clienteTesteReativo
			.post()
			.uri("/todos")
			.bodyValue(toDo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].nome").isEqualTo(toDo.getNome())
			.jsonPath("$[0].descricao").isEqualTo(toDo.getDescricao())
			.jsonPath("$[0].realizado").isEqualTo(toDo.getRealizado())
			.jsonPath("$[0].prioridade").isEqualTo(toDo.getPrioridade());

	}
// EXPLORAR CENÁRIO DE ERRO PARA CRIAÇÃO DE TO_DO
	@Test
	void testeCriarToDoFalha(){
		clienteTesteReativo
			.post()
			.uri("/todos")
			.bodyValue(
				new To_Do(null, null, false, 0)
			)
			.exchange()
			.expectStatus().isBadRequest();
	}

}
