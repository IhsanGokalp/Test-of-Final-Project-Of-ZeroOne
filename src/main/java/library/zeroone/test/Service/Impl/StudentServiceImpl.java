package library.zeroone.test.Service.Impl;

import library.zeroone.test.DTO.StudentDTO;
import library.zeroone.test.Mapper.StudentMapper;
import library.zeroone.test.Repository.StudentRepository;
import library.zeroone.test.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toStudentDTO).collect(Collectors.toList());
    }
}
