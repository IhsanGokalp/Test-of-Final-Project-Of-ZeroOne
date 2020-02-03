package library.zeroone.test.Service;

import library.zeroone.test.DTO.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findAll();
}
