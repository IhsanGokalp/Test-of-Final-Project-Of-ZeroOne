package library.zeroone.test.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDTO {
    private Long id;
    private String firstName;
    private String surname;
    private String fullName;
    private String universityId;
}
