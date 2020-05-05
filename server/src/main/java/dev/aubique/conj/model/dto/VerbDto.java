package dev.aubique.conj.model.dto;

import dev.aubique.conj.model.VerbMax;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class VerbDto<T> extends DefaultDto<VerbMax> {

    public VerbDto(String level, String name, List<VerbMax> list) {
        super(level, name, list);
    }
}
