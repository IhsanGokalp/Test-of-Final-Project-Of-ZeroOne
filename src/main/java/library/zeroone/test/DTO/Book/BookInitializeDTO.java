package library.zeroone.test.DTO.Book;

import library.zeroone.test.Entities.Author;
import library.zeroone.test.Enums.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInitializeDTO {
    private String name;
    private Author author;
    private Category category;
}
