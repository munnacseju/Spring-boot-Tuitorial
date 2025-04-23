package com.crud.crud;

import com.crud.crud.param.PageableParam;
import com.crud.crud.tools.QueryHelper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.In;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
//@RequestMapping()
@CrossOrigin
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        for(int i= 0; i<10; i++) {
            product.setId(UUID.randomUUID());
            productRepository.save(product);
        }
        return null;
    }

    @GetMapping("/product/{id}")
    public Product findById(@PathVariable UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable UUID id, @RequestBody Product product) {
        if(productRepository.existsById(id)) {
            product.setId(id);
            if(product.getPhoto() == null) {
                product.setPhoto(Objects.requireNonNull(productRepository.findById(id).orElse(null)).getPhoto());
            }
            return productRepository.save(product);
        }
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable UUID id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productRepository.findAll();
    }


    @GetMapping("/products-page")
    @Parameters({
            @Parameter(name = "pageNo", in = ParameterIn.QUERY, schema = @Schema(type = "int", defaultValue = "1")),
            @Parameter(name = "pageSize", in = ParameterIn.QUERY, schema = @Schema(type = "int", defaultValue = "20")),
            @Parameter(name = "sortBy", in = ParameterIn.QUERY, schema = @Schema(type = "string"), example = "createdAt:desc"),
            @Parameter(name = "name", in = ParameterIn.QUERY, schema = @Schema(type = "string")),
            @Parameter(name = "price", in = ParameterIn.QUERY, schema = @Schema(type = "string")),
    })
    public ResponseEntity<?> findAll(
//            @Join(path = "approvalInPrinciple", alias = "approvalInPrinciple")
            @And({
                    @Spec(path = "isDeleted", constVal = "false", spec = In.class),
                    @Spec(path = "name", params = "name", spec = LikeIgnoreCase.class),
                    @Spec(path = "price", params = "price", spec = LikeIgnoreCase.class)
            })
            @Parameter(hidden = true) Specification<Product> specification,
            @Parameter(hidden = true) PageableParam pageable) {
        if(pageable.getPageNo() != null) {
            Page<Product> page = productRepository.findAll(specification, QueryHelper.getPageRequest(pageable));
            return ResponseEntity.ok(page);
        }else {
            List<Product> products = productRepository.findAll(specification, QueryHelper.getSort(pageable.getSortBy()));
            return ResponseEntity.ok(products);
        }
    }


}
