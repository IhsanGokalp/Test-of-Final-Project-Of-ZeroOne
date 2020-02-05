package library.zeroone.test.Mapper.Impl;

import library.zeroone.test.DTO.BookDTO;
import library.zeroone.test.DTO.BookInitializeDTO;
import library.zeroone.test.DTO.BookUpdateDTO;
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

    @Override
    public Book toBook(BookInitializeDTO bookInitializeDTO) {
        Book book = new Book();
        book.setAuthor(bookInitializeDTO.getAuthor());
        book.setCategory(bookInitializeDTO.getCategory());
        book.setName(bookInitializeDTO.getName());
        return book;
    }

    @Override
    public Book toBook(Book bookToBeUpdated, BookUpdateDTO bookUpdateDTO) {
        Book book = new Book();
        book.setName(bookUpdateDTO.getName());
        book.setCategory(bookUpdateDTO.getCategory());
        book.setAuthor(bookUpdateDTO.getAuthor());
        return book;
    }
}
