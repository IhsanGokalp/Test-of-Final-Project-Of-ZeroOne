package library.zeroone.test.FilterRequest.Book;

import library.zeroone.test.Enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookSearchRequest {
    private String searchString;
    private List<Long> authorIds;
    private List<Category> categories;

}
