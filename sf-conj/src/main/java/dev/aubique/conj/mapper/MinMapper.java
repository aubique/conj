package dev.aubique.conj.mapper;

import dev.aubique.conj.model.VerbMax;
import dev.aubique.conj.model.dto.GroupDto;
import dev.aubique.conj.model.dto.TenseDto;
import dev.aubique.conj.model.dto.VerbDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class MinMapper extends AbstractMapper {

    public MinMapper(VerbMax verbObject) {
        super(verbObject);
    }

    @Override
    protected GroupDto<TenseDto<String>> mapIndicative(List<List<String>> tenses) {
        tenses.add(verbObj.getIndPresentList());
        tenses.add(verbObj.getIndPresentPerfectList());
        tenses.add(verbObj.getIndImperfectList());
        tenses.add(verbObj.getIndFutureList());

        return super.mapIndicative(tenses);
    }

    @Override
    protected GroupDto<TenseDto<String>> mapConditional(List<List<String>> tenses) {
        tenses.add(verbObj.getConPresentList());

        return super.mapConditional(tenses);
    }

    @Override
    public VerbDto<GroupDto<TenseDto<String>>> map() {
        final List<GroupDto> groups = new ArrayList<>();

        groups.add(mapIndicative(new ArrayList<>()));
        groups.add(mapConditional(new ArrayList<>()));

        return super.mapVerb(groups);
    }
}
