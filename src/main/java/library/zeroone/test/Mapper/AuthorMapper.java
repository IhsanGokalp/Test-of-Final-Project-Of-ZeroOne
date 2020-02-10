package library.zeroone.test.Mapper;

import library.zeroone.test.DTO.Author.AuthorDTO;
import library.zeroone.test.DTO.Author.AuthorInitializeDTO;
import library.zeroone.test.DTO.Author.AuthorUpdateDTO;
import library.zeroone.test.Entities.Author;
import library.zeroone.test.Entities.Book;

import java.util.List;

public interface AuthorMapper {
    AuthorDTO toAuthorDTO(Author author, List<Book> books);
    Author toAuthor(AuthorInitializeDTO authorInitializeDTO);
    Author toAuthor(Author author, AuthorUpdateDTO authorUpdateDTO);
    AuthorDTO toAuthorDTO(Author author);
}
