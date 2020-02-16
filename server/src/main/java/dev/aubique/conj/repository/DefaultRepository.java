package dev.aubique.conj.repository;

import dev.aubique.conj.specifications.SqlSpecification;

import java.util.List;

public interface DefaultRepository<T> {

    void add(T entity);

    void update(T entity);

    void remove(T entity);

    List<T> query(SqlSpecification specification);
}
