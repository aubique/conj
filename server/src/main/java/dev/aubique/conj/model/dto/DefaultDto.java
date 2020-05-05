package dev.aubique.conj.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class DefaultDto<T> {
    String level;
    String name;
    List<T> list;
}
