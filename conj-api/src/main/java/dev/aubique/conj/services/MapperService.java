package dev.aubique.conj.services;

/**
 * Service to convert Business Entity to Data Transfer Object
 * These DTO are exposed on API afterwards
 */
public interface MapperService<From, To> {

    /**
     * Convert BO to the EXTENDED DTO form for API
     *
     * @param object Business Object entity
     * @return extended form of Data Transfer Object
     */
    To mapToMax(From object);

    /**
     * Convert BO to the MINIMAL DTO form for API
     *
     * @param object Business Object entity
     * @return minimal form of Data Transfer Object
     */
    To mapToMin(From object);
}
