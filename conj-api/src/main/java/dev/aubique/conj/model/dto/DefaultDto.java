package dev.aubique.conj.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Parent POJO for {@link TenseDto}, {@link GroupDto}, {@link VerbDto}
 * These 3 DTO classes are inherited from the default abstract DTO
 *
 * @param <T> DTO contains other types of DTO or {@code List<String>}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class DefaultDto<T> {
    String level;
    String name;
    List<T> list;
}
