package munna.test.ExceptionHandlerExample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    List<Product> products = List.of(new Product("Pen", 10),
            new Product("Paper", 20));

    @GetMapping("/{id}")
    public Object getProduct(@PathVariable int id) {
        return products.get(id);
    }

    @GetMapping("/x/{id}")
    public Object getProductX(@PathVariable int id) {
        return products.get(id);
    }

    @GetMapping("/{id}/{name}")
    public Object getProductAndName(@PathVariable int id, @PathVariable int name) {
        return products.get(id);
    }

    @GetMapping("/y/{id}")
    public Object getProductY(@PathVariable String id) {
        int intId = Integer.parseInt(id);
        return products.get(intId);
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
