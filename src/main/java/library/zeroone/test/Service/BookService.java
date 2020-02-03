package library.zeroone.test.Service;


import library.zeroone.test.DTO.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> findAll();
}
