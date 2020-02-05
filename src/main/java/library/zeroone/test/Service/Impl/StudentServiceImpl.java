package library.zeroone.test.Service.Impl;

import library.zeroone.test.DTO.StudentDTO;
import library.zeroone.test.DTO.StudentInitializeDTO;
import library.zeroone.test.DTO.StudentUpdateDTO;
import library.zeroone.test.Entities.Student;
import library.zeroone.test.Mapper.StudentMapper;
import library.zeroone.test.Repository.StudentRepository;
import library.zeroone.test.Service.StudentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    @Override
    public StudentDTO save(StudentInitializeDTO studentInitializeDTO) {
        Student ex = studentMapper.toStudent(studentInitializeDTO);
        Student studentSaved = studentRepository.save(ex);
        return studentMapper.toStudentDTO(studentSaved);
    }

    @Override
    public StudentDTO findById(Long id) {
        Student std = studentRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("No data found with the id " + id));
        return studentMapper.toStudentDTO(std);
    }

    @Override
    public StudentDTO update(Long id, StudentUpdateDTO studentUpdateDTO) {
        Student studentToBeUpdated = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No data found with the id " + id));
        Student studentUpdated = studentMapper.toStudent(studentToBeUpdated,studentUpdateDTO);
        Student updatedStudent = studentRepository.save(studentUpdated);
        return studentMapper.toStudentDTO(updatedStudent);
    }
}
