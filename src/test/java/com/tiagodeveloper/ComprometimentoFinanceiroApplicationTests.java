package com.tiagodeveloper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComprometimentoFinanceiroApplicationTests {
	ObjectMapper om = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	@SqlGroup(
		value = {
			@Sql(
				executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, 
				scripts = "classpath:test/insert.sql"
			),
			@Sql(
				executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, 
				scripts = "classpath:test/delete.sql"
			)
		}
	)
	void calcComprometimentoFinanceiroTest() throws Exception {
		
		mockMvc.perform(post("/calcular/{cnpj}/cnpj", "50254026000134")
	            .contentType("application/json"))
	            .andDo(print())
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$",equalTo(829.8505)));
	}
	

}
