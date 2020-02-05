package library.zeroone.test.Mapper;

import library.zeroone.test.DTO.StudentDTO;
import library.zeroone.test.DTO.StudentInitializeDTO;
import library.zeroone.test.DTO.StudentUpdateDTO;
import library.zeroone.test.Entities.Student;

public interface StudentMapper {
    StudentDTO toStudentDTO(Student student);
    Student toStudent(StudentInitializeDTO studentInitializeDTO);
    Student toStudent(Student studentUpdated, StudentUpdateDTO studentUpdateDTO);
}
