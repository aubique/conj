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
 * It maps {@link VerbEntity} entity to the MINIMAL form of {@link VerbDto}
 * See {@link AbstractMapper}
 */
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class MinMapper extends AbstractMapper {

    public MinMapper(VerbEntity verbObject) {
        super(verbObject);
    }

    @Override
    protected GroupDto mapIndicative(List<List<String>> tenses) {
        tenses.add(verbObj.getIndPresentList());
        tenses.add(verbObj.getIndPresentPerfectList());
        tenses.add(verbObj.getIndImperfectList());
        tenses.add(verbObj.getIndFutureList());

        return super.mapIndicative(tenses);
    }

    @Override
    protected GroupDto mapConditional(List<List<String>> tenses) {
        tenses.add(verbObj.getConPresentList());

        return super.mapConditional(tenses);
    }

    @Override
    public VerbDto map() {
        final List<GroupDto> groups = new ArrayList<>();

        groups.add(mapIndicative(new ArrayList<>()));
        groups.add(mapConditional(new ArrayList<>()));

        return super.mapVerb(groups);
    }
}
