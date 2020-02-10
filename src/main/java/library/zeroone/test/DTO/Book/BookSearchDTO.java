package library.zeroone.test.DTO.Book;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookSearchDTO {
    private String searchString;
    private List<Long> studentIds;
}
