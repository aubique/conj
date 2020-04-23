package dev.aubique.conj.services;

public interface MapperService<From, To> {

    To mapToMax(From object);
    To mapToMin(From object);
}
