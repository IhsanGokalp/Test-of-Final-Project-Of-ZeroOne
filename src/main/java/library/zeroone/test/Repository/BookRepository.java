package library.zeroone.test.Repository;

import library.zeroone.test.Entities.Author;
import library.zeroone.test.Entities.Book;
import library.zeroone.test.Enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor(Author author);
    List<Book> findAllByName(String name);
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByNameContainsIgnoreCase(String searchString);
}
