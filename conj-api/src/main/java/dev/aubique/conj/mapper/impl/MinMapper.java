package dev.aubique.conj.mapper.impl;

import dev.aubique.conj.mapper.DefaultMapper;
import dev.aubique.conj.mapper.helper.MapperHelper;
import dev.aubique.conj.model.VerbEntity;
import dev.aubique.conj.model.annotations.Min;
import dev.aubique.conj.model.dto.GroupDto;
import dev.aubique.conj.model.dto.TenseDto;
import dev.aubique.conj.model.dto.VerbDto;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static dev.aubique.conj.mapper.helper.MapperHelper.*;

/**
 * Stateful object to map entity in request form for API
 * It maps {@link VerbEntity} to the MINIMAL form of {@link VerbDto}
 * This DTO form doesn't contain more that one group of tenses
 */
public class MinMapper implements DefaultMapper {

    private final static String MINIMAL_TENSE_GROUP = "Minimal";
    private final static Class<? extends Min> ANNOTATION_CLASS = Min.class;
    private VerbEntity verbObj;

    public MinMapper(VerbEntity verbObject) {
        this.verbObj = verbObject;
    }

    /**
     * Sort fields by the {@code order} parameter of {@link Min} annotation
     */
    public static void sortFieldListByOrderAnnotation(List<Field> fields) {
        fields.sort(new Comparator<Field>() {
            @Override
            public int compare(Field o1, Field o2) {
                int order1 = o1.getAnnotation(ANNOTATION_CLASS).order();
                int order2 = o2.getAnnotation(ANNOTATION_CLASS).order();

                return Integer.compare(order1, order2);
            }
        });
    }

    public VerbDto map() {
        return mapVerb(List.of(mapMinimal()), verbObj.getName());
    }

    /**
     * Compile a group with the help of reflection/annotations
     * Group contains a mix of tenses marked by the specific annotation
     *
     * @return minimal DTO form of {@link VerbDto}
     */
    @SuppressWarnings("unchecked")
    public GroupDto mapMinimal() {
        final List<TenseDto> minimalGroup = new ArrayList<>();
        final List<Field> fields = MapperHelper.findAnnotatedFields(
                ANNOTATION_CLASS, verbObj.getClass());

        sortFieldListByOrderAnnotation(fields);
        for (Field field : fields) {
            List<String> tenseList = new ArrayList<>();

            field.setAccessible(true);
            try {
                tenseList = (List<String>) field.get(verbObj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException("Error while processing VerbEntity fields");
            }

            minimalGroup.add(mapTense(tenseList));
        }

        return mapGroup(MINIMAL_TENSE_GROUP, minimalGroup);
    }
}
