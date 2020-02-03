package library.zeroone.test.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private Long id;
    private String name;
    private String author;
    private String category;
}
