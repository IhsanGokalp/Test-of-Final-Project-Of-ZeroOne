package library.zeroone.test.FilterRequest.Book;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

@Setter
@Getter
public class BookFilterRequest {
    private PageRequest pageRequest;
    private BookSearchRequest bookSearchRequest;
}
