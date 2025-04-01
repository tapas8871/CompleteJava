package net.javaguides.spring_boot_rest_api.controller;


import net.javaguides.spring_boot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @GetMapping("/Student-details")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(23, "Astha", "Chourey");
        // return new ResponseEntity<>(student,HttpStatus.OK);// These both are same
        return ResponseEntity.ok().header("custum-header", "ramesh")
                .body(student);
    }

    @GetMapping
    public List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Tapas", "Nalge"));
        students.add(new Student(2, "Astha", "Chourey"));
        students.add(new Student(1, "Shivani", "pawar"));

        return students;
    }
    // Spring Boot rest api with path variable

    @GetMapping("/{id}/{first-name}/{last-name}")
    public Student studentPathvariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }


    // @Pathvarible is used to bind the URI parameters to method argument
    // @RequestParam is used to extract the value of query parameter to method


    // Spring Boot REST API with Request Param
    //http://localhost:8080/students/query?id=1   ....This is called query param
    @GetMapping("/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }

    // Spring Boot REST API that handles HTTP POST Request
    //@PostMapping and @RequestBody

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // for Put Request
    @PutMapping("/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }


    // for deleting the resource
    @DeleteMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        return "Student deleted successfully";
    }

    // @ResponseEntity represents the whole HTTP response status code and body. we can manipulate the response here.
    // ResponseEntity is the generic we can pass anything
}

// Base URL at the class level