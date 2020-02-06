package library.zeroone.test.Mapper;

import library.zeroone.test.DTO.Author.AuthorDTO;
import library.zeroone.test.Entities.Author;

public interface AuthorMapper {
    AuthorDTO toAuthorDTO(Author author);
}
