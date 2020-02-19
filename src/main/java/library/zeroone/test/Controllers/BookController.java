package library.zeroone.test.Controllers;

import library.zeroone.test.DTO.Book.*;
import library.zeroone.test.FilterRequest.Book.BookFilterRequest;
import library.zeroone.test.Service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
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

    @GetMapping("{/id}")
    private BookDTO findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    private BookDTO update(@PathVariable Long id, @RequestBody BookUpdateDTO bookUpdateDTO) {
        return bookService.update(id, bookUpdateDTO);
    }

    @PutMapping("/{id}/updateQuantity")
    private void updateQuantity(@RequestBody @Validated BookQuantityUpdatingDTO dto,
                                @PathVariable Long id) {
        bookService.updateQuantity(id, dto);
    }

    @GetMapping("/searchByName")
    private List<BookDTO> findBooksByName(
            @RequestBody BookFindingByNameDTO bookFindingByNameDTO) {
        return bookService.findAllByName(bookFindingByNameDTO);
    }

    @GetMapping("/searchByCategory")
    private List<BookDTO> findBooksByCategory(
            @RequestBody BookFindingByCategoryDTO bookFindingByCategoryDTO) {
        return bookService.findAllByCategory(bookFindingByCategoryDTO);
    }

    @PostMapping("/search")
    private Page<BookDTO> search(@RequestBody BookFilterRequest bookFilterRequest) {
        return bookService.search(bookFilterRequest);
    }
}
