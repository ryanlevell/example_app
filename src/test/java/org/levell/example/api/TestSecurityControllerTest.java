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
public class TestSecurityControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void shouldReturnUnauthorized_whenNoAuthUsed() {
		webTestClient
				.get()
				.uri("/api/test-security")
				.exchange()
				.expectStatus()
				.is4xxClientError();
	}

	@Test
	@WithMockUser
	public void shouldReturnOk_whenMockAuthUsed() {
		webTestClient
				.get()
				.uri("/api/test-security")
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
				.uri("/api/test-security")
				.exchange()
				.expectStatus()
				.is2xxSuccessful();
	}

	@Test
	public void shouldReturnUnauthorized_whenInvalidBasicAuthUsed() {
		webTestClient
				.mutate()
				.filter(basicAuthentication("test", "test2")).build()
				.get()
				.uri("/api/test-security")
				.exchange()
				.expectStatus()
				.is4xxClientError();
	}
}
