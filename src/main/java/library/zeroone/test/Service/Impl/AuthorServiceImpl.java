package library.zeroone.test.Service.Impl;

import library.zeroone.test.DTO.Author.AuthorDTO;
import library.zeroone.test.DTO.Author.AuthorFindingByFullNameDTO;
import library.zeroone.test.DTO.Author.AuthorInitializeDTO;
import library.zeroone.test.DTO.Author.AuthorUpdateDTO;
import library.zeroone.test.DTO.Book.BookIdsDTO;
import library.zeroone.test.Entities.Author;
import library.zeroone.test.Entities.Book;
import library.zeroone.test.Mapper.AuthorMapper;
import library.zeroone.test.Repository.AuthorRepository;
import library.zeroone.test.Service.AuthorService;
import library.zeroone.test.Service.BookService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;
    private BookService bookService;

    public AuthorServiceImpl(AuthorRepository authorRepository,
                             AuthorMapper authorMapper, BookService bookService) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.bookService = bookService;
    }

    @Override
    public void bindBooksWithAuthor(Long id, BookIdsDTO bookIdsDTO) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No data found with the id " + id));
        List<Book> books =  bookService.findAllById(bookIdsDTO.getBookIds());
        for (Book book : books) {
            bookService.updateAuthorOfBook(book, author);
        }
    }

    @Override
    public AuthorDTO save(AuthorInitializeDTO authorInitializeDTO) {
        Author author = authorMapper.toAuthor(authorInitializeDTO);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toAuthorDTO(savedAuthor);
    }

    @Override
    public List<AuthorDTO> findAll() {
        List<Author> authors = authorRepository.findAll();
        return conversionOfAuthors(authors);
    }

    @Override
    public AuthorDTO findById(Long id) {
        Author author = authorRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("No data found with the id " + id));
        List<Book> books = bookService.findBooksByAuthor(author);
        AuthorDTO result = authorMapper.toAuthorDTO(author,books);
        return result;
    }

    @Override
    public AuthorDTO update(Long id, AuthorUpdateDTO authorUpdateDTO) {
        Author author = authorRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("No data found with the id " + id));

        Author updatedAuthor = authorMapper.toAuthor(author, authorUpdateDTO);
        Author savedAuthor = authorRepository.save(updatedAuthor);
        return authorMapper.toAuthorDTO(savedAuthor);
    }

    @Override
    public void delete(Long id) {
        Author authorToBeDeleted = authorRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("No data found with the id " + id));
        authorRepository.delete(authorToBeDeleted);
    }

    @Override
    public List<AuthorDTO> findAllByFullName(AuthorFindingByFullNameDTO authorFindingByFullNameDTO) {
        List<Author> authorsFound = authorRepository.findAllByFirstNameAndLastName(
                authorFindingByFullNameDTO.getFirstName(),authorFindingByFullNameDTO.getLastName());

        return conversionOfAuthors(authorsFound);
    }

    private List<AuthorDTO> conversionOfAuthors(List<Author> authors) {
        List<AuthorDTO> dtos = new ArrayList<>();

        for (Author author : authors) {
            List<Book> currAdminBooks = bookService.findBooksByAuthor(author);
            AuthorDTO authorDTO = authorMapper.toAuthorDTO(author, currAdminBooks);
            dtos.add(authorDTO);
        }
        return dtos;
    }
}
