package org.levell.example.gui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
public class DeployControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void shouldReturnAuthorized_whenFormAuthUsed() {

		webTestClient
				.get()
				.uri("/deploy/home")
				.exchange()
				.expectStatus()
				.is4xxClientError();
	}
}
