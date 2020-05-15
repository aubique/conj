package dev.aubique.conj.mapper;

import dev.aubique.conj.model.VerbEntity;
import dev.aubique.conj.model.dto.GroupDto;
import dev.aubique.conj.model.dto.TenseDto;
import dev.aubique.conj.model.dto.VerbDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract JavaBean for mapping/converting objects
 * That's the parent class for {@link MaxMapper} and {@link MinMapper}
 * It maps {@link VerbEntity} to {@link VerbDto} that is exposed by API endpoints
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class AbstractMapper {

    private static int ITEM_WITH_NAME = 0;
    private static int FIRST_INDEX_INC = 1;

    protected VerbEntity verbObj;

    private static TenseDto mapTense(List<String> forms) {
        final String level = "tense";
        final String name = forms.get(ITEM_WITH_NAME);
        final List<String> list = forms.subList(FIRST_INDEX_INC, forms.size());

        return new TenseDto(level, name, list);
    }

    private static GroupDto mapGroup(String name, List<TenseDto> tenses) {
        final String level = "group";

        return new GroupDto(level, name, tenses);
    }

    protected GroupDto mapIndicative(List<List<String>> tenses) {
        final String name = "Indicatif";
        final List<TenseDto> list = new ArrayList<>();

        tenses.forEach(e -> list.add(mapTense(e)));
//        list.add(mapTense(verbObj.getIndPresentList()));
//        list.add(mapTense(verbObj.getIndPresentPerfectList()));
//        list.add(mapTense(verbObj.getIndImperfectList()));
//        list.add(mapTense(verbObj.getIndSimplePastList()));
//        list.add(mapTense(verbObj.getIndFutureList()));
//        list.add(mapTense(verbObj.getIndPastFutureList()));

        return mapGroup(name, list);
    }

    protected GroupDto mapSubjunctive(List<List<String>> tenses) {
        final String name = "Subjonctif";
        final List<TenseDto> list = new ArrayList<>();

        tenses.forEach(e -> list.add(mapTense(e)));
//        list.add(mapTense(verbObj.getSubPresentList()));
//        list.add(mapTense(verbObj.getSubPastList()));
//        list.add(mapTense(verbObj.getSubImperfectList()));
//        list.add(mapTense(verbObj.getSubPluperfectList()));

        return mapGroup(name, list);
    }

    protected GroupDto mapConditional(List<List<String>> tenses) {
        final String name = "Conditionnel";
        final List<TenseDto> list = new ArrayList<>();

        tenses.forEach(e -> list.add(mapTense(e)));
//        list.add(mapTense(verbObj.getConPresentList()));
//        list.add(mapTense(verbObj.getConPastList()));

        return mapGroup(name, list);
    }

    protected GroupDto mapImperative(List<List<String>> tenses) {
        final String name = "Impératif";
        final List<TenseDto> list = new ArrayList<>();

        for (List<String> tense : tenses)
            list.add(mapTense(tense));
//        tenses.add(mapTense(verbObj.getImpPresentList()));

        return mapGroup(name, list);
    }

    protected VerbDto mapVerb(List<GroupDto> list) {
        final String level = "verb";
        final String name = verbObj.getName();
//        final List<GroupDto> list = new ArrayList<>();

//        list.add(mapIndicative());
//        list.add(mapSubjunctive());
//        list.add(mapConditional());
//        list.add(mapImperative());

        return new VerbDto(level, name, list);
    }

    public abstract VerbDto map();
}
