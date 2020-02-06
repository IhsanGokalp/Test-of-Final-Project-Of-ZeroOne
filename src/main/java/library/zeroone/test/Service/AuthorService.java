package library.zeroone.test.Service;

import library.zeroone.test.DTO.Author.AuthorDTO;
import library.zeroone.test.Entities.Author;

import java.util.List;

public interface AuthorService {
    Author save(Author author);
    List<AuthorDTO> findAll();
    AuthorDTO findById(Long id);
}
