package dev.aubique.conj.services;

public interface Mapper<From, To> {

    To map(From object);
}
