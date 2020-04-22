package dev.aubique.conj.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GroupDto<T> extends DefaultDto<TenseDto> {

    public GroupDto(String level, String name, List<TenseDto> list) {
        super(level, name, list);
    }
}
