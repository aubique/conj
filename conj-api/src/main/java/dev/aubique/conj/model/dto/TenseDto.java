package dev.aubique.conj.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Simple JavaBean object that represents Tense DTO
 * That's the third level Data Transfer Object for API
 * Which is positioned under {@link VerbDto}
 * It stores tense group name (title), tense level hint and {@code List<String>}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TenseDto extends DefaultDto<String> {

    public TenseDto(String level, String name, List<String> list) {
        super(level, name, list);
    }
}
