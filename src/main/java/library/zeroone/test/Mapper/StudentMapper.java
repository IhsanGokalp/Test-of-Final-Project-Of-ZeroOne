package library.zeroone.test.Mapper;

import library.zeroone.test.DTO.Student.StudentDTO;
import library.zeroone.test.DTO.Student.StudentInitializeDTO;
import library.zeroone.test.DTO.Student.StudentUpdateDTO;
import library.zeroone.test.Entities.Student;

public interface StudentMapper {
    StudentDTO toStudentDTO(Student student);
    Student toStudent(StudentInitializeDTO studentInitializeDTO);
    Student toStudent(Student studentUpdated, StudentUpdateDTO studentUpdateDTO);
}
