package library.zeroone.test.Service;

import library.zeroone.test.DTO.StudentDTO;
import library.zeroone.test.DTO.StudentInitializeDTO;
import library.zeroone.test.DTO.StudentUpdateDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findAll();

    StudentDTO save(StudentInitializeDTO studentInitializeDTO);

    StudentDTO findById(Long id);

    StudentDTO update(Long id, StudentUpdateDTO studentUpdateDTO);
}
