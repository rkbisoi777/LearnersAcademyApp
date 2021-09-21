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
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue
	@Column(name="subject_id")
	private int subjectId;
	
	@Column(name="subject_name")
	private String subjectName;
	
	
	@ManyToMany(targetEntity=Teacher.class)
	private List<Teacher> teachers;
	
	@OneToMany(targetEntity=Classes.class)
	private List<Classes> classess; 
	

	public Subject() {
	}
	
	public Subject(String subjectName, List<Teacher> teachers, List<Classes> classess) {
		this.classess = classess;
		this.subjectName = subjectName;
		this.teachers = teachers;
	}

	public Subject(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Classes> getClassess() {
		return classess;
	}

	public void setClassess(List<Classes> classess) {
		this.classess = classess;
	}
	
	public void addClasses(Classes classes) {
		this.classess.add(classes);
	}
	
	public void addTeacher(Teacher teacher) {
		this.teachers.add(teacher);
	}
}
