package library.zeroone.test.DTO.Author;

import library.zeroone.test.DTO.Book.BookDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String bibliography;
    private List<BookDTO> bookDTOs;
}
