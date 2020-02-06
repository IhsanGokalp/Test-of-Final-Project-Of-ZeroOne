package library.zeroone.test.Service;

import library.zeroone.test.DTO.Student.StudentDTO;
import library.zeroone.test.DTO.Student.StudentInitializeDTO;
import library.zeroone.test.DTO.Student.StudentUpdateDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findAll();

    StudentDTO save(StudentInitializeDTO studentInitializeDTO);

    StudentDTO findById(Long id);

    StudentDTO update(Long id, StudentUpdateDTO studentUpdateDTO);
}
