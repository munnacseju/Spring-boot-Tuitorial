package munna.test.ExceptionHandlerExample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    List<Student> students = List.of(new Student("Munna", 27),
            new Student("Akash", 28),
            new Student("Rahima", 29));

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return students.get(id);
    }

//    @ExceptionHandler(Exception.class)
//    public Error handleException(Exception ex) {
//        return Error.builder()
//                .message(ex.getMessage())
//                .exceptionName(ex.getClass().getSimpleName())
//                .code(HttpStatus.NOT_FOUND.value())
//                .build();
//    }
}
