package library.zeroone.test.Service.Impl;

import library.zeroone.test.DTO.Author.AuthorDTO;
import library.zeroone.test.Entities.Author;
import library.zeroone.test.Mapper.AuthorMapper;
import library.zeroone.test.Repository.AuthorRepository;
import library.zeroone.test.Service.AuthorService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<AuthorDTO> findAll() {
        return authorRepository.findAll().
                stream().map(authorMapper::toAuthorDTO).collect(Collectors.toList());
    }

    @Override
    public AuthorDTO findById(Long id) {
        Author author = authorRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("No data found with the id " + id));
        return authorMapper.toAuthorDTO(author);
    }
}
