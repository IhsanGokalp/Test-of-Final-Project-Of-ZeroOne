package library.zeroone.test.Mapper.Impl;

import library.zeroone.test.DTO.BookDTO;
import library.zeroone.test.Entities.Book;
import library.zeroone.test.Mapper.BookMapper;
import org.springframework.stereotype.Service;

@Service
public class BookMapperImpl implements BookMapper {
    @Override
    public BookDTO toBookDTO(Book book) {

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setCategory(book.getCategory());

        return bookDTO;
    }
}
