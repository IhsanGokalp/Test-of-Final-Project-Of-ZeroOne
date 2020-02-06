package library.zeroone.test.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tblauthors")
public class Author extends BaseEntity {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "deathDate")
    private LocalDate deathDate;

    private String bibliography;
}
