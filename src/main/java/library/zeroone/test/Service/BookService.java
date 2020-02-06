package library.zeroone.test.Service;


import library.zeroone.test.DTO.Book.BookDTO;
import library.zeroone.test.DTO.Book.BookInitializeDTO;
import library.zeroone.test.DTO.Book.BookQuantityUpdatingDTO;
import library.zeroone.test.DTO.Book.BookUpdateDTO;


import java.util.List;

public interface BookService {
    List<BookDTO> findAll();
    BookDTO save(BookInitializeDTO bookInitializeDTO);
    BookDTO update(Long id, BookUpdateDTO bookUpdateDTO);
    BookDTO findById(Long id);
    void updateQuantity(Long id, BookQuantityUpdatingDTO dto);
}
