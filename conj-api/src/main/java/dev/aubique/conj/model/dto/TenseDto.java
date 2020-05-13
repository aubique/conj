package dev.aubique.conj.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TenseDto<T> extends DefaultDto<String> {

    public TenseDto(String level, String name, List<String> list) {
        super(level, name, list);
    }
}
