package library.zeroone.test.Repository;

import library.zeroone.test.DTO.Author.AuthorFindingByFullNameDTO;
import library.zeroone.test.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByFirstNameAndLastName(String firstName, String lastName);
}
