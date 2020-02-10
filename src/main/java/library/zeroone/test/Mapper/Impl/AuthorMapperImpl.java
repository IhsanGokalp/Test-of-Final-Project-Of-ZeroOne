package library.zeroone.test.Mapper.Impl;

import library.zeroone.test.DTO.Author.AuthorDTO;
import library.zeroone.test.DTO.Author.AuthorInitializeDTO;
import library.zeroone.test.DTO.Author.AuthorUpdateDTO;
import library.zeroone.test.DTO.Book.BookDTO;
import library.zeroone.test.Entities.Author;
import library.zeroone.test.Entities.Book;
import library.zeroone.test.Mapper.AuthorMapper;
import library.zeroone.test.Mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorMapperImpl implements AuthorMapper {

    private final BookMapper bookMapper;

    public AuthorMapperImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }


    @Override
    public AuthorDTO toAuthorDTO(Author author, List<Book> books) {
        List<BookDTO> bookDTOs = books.stream()
                .map(bookMapper::toBookDTO)
                .collect(Collectors.toList());
        AuthorDTO result = new AuthorDTO();
        result.setBibliography(author.getBibliography());
        result.setBirthDate(author.getBirthDate());
        result.setDeathDate(author.getDeathDate());
        result.setFirstName(author.getFirstName());
        result.setId(author.getId());
        result.setBookDTOs(bookDTOs);
        result.setLastName(author.getLastName());
        return result;
    }

    @Override
    public Author toAuthor(AuthorInitializeDTO authorInitializeDTO) {
        Author author = new Author();
        author.setBibliography(authorInitializeDTO.getBibliography());
        author.setBirthDate(authorInitializeDTO.getBirthDate());
        author.setDeathDate(authorInitializeDTO.getDeathDate());
        author.setFirstName(authorInitializeDTO.getFirstName());
        author.setLastName(authorInitializeDTO.getLastName());
        return author;
    }

    @Override
    public Author toAuthor(Author author, AuthorUpdateDTO authorUpdateDTO) {
        author.setLastName(authorUpdateDTO.getLastName());
        author.setFirstName(authorUpdateDTO.getFirstName());
        author.setDeathDate(authorUpdateDTO.getDeathDate());
        author.setBirthDate(authorUpdateDTO.getBirthDate());
        author.setBibliography(authorUpdateDTO.getBibliography());
        return author;
    }

    @Override
    public AuthorDTO toAuthorDTO(Author author) {
        AuthorDTO result = new AuthorDTO();
        result.setBibliography(author.getBibliography());
        result.setBirthDate(author.getBirthDate());
        result.setDeathDate(author.getDeathDate());
        result.setFirstName(author.getFirstName());
        result.setId(author.getId());
        result.setLastName(author.getLastName());
        return result;
    }
}
