package dev.aubique.conj.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ParserServiceImplTest {

    private static String SEARCH_VERB = "aller";

    @Autowired
    private ParserService parser;

    private Gson gson;

    @BeforeEach
    void setUp() {
        gson = new GsonBuilder().create();
    }

    @Test
    void parseVerb() {
        final var parsedObj = parser.parseVerb(SEARCH_VERB);
        Assertions.assertThat(gson.toJson(parsedObj)).contains(SEARCH_VERB);

        gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(parsedObj));
    }
}
