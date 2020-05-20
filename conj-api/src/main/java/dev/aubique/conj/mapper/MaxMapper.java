package dev.aubique.conj.mapper;

import dev.aubique.conj.model.VerbEntity;
import dev.aubique.conj.model.dto.GroupDto;
import dev.aubique.conj.model.dto.VerbDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Child JavaBean to map object for API
 * It maps {@link VerbEntity} entity to the EXTENDED form of {@link VerbDto}
 * See {@link AbstractMapper}
 */
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class MaxMapper extends AbstractMapper {

    public MaxMapper(VerbEntity verbObject) {
        super(verbObject);
    }

    @Override
    protected GroupDto mapIndicative(List<List<String>> tenses) {
        tenses.add(verbObj.getIndPresentList());
        tenses.add(verbObj.getIndPresentPerfectList());
        tenses.add(verbObj.getIndImperfectList());
        tenses.add(verbObj.getIndSimplePastList());
        tenses.add(verbObj.getIndFutureList());
        tenses.add(verbObj.getIndPastFutureList());

        return super.mapIndicative(tenses);
    }

    @Override
    protected GroupDto mapSubjunctive(List<List<String>> tenses) {
        tenses.add(verbObj.getSubPresentList());
        tenses.add(verbObj.getSubPastList());
        tenses.add(verbObj.getSubImperfectList());
        tenses.add(verbObj.getSubPluperfectList());

        return super.mapSubjunctive(tenses);
    }

    @Override
    protected GroupDto mapConditional(List<List<String>> tenses) {
        tenses.add(verbObj.getConPresentList());
        tenses.add(verbObj.getConPastList());

        return super.mapConditional(tenses);
    }

    @Override
    protected GroupDto mapImperative(List<List<String>> tenses) {
        tenses.add(verbObj.getImpPresentList());

        return super.mapImperative(tenses);
    }

    @Override
    public VerbDto map() {
        final List<GroupDto> groups = new ArrayList<>();

        groups.add(mapIndicative(new ArrayList<>()));
        groups.add(mapSubjunctive(new ArrayList<>()));
        groups.add(mapConditional(new ArrayList<>()));
        groups.add(mapIndicative(new ArrayList<>()));

        return super.mapVerb(groups);
    }
}
