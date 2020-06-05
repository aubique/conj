package dev.aubique.conj.mapper.helper;

import dev.aubique.conj.mapper.impl.MaxMapper;
import dev.aubique.conj.mapper.impl.MinMapper;
import dev.aubique.conj.model.dto.GroupDto;
import dev.aubique.conj.model.dto.TenseDto;
import dev.aubique.conj.model.dto.VerbDto;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Helper class for DTO instantiation and annotation search
 * Used by {@link MaxMapper} and {@link MinMapper}
 */
public class MapperHelper {

    public final static String VERB_LEVEL = "verbe";
    public final static String GROUP_LEVEL = "groupe";
    public final static String TENSE_LEVEL = "temps";
    private final static int ITEM_WITH_NAME = 0;
    private final static int FIRST_INDEX_INC = 1;

    /**
     * Create the new DTO that contains derived forms of a verb
     *
     * @param forms list of derived verb forms
     * @return new instantiated {@link TenseDto} object
     */
    public static TenseDto mapTense(List<String> forms) {
        final String name = forms.get(ITEM_WITH_NAME);
        final List<String> list = forms.subList(FIRST_INDEX_INC, forms.size());

        return new TenseDto(TENSE_LEVEL, name, list);
    }

    /**
     * Create the new DTO containing Group of Tenses
     *
     * @param name   for Group of tenses
     * @param tenses list with {@link TenseDto}
     * @return new instantiated {@link GroupDto} object
     */
    public static GroupDto mapGroup(String name, List<TenseDto> tenses) {
        return new GroupDto(GROUP_LEVEL, name, tenses);
    }

    /**
     * Create the new {@link VerbDto} object ready for serialization
     *
     * @param list to be forwarded down to the {@link VerbDto} constructor
     * @param name is the basic infinitive form of the Verb
     * @return new instantiated {@link VerbDto}
     */
    public static VerbDto mapVerb(List<GroupDto> list, String name) {
        return new VerbDto(VERB_LEVEL, name, list);
    }

    /**
     * Get list of all fields with specified annotation class from the given Class
     *
     * @param annotation marks the fields
     * @param clazz      is the Class that being examined
     * @return list of annotated fields
     */
    public static List<Field> findAnnotatedFields(
            Class<? extends Annotation> annotation,
            Class<?> clazz
    ) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(annotation))
                .collect(Collectors.toList());
    }
}
