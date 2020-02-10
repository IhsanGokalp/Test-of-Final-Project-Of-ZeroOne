package library.zeroone.test.Controllers;

import library.zeroone.test.DTO.Author.AuthorDTO;
import library.zeroone.test.DTO.Author.AuthorFindingByFullNameDTO;
import library.zeroone.test.DTO.Author.AuthorInitializeDTO;
import library.zeroone.test.DTO.Author.AuthorUpdateDTO;
import library.zeroone.test.DTO.Book.BookIdsDTO;
import library.zeroone.test.Service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    private List<AuthorDTO> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    private AuthorDTO findById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PostMapping
    private AuthorDTO save(@RequestBody AuthorInitializeDTO authorInitializeDTO){
        return authorService.save(authorInitializeDTO);
    }

    @PutMapping("/{id}")
    private AuthorDTO update(@RequestBody AuthorUpdateDTO authorUpdateDTO, @PathVariable Long id) {
        return authorService.update(id, authorUpdateDTO);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

    @PutMapping("/authorUpdate/{id}")
    private void bindBooksWithAuthor(@PathVariable Long id, @RequestBody BookIdsDTO bookIdsDTO) {
        authorService.bindBooksWithAuthor(id, bookIdsDTO);
    }

    @GetMapping("/searchByFullName")
    private List<AuthorDTO> searchByFullName(
            @RequestBody AuthorFindingByFullNameDTO authorFindingByFullNameDTO) {
        return authorService.findAllByFullName(authorFindingByFullNameDTO);
    }
}
