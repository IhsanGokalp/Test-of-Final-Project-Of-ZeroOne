package library.zeroone.test.Mapper.Impl;

import library.zeroone.test.DTO.Author.AuthorDTO;
import library.zeroone.test.Entities.Author;
import library.zeroone.test.Mapper.AuthorMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthorMapperImpl implements AuthorMapper {

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
