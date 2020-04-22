package dev.aubique.conj.services;

import dev.aubique.conj.model.VerbMax;
import dev.aubique.conj.model.dto.DefaultDto;
import dev.aubique.conj.model.dto.GroupDto;
import dev.aubique.conj.model.dto.TenseDto;
import dev.aubique.conj.model.dto.VerbDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapperImpl implements Mapper<VerbMax, VerbDto> {

    private static int ITEM_WITH_NAME = 0;
    private static int FIRST_INDEX_INC = 1;

    private static TenseDto<String> mapTense(List<String> forms) {
        final String level = "tense";
        final String name = forms.get(ITEM_WITH_NAME);
        final List<String> list = forms.subList(FIRST_INDEX_INC, forms.size());

        return new TenseDto<>(level, name, list);
    }

    private static GroupDto mapGroup(String name, List<TenseDto> tenses) {
        final String level = "group";

        return new GroupDto(level, name, tenses);
    }

    @Deprecated
    private static <T> DefaultDto mapDto(
            DefaultDto<T> dto,
            String level,
            String name,
            List<T> tList) {
        final List<T> list = tList.subList(1, 7);
        dto.setLevel(level);
        dto.setName(name);
        dto.setList(list);
        return dto;
    }

    private static GroupDto<TenseDto<String>> mapIndicative(VerbMax verbObj) {
        final String name = "Indicatif";
        final List<TenseDto> tenses = new ArrayList<>();

        tenses.add(mapTense(verbObj.getIndPresentList()));
        tenses.add(mapTense(verbObj.getIndPresentPerfectList()));
        tenses.add(mapTense(verbObj.getIndImperfectList()));
        tenses.add(mapTense(verbObj.getIndSimplePastList()));
        tenses.add(mapTense(verbObj.getIndFutureList()));
        tenses.add(mapTense(verbObj.getIndPastFutureList()));

        return mapGroup(name, tenses);
    }

    private static GroupDto<TenseDto<String>> mapSubjunctive(VerbMax verbObj) {
        final String name = "Subjonctif";
        final List<TenseDto> tenses = new ArrayList<>();

        tenses.add(mapTense(verbObj.getSubPresentList()));
        tenses.add(mapTense(verbObj.getSubPastList()));
        tenses.add(mapTense(verbObj.getSubImperfectList()));
        tenses.add(mapTense(verbObj.getSubPluperfectList()));

        return mapGroup(name, tenses);
    }

    private static GroupDto<TenseDto<String>> mapConditional(VerbMax verbObj) {
        final String name = "Conditionnel";
        final List<TenseDto> tenses = new ArrayList<>();

        tenses.add(mapTense(verbObj.getConPresentList()));
        tenses.add(mapTense(verbObj.getConPastList()));

        return mapGroup(name, tenses);
    }

    private static GroupDto<TenseDto<String>> mapImperative(VerbMax verbObj) {
        final String name = "Impératif";
        final List<TenseDto> tenses = new ArrayList<>();

        tenses.add(mapTense(verbObj.getImpPresentList()));

        return mapGroup(name, tenses);
    }

    public VerbDto<GroupDto<TenseDto<String>>> map(VerbMax verbObj) {
        final List<GroupDto> groups = new ArrayList<>();
        final String level = "verb";
        final String name = verbObj.getName();

        groups.add(mapIndicative(verbObj));
        groups.add(mapSubjunctive(verbObj));
        groups.add(mapConditional(verbObj));
        groups.add(mapImperative(verbObj));

        return new VerbDto(level, name, groups);
    }
}
