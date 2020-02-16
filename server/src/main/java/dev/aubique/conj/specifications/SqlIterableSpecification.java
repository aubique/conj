package dev.aubique.conj.specifications;

import dev.aubique.conj.entity.Verb;

public interface SqlIterableSpecification extends SqlSpecification {

    void constructQueries(Verb verbEntity);

    boolean hasNextQuery();
}
