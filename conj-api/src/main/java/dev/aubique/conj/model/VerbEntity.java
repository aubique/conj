package dev.aubique.conj.model;

import dev.aubique.conj.model.dto.VerbDto;
import dev.aubique.conj.services.VerbService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Simple JavaBean domain object representing Verb
 * This POJO is handled by {@link VerbService} to be be parsed or extracted from DB
 * It stores the tenses as {@code List<String>} in Persistence
 * The data object is converted to corresponding DTO {@link VerbDto} afterwards
 */
// Annotations to build and test
@Builder
@NoArgsConstructor
@AllArgsConstructor
// Default annotations
@Data
@Entity
@Table(name = "verb")
public class VerbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

    // Indicative group
    @ElementCollection
    private List<String> indPresentList;
    @ElementCollection
    private List<String> indPresentPerfectList;
    @ElementCollection
    private List<String> indImperfectList;
    @ElementCollection
    private List<String> indPluperfectList;
    @ElementCollection
    private List<String> indSimplePastList;
    @ElementCollection
    private List<String> indPastPerfectList;
    @ElementCollection
    private List<String> indFutureList;
    @ElementCollection
    private List<String> indPastFutureList;

    // Subjunctive group
    @ElementCollection
    private List<String> subPresentList;
    @ElementCollection
    private List<String> subPastList;
    @ElementCollection
    private List<String> subImperfectList;
    @ElementCollection
    private List<String> subPluperfectList;

    // Conditional Imperative group
    @ElementCollection
    private List<String> conPresentList;
    @ElementCollection
    private List<String> conPastList;
    @ElementCollection
    private List<String> impPresentList;
}
