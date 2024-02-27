package com.Users.CRUDdemo.dao;

import com.Users.CRUDdemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public class StudentDAOImpl  implements StudentDAO{


    private  EntityManager entityManager;
@Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Student theStudent) {
    entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {

        return entityManager.find(Student.class,id);
    }


    @Override
    public List<Student> findAll() {
    //create query
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM student",Student.class);
        //return the query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
    TypedQuery<Student> theQuery=entityManager.createQuery("FROM student WHERE lastName=:theData",Student.class);
    //set parameter
        theQuery.setParameter("theData",theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
    entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student theStudent=entityManager.find(Student.class,id);
        // delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
    int numRowsDelete=entityManager.createQuery("DELETE FROM student").executeUpdate();


        return numRowsDelete;
    }
}
