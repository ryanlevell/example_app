package org.levell.example.gui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.web.reactive.function.BodyInserters.fromFormData;

@SpringBootTest
@AutoConfigureWebTestClient
public class LoginTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void shouldReturnAuthorized_whenFormAuthUsed() {

		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add("username", "test");
		formData.add("password", "test1");

		webTestClient
				.post()
				.uri("/login")
				.body(fromFormData(formData))
				.exchange()
				.expectStatus()
				.is3xxRedirection();
	}

	@Test
	public void shouldReturnAuthorized_whenInvalidFormAuthUsed() {

		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add("username", "test");
		formData.add("password", "test2");

		webTestClient
				.post()
				.uri("/login")
				.body(fromFormData(formData))
				.exchange()
				.expectStatus()
				.is3xxRedirection();
	}
}
