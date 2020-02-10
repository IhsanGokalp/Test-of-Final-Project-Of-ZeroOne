package library.zeroone.test.Service;

import library.zeroone.test.DTO.Author.AuthorDTO;
import library.zeroone.test.DTO.Author.AuthorFindingByFullNameDTO;
import library.zeroone.test.DTO.Author.AuthorInitializeDTO;
import library.zeroone.test.DTO.Author.AuthorUpdateDTO;
import library.zeroone.test.DTO.Book.BookIdsDTO;
import library.zeroone.test.Entities.Author;

import java.util.List;

public interface AuthorService {
    void bindBooksWithAuthor(Long id, BookIdsDTO bookIdsDTO);
    AuthorDTO save(AuthorInitializeDTO author);
    List<AuthorDTO> findAll();
    AuthorDTO findById(Long id);
    AuthorDTO update(Long id, AuthorUpdateDTO authorUpdateDTO);
    void delete(Long id);
    List<AuthorDTO> findAllByFullName(AuthorFindingByFullNameDTO authorFindingByFullNameDTO);
}
