package library.zeroone.test.DTO.Book;

import library.zeroone.test.Enums.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookFindingByCategoryDTO {
    private Category category;
}
