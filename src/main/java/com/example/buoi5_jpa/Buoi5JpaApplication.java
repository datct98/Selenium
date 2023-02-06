package com.example.buoi5_jpa;

import com.example.buoi5_jpa.model.Clasz;
import com.example.buoi5_jpa.model.Teacher;
import com.example.buoi5_jpa.repository.ClassRepository;
import com.example.buoi5_jpa.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
public class Buoi5JpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Buoi5JpaApplication.class, args);
    }

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassRepository classRepository;

    @Override
    public void run(String... args) throws Exception {
        Teacher teacher = new Teacher();
        teacher.setAccountNum("4321");
        teacher.setName("Dat2");
        //teacher.setClaszs(Set.of(clasz));

        Teacher teacher2 = new Teacher();
        teacher2.setAccountNum("1234");
        teacher2.setName("Huong2");
        //teacher2.setClaszs(Set.of(clasz));
        teacherRepository.saveAll(Arrays.asList(teacher, teacher2));

        Clasz clasz = new Clasz();
        clasz.setName("15NDC");
        //clasz.setStatus();
        clasz.setTeachers(Set.of(teacher, teacher2));
        classRepository.save(clasz);
    }
}
