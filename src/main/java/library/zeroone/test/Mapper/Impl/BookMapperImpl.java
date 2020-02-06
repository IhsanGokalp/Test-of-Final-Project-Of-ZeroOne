package library.zeroone.test.Mapper.Impl;

import library.zeroone.test.DTO.Book.BookDTO;
import library.zeroone.test.DTO.Book.BookInitializeDTO;
import library.zeroone.test.DTO.Book.BookUpdateDTO;
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
        bookToBeUpdated.setName(bookUpdateDTO.getName());
        bookToBeUpdated.setCategory(bookUpdateDTO.getCategory());
        bookToBeUpdated.setAuthor(bookUpdateDTO.getAuthor());
        return bookToBeUpdated;
    }
}
