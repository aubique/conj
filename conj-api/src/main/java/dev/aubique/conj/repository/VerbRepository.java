package dev.aubique.conj.repository;

import dev.aubique.conj.model.VerbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface access to {@link VerbEntity} data entities
 * Query methods to find a verb by name, check if verb exists
 * There is also a method to find the first verb entity in case there are few of them
 */
@Repository
public interface VerbRepository extends JpaRepository<VerbEntity, Long> {

    Optional<VerbEntity> findVerbByName(String name);

    Optional<VerbEntity> findFirstByName(String name);

    Boolean existsByName(String name);
}
