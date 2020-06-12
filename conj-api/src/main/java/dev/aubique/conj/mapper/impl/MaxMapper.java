package dev.aubique.conj.mapper.impl;

import dev.aubique.conj.mapper.DefaultMapper;
import dev.aubique.conj.model.VerbEntity;
import dev.aubique.conj.model.dto.GroupDto;
import dev.aubique.conj.model.dto.TenseDto;
import dev.aubique.conj.model.dto.VerbDto;

import java.util.ArrayList;
import java.util.List;

import static dev.aubique.conj.mapper.helper.MapperHelper.*;

/**
 * Stateful object to map entity in request form for API
 * It maps {@link VerbEntity} to the EXTENDED form of {@link VerbDto}
 * This form contains indicative, subjunctive, conditional and imperative groups
 */
public class MaxMapper implements DefaultMapper {

    public final static String INDICATIVE_GROUP_NAME = "Indicatif";
    public final static String SUBJUNCTIVE_GROUP_NAME = "Subjonctif";
    public final static String CONDITIONAL_GROUP_NAME = "Conditionnel";
    public final static String IMPERATIVE_GROUP_NAME = "Impératif";
    public VerbEntity verbObj;

    public MaxMapper(VerbEntity verbObject) {
        this.verbObj = verbObject;
    }

    public VerbDto map() {
        final List<GroupDto> groups = new ArrayList<>();

        groups.add(mapIndicative());
        groups.add(mapSubjunctive());
        groups.add(mapConditional());
        groups.add(mapImperative());

        return mapVerb(groups, verbObj.getName());
    }

    public GroupDto mapIndicative() {
        final List<TenseDto> indicativeGroup = new ArrayList<>();

        indicativeGroup.add(mapTense(verbObj.getIndPresentList()));
        indicativeGroup.add(mapTense(verbObj.getIndPresentPerfectList()));
        indicativeGroup.add(mapTense(verbObj.getIndImperfectList()));
        indicativeGroup.add(mapTense(verbObj.getIndSimplePastList()));
        indicativeGroup.add(mapTense(verbObj.getIndFutureList()));
        indicativeGroup.add(mapTense(verbObj.getIndPastFutureList()));

        return mapGroup(INDICATIVE_GROUP_NAME, indicativeGroup);
    }

    public GroupDto mapSubjunctive() {
        final List<TenseDto> subjunctiveGroup = new ArrayList<>();

        subjunctiveGroup.add(mapTense(verbObj.getSubPresentList()));
        subjunctiveGroup.add(mapTense(verbObj.getSubPastList()));
        subjunctiveGroup.add(mapTense(verbObj.getSubImperfectList()));
        subjunctiveGroup.add(mapTense(verbObj.getSubPluperfectList()));

        return mapGroup(SUBJUNCTIVE_GROUP_NAME, subjunctiveGroup);
    }

    public GroupDto mapConditional() {
        final List<TenseDto> conditionalGroup = new ArrayList<>();

        conditionalGroup.add(mapTense(verbObj.getConPresentList()));
        conditionalGroup.add(mapTense(verbObj.getConPastList()));

        return mapGroup(CONDITIONAL_GROUP_NAME, conditionalGroup);
    }

    public GroupDto mapImperative() {
        final List<TenseDto> imperativeGroup = new ArrayList<>();

        imperativeGroup.add(mapTense(verbObj.getImpPresentList()));

        return mapGroup(IMPERATIVE_GROUP_NAME, imperativeGroup);
    }
}
