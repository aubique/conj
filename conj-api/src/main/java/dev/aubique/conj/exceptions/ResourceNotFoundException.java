package dev.aubique.conj.exceptions;

import dev.aubique.conj.model.VerbEntity;

/**
 * Exception 404 thrown if there is no {@link VerbEntity} found within ASL
 * It indicated that the input value is not correct though
 */
public class ResourceNotFoundException extends Exception {
}
