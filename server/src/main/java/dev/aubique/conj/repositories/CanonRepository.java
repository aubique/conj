package dev.aubique.conj.repositories;

import dev.aubique.conj.specifications.SqlSpecification;

import java.util.List;

public interface CanonRepository<T> {

    void add(T entity);

    void update(T entity);

    void remove(T entity);

    List<T> query(SqlSpecification specification);
}
