package com.simplilearn.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classes")
public class Classes {
	
	@Id
	@GeneratedValue
	@Column(name="class_id")
	private int classId;
	
	@Column(name="class_name")
	private String className;
	
	@ManyToMany(targetEntity=Teacher.class)
	private List<Teacher> teachers;
	
	
	@OneToMany(targetEntity=Subject.class)
	private List<Subject> subjects;
	
	@OneToMany(targetEntity=Student.class)
	private List<Student> students;
	
	public Classes() {
		
	}
	public Classes(String className, List<Teacher> teachers, List<Student> students, List<Subject> subjects) {
		this.className = className;
		this.teachers = teachers;
		this.students = students;
		this.subjects = subjects;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public Classes(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}
	
	public void addTeacher(Teacher teacher) {
		this.teachers.add(teacher);
	}
	
	
	@Override
	public String toString() {
		return  className;
	}

	
}
