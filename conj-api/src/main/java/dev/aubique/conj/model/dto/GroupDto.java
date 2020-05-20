package dev.aubique.conj.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Simple JavaBean object that represents tense Group DTO
 * That's the second level Data Transfer Object for API
 * Which is positioned between {@link VerbDto} and {@link TenseDto}
 * It stores tense group name, group level hint and {@code List<TenseDto>}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupDto extends DefaultDto<TenseDto> {

    public GroupDto(String level, String name, List<TenseDto> list) {
        super(level, name, list);
    }
}
