package library.zeroone.test.Service.Impl;

import library.zeroone.test.DTO.BookDTO;
import library.zeroone.test.Entities.Book;
import library.zeroone.test.Mapper.BookMapper;
import library.zeroone.test.Repository.BookRepository;
import library.zeroone.test.Service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAll().stream().map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
    }
}
