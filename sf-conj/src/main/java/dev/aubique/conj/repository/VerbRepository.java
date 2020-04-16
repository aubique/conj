package dev.aubique.conj.repository;

import dev.aubique.conj.model.VerbMax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerbRepository extends JpaRepository<VerbMax, Long> {

    Optional<VerbMax> findVerbByName(String name);
}
