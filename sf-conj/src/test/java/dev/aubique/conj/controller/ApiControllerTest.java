package dev.aubique.conj.controller;

import com.google.gson.Gson;
import dev.aubique.conj.repository.VerbRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @Autowired
    private VerbRepository repository;

    @Test
    void getVerbMaxRequest() throws Exception {
        final String verbToTest = "aller";
        final String jsonContentExpected = "\"name\":\"aller\"";

        final var res = mockMvc.perform(get("/max/{verbToTest}", verbToTest)
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        final String jsonResponse = res.getResponse().getContentAsString();
        assertThat(jsonResponse).contains(jsonContentExpected);
        System.out.println(jsonResponse);
    }
}
