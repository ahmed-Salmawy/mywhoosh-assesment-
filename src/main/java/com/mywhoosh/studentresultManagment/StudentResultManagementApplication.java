package com.mywhoosh.studentresultManagment;


import com.mywhoosh.studentresultManagment.domain.repoadapter.StudentRepoAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class StudentResultManagementApplication implements CommandLineRunner {

    @Autowired
    StudentRepoAdapter studentRepoAdapter;

    public static void main(String[] args) {
        SpringApplication.run(StudentResultManagementApplication.class, args);


    }


    @Override
    public void run(String... args) throws Exception {
       // studentRepoAdapter.getActiveStudentsWithResults().forEach(s -> log.info(s.toString()));
    }
}
