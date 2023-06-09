package edu.neu.csye6200.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.repository.TeacherRepository;
import edu.neu.csye6200.service.factory.TeacherFactory;
import edu.neu.csye6200.service.singleton.PersonFactorySingleton;

@Service
public class TeacherService {
	@Autowired
	TeacherRepository teacherRepository;
	TeacherFactory tf = PersonFactorySingleton.getInstance().getTeacherFactory();

	public List<Teacher> getAllTeachers() {
		List<Teacher> teachers = new ArrayList<>();
		teacherRepository.findAll().forEach(teachers::add);
		return teachers;
	}

	public void saveTeachers(List<Teacher> teachers) {
		teacherRepository.saveAll(teachers);
	}

	public void saveTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}

	public void saveTeacher(String csv) {
		teacherRepository.save(tf.getObject(csv));
	}

	public Optional<Teacher> getTeacherById(int id) {
		return teacherRepository.findById(id);
	}

	public void deleteTeacherById(int id) {
		teacherRepository.deleteById(id);
	}

}
