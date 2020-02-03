package library.zeroone.test.Mapper.Impl;

import library.zeroone.test.DTO.StudentDTO;
import library.zeroone.test.Entities.Student;
import library.zeroone.test.Mapper.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO toStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setSurname(student.getSurname());
        studentDTO.setFullName(student.getFirstName() + " " + student.getSurname());
        studentDTO.setUniversityId(student.getUniversityId());
        studentDTO.setId(student.getId());
        return studentDTO;
    }
}
