package dev.aubique.conj.mapper;

import com.google.gson.Gson;
import dev.aubique.conj.mock.AllerVerbFactory;
import dev.aubique.conj.model.VerbEntity;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MaxMapperTest {

    private final static int TENSE_INDEX_WO_TITLE = 1;
    private final static int TENSE_LAST_INDEX = 7;
    private final static int INDICATIVE_PRESENT_PERFECT_TENSE_ID = 1;
    private final static int SUBJUNCTIVE_PRESENT_TENSE_ID = 0;
    private static final int CONDITIONAL_PRESENT_TENSE_ID = 0;
    private static Gson gson;

    private VerbEntity verbObj;
    private MaxMapper mapperReal;

    @BeforeAll
    static void classSetUp() {
        gson = new Gson().newBuilder().setPrettyPrinting().create();
    }

    @BeforeEach
    void setUp() {
        verbObj = new AllerVerbFactory().getEntity();
        mapperReal = new MaxMapper(verbObj);
    }

    @AfterEach
    void tearDown() {
//        System.out.println(gson.toJson(mapperReal.map()));//Debug output
    }

    @DisplayName("mapSubjunctive should return valid Indicative Present Perfect tense")
    @Test
    void shouldMapIndicativeTenseCorrectlyForPresentPerfectTense() {
        final List<String> tenseList = mapperReal.mapIndicative(new ArrayList<>())
                .getList().get(INDICATIVE_PRESENT_PERFECT_TENSE_ID).getList();
        validateMapTense(AllerVerbFactory.PRESENT_PERFECT_INDICATIVE, tenseList);
    }

    @DisplayName("mapSubjunctive should return valid Subjunctive Present tense")
    @Test
    void shouldMapSubjunctiveCorrectlyForSubPresentTense() {
        final List<String> tenseList = mapperReal.mapSubjunctive(new ArrayList<>())
                .getList().get(SUBJUNCTIVE_PRESENT_TENSE_ID).getList();
        validateMapTense(AllerVerbFactory.PRESENT_SUBJUNCTIVE, tenseList);
    }

    @DisplayName("mapSubjunctive should return valid Conditional Present tense")
    @Test
    void shouldMapConditionalTenseCorrectlyForConPresentTense() {
        final List<String> tenseList = mapperReal.mapConditional(new ArrayList<>())
                .getList().get(CONDITIONAL_PRESENT_TENSE_ID).getList();
        validateMapTense(AllerVerbFactory.PRESENT_CONDITIONAL, tenseList);
    }

    private void validateMapTense(String[] factoryTenseArray, List<String> actualList) {
        final List<String> expectedList = Arrays.asList(factoryTenseArray)
                .subList(TENSE_INDEX_WO_TITLE, TENSE_LAST_INDEX);
        assertThat(actualList).isEqualTo(expectedList);
    }
}
