package library.zeroone.test.Service;


import library.zeroone.test.DTO.BookDTO;
import library.zeroone.test.DTO.BookInitializeDTO;
import library.zeroone.test.DTO.BookUpdateDTO;
import library.zeroone.test.Entities.Book;

import java.util.List;

public interface BookService {
    List<BookDTO> findAll();
    BookDTO save(BookInitializeDTO bookInitializeDTO);
    BookDTO update(Long id, BookUpdateDTO bookUpdateDTO);
}
