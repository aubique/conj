package dev.aubique.conj.controller;

import org.junit.jupiter.api.DisplayName;
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

    private static String SEARCH_VERB = "aller";

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("respond with 200 code and contain JSON with Search Verb")
    @Test
    void maxRequestShouldBe200AndContainSearchVerb() throws Exception {
        final String jsonContentExpected = String.format(",\"name\":\"%s\",", SEARCH_VERB);

        final var res = mockMvc.perform(get("/api/max/{verbToTest}", SEARCH_VERB)
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        final String jsonResponse = res.getResponse().getContentAsString();
        assertThat(jsonResponse).contains(jsonContentExpected);
        System.out.println(jsonResponse);
    }
}
