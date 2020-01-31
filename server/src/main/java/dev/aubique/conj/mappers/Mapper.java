package dev.aubique.conj.mappers;

import java.sql.SQLException;

@FunctionalInterface
public interface Mapper<From, To> {
    To map(From from) throws SQLException;
}
