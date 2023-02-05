package org.levell.example;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestSecurityController {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnUnauthorized_whenNoAuthUsed() throws Exception {
		mockMvc.perform(get("/test-security"))
				.andExpect(status().is4xxClientError());
	}

	@Test
	@WithMockUser
	public void shouldReturnOk_whenNoAuthUsed() throws Exception {
		mockMvc.perform(get("/test-security"))
				.andExpect(status().isOk());
	}
}
