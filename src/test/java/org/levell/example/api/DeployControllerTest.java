package org.levell.example.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;

@SpringBootTest
@AutoConfigureWebTestClient
public class DeployControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void shouldConfirmCreation_whenDeployIsCreated() {
		webTestClient
				.mutate()
				.filter(basicAuthentication("test", "test1")).build()
				.post()
				.uri("/api/deploy")
				.exchange()
				.expectStatus()
				.isCreated();
	}
}
