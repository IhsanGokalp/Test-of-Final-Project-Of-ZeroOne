package library.zeroone.test.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tblstudents")
public class Student extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "university_id", unique = true)
    private String universityId;
}
