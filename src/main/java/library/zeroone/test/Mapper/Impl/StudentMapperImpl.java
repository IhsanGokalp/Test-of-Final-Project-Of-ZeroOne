package library.zeroone.test.Mapper.Impl;

import library.zeroone.test.DTO.StudentDTO;
import library.zeroone.test.DTO.StudentInitializeDTO;
import library.zeroone.test.DTO.StudentUpdateDTO;
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

    @Override
    public Student toStudent(StudentInitializeDTO studentInitializeDTO) {
        Student result = new Student();
        result.setFirstName(studentInitializeDTO.getFirstName());
        result.setSurname(studentInitializeDTO.getSurname());
        result.setUniversityId(studentInitializeDTO.getUniversityId());
        return result;
    }

    @Override
    public Student toStudent(Student studentUpdated,StudentUpdateDTO studentUpdateDTO) {
        studentUpdated.setFirstName(studentUpdateDTO.getFirstName());
        studentUpdated.setSurname(studentUpdateDTO.getSurname());
        studentUpdated.setUniversityId(studentUpdateDTO.getUniversityId());
        return studentUpdated;
    }
}
