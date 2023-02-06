package org.levell.example;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;

@SpringBootTest
@AutoConfigureMockMvc
public class TestSecurityController {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void shouldReturnUnauthorized_whenNoAuthUsed() {
		webTestClient
				.get()
				.uri("/test-security")
				.exchange()
				.expectStatus()
				.is4xxClientError();
	}

	@Test
	@WithMockUser
	public void shouldReturnOk_whenMockAuthUsed() {
		webTestClient
				.get()
				.uri("/test-security")
				.exchange()
				.expectStatus()
				.is2xxSuccessful();
	}

	@Test
	public void shouldReturnOk_whenBasicAuthUsed() {
		webTestClient
				.mutate()
				.filter(basicAuthentication("test", "test1")).build()
				.get()
				.uri("/test-security")
				.exchange()
				.expectStatus()
				.is2xxSuccessful();
	}
}
