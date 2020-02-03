package library.zeroone.test.Mapper;

import library.zeroone.test.DTO.StudentDTO;
import library.zeroone.test.Entities.Student;

public interface StudentMapper {
    StudentDTO toStudentDTO(Student student);
}
