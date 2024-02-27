package com.Users.CRUDdemo;

import com.Users.CRUDdemo.dao.StudentDAO;
import com.Users.CRUDdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruDdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDdemoApplication.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("delete all student");
		int numRowsDelete=studentDAO.deleteAll();
		System.out.println("delete row count: "+numRowsDelete);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=2;
		System.out.println("deleting student id:" + studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("git student id" +studentId);
		Student myStudent=studentDAO.findById(studentId);

		myStudent.setFirstname("samy");
		studentDAO.update(myStudent);
		System.out.println(myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student>theStudent=studentDAO.findByLastName("wael");


		for(Student temStudent:theStudent){
			System.out.println(temStudent);
		}

	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get a list student

		List<Student> theStudent=studentDAO.findAll();
		for(Student temStudent:theStudent){
			System.out.println(temStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		Student student1=new Student("iman","fathy","jd@ghgh.com");
		// save the student
		studentDAO.save(student1);

		// display id of the saved student

		int theId =student1.getId();
		System.out.println("Generate id: "+theId);
		// retrieve student based on the id :primary key
		System.out.println("Retrieve student" + theId);

		Student myStudent =studentDAO.findById(theId);

		// display student
		System.out.println(myStudent);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		Student student1=new Student("ahmed","wael","ah@wael123" );
		Student student2=new Student("nada","yaser","na@wael123" );
		Student student3=new Student("ahmed","bsha","ah@wael123" );
		Student student4=new Student("fathy","wael","ah@wael123" );

		//save the student object
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);


	}

	private void createStudent(StudentDAO studentDAO) {
		Student student=new Student("ahmed","wael","ah@wael123" );
		studentDAO.save(student);
		System.out.println("Generate ID: "+ student.getId());
	}


}



