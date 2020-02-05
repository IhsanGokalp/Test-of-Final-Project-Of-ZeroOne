package library.zeroone.test.Controllers;

import library.zeroone.test.DTO.StudentDTO;
import library.zeroone.test.DTO.StudentInitializeDTO;
import library.zeroone.test.DTO.StudentUpdateDTO;
import library.zeroone.test.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    @PostMapping()
    public StudentDTO save(@RequestBody StudentInitializeDTO studentInitializeDTO) {
        return studentService.save(studentInitializeDTO);
    }

    @GetMapping("/{id}")
    private StudentDTO findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PutMapping("/{id}")
    private StudentDTO update(@PathVariable Long id, @RequestBody StudentUpdateDTO studentUpdateDTO) {
        return studentService.update(id, studentUpdateDTO);
    }

}
