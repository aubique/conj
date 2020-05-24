package dev.aubique.conj.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ParserServiceImplTest {

    private static String SEARCH_VERB = "aller";
    private static Gson gsonPlain;
    private static Gson gsonDetailed;

    @Autowired
    private ParserService parser;

    @BeforeAll
    static void classSetUp() {
        gsonPlain = new GsonBuilder().create();
        gsonDetailed = new GsonBuilder().setPrettyPrinting().create();
    }

    @BeforeEach
    void setUp() {
    }

    @DisplayName("parse and return JSON that contains Search Verb")
    @Test
    void parserShouldReturnJsonWithSearchVerb() {
        final var parsedObj = parser.parseVerb(SEARCH_VERB);
        Assertions.assertThat(gsonPlain.toJson(parsedObj)).contains(SEARCH_VERB);
//        final var gsonDetailed = new GsonBuilder().setPrettyPrinting().create();
//        System.out.println(gsonDetailed.toJson(parsedObj));
    }
}
