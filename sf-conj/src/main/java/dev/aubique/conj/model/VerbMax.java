package dev.aubique.conj.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

// Annotations to build and test
@Builder
@NoArgsConstructor
@AllArgsConstructor
// Default annotations
@Data
@Entity
@Table(name = "verb")
public class VerbMax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

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

    @ElementCollection
    private List<String> subPresentList;
    @ElementCollection
    private List<String> subPastList;
    @ElementCollection
    private List<String> subImperfectList;
    @ElementCollection
    private List<String> subPluperfectList;

    @ElementCollection
    private List<String> conPresentList;
    @ElementCollection
    private List<String> conPastList;

    @ElementCollection
    private List<String> impPresentList;
}
