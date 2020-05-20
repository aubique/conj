package dev.aubique.conj.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Simple JavaBean object that represents Verb DTO
 * That's the first level Data Transfer Object for API
 * Which is positioned on top of {@link GroupDto}
 * It stores verb name, verb level hint and {@code List<GroupDto>}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class VerbDto extends DefaultDto<GroupDto> {

    public VerbDto(String level, String name, List<GroupDto> list) {
        super(level, name, list);
    }
}
