package library.zeroone.test.Controllers;

import library.zeroone.test.DTO.BookDTO;
import library.zeroone.test.DTO.BookInitializeDTO;
import library.zeroone.test.DTO.BookUpdateDTO;
import library.zeroone.test.DTO.StudentDTO;
import library.zeroone.test.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<BookDTO> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    private BookDTO save(@RequestBody BookInitializeDTO bookInitializeDTO) {
        return bookService.save(bookInitializeDTO);
    }

    @PutMapping("/{id}")
    public BookDTO update(@PathVariable Long id, @RequestBody BookUpdateDTO bookUpdateDTO) {
        return bookService.update(id, bookUpdateDTO);
    }
}
