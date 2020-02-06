package library.zeroone.test.Mapper;

import library.zeroone.test.DTO.Book.BookDTO;
import library.zeroone.test.DTO.Book.BookInitializeDTO;
import library.zeroone.test.DTO.Book.BookUpdateDTO;
import library.zeroone.test.Entities.Book;

public interface BookMapper {
    BookDTO toBookDTO(Book book);

    Book toBook(BookInitializeDTO bookInitializeDTO);
    Book toBook(Book bookToBeUpdated, BookUpdateDTO bookUpdateDTO);
}
