package library.zeroone.test.Mapper;

import library.zeroone.test.DTO.BookDTO;
import library.zeroone.test.Entities.Book;

public interface BookMapper {
    BookDTO toBookDTO(Book book);
}
