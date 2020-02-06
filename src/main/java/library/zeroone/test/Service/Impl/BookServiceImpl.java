package library.zeroone.test.Service.Impl;

import library.zeroone.test.DTO.Book.BookDTO;
import library.zeroone.test.DTO.Book.BookInitializeDTO;
import library.zeroone.test.DTO.Book.BookQuantityUpdatingDTO;
import library.zeroone.test.DTO.Book.BookUpdateDTO;
import library.zeroone.test.Entities.Book;
import library.zeroone.test.Mapper.BookMapper;
import library.zeroone.test.Repository.BookRepository;
import library.zeroone.test.Service.BookService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    @Override
    public BookDTO save(BookInitializeDTO bookInitializeDTO) {
        Book book = bookMapper.toBook(bookInitializeDTO);
        Book bookSaved = bookRepository.save(book);
        return bookMapper.toBookDTO(bookSaved);
    }

    @Override
    public BookDTO update(Long id, BookUpdateDTO bookUpdateDTO) {
        Book bookToBeUpdated = bookRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("No data found with the id " + id));

        Book bookUpdated = bookMapper.toBook(bookToBeUpdated, bookUpdateDTO);
        Book updatedBook = bookRepository.save(bookUpdated);
        return bookMapper.toBookDTO(updatedBook);
    }

    @Override
    public BookDTO findById(Long id) {
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("No data found with the id " + id));

        return bookMapper.toBookDTO(book);
    }

    @Override
    public void updateQuantity(Long id, BookQuantityUpdatingDTO dto) {
        Book updatingBook = bookRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("No data found with the id " + id));

        updatingBook.setQuantity(dto.getQuantity());
        bookRepository.save(updatingBook);
    }
}