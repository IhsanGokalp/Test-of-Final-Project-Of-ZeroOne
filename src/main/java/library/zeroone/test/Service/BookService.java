package library.zeroone.test.Service;


import library.zeroone.test.DTO.Book.*;
import library.zeroone.test.Entities.Author;
import library.zeroone.test.Entities.Book;
import library.zeroone.test.FilterRequest.Book.BookFilterRequest;
import org.springframework.data.domain.Page;


import java.util.List;

public interface BookService {
    List<BookDTO> findAll();
    BookDTO save(BookInitializeDTO bookInitializeDTO);
    BookDTO update(Long id, BookUpdateDTO bookUpdateDTO);
    BookDTO findById(Long id);
    void updateQuantity(Long id, BookQuantityUpdatingDTO dto);
    List<Book> findAllById(List<Long> ids);
    Book updateAuthorOfBook(Book book, Author author);
    List<Book> findBooksByAuthor(Author author);
    List<BookDTO> findAllByName(BookFindingByNameDTO bookFindingByNameDTO);
    List<BookDTO> findAllByCategory(BookFindingByCategoryDTO bookFindingByCategoryDTO);
    Page<BookDTO> search(BookFilterRequest bookFilterRequest);
}
