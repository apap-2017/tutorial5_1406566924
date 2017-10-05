package com.tutorial5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tutorial5.model.StudentModel;

@Mapper
public interface StudentMapper {
	@Select("SELECT npm, name, gpa FROM student WHERE npm = #{npm}")
	StudentModel selectStudent(@Param("npm") String npm);

	@Select("SELECT npm, name, gpa FROM student")
	List<StudentModel> selectAllStudents();

	@Insert("INSERT INTO student (npm, name, gpa) VALUES (#{npm}, #{name}, #{gpa})")
	void addStudent(StudentModel student);

	@Delete("DELETE FROM student WHERE npm = #{npm}")
	void deleteStudent(@Param("npm") String npm);

	@Update("UPDATE student SET npm=#{npm}, name=#{name}, gpa=#{gpa} WHERE npm=#{npm}")
	void updateStudent(StudentModel student);
}
