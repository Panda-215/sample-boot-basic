package th.mfu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import th.mfu.domain.Customer;
import th.mfu.domain.Product;
import th.mfu.dto.CustomerDTO;
import th.mfu.dto.ProductDTO;
import th.mfu.dto.mapper.ProductMapper;
import th.mfu.repository.ProductRepository;

@RestController

public class ProductController {

    @Autowired
    private ProductRepository custRepo;

    @Autowired
    private ProductMapper productMapper;

    // Get for a cus Medthod
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getCustomer(@PathVariable Long id) {

        if (!custRepo.existsById(id))
            return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);

        Optional<Product> product = custRepo.findById(id);
        ProductDTO dto = new ProductDTO();
        productMapper.updateProductFromEntity(product.get(), dto);
        return new ResponseEntity<ProductDTO>(dto, HttpStatus.OK);
    }

    // get all pro
    @GetMapping("/products")
    public ResponseEntity<Collection> getAllProduct() {
        List<Product> products=custRepo.findAll();
        List<ProductDTO> dtos=new ArrayList<ProductDTO>();
        for(Product cust : products){
            ProductDTO dto = new ProductDTO();
            productMapper.updateProductFromEntity(cust,dto);
            dtos.add(dto);
        }
        return new ResponseEntity<Collection>(dtos, HttpStatus.OK);
    }

    // Post for creating a cutomer
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO product) {
        Product newProduct = new Product();
        productMapper.updateProductFromDto(product,newProduct);
        custRepo.save(newProduct);
        return new ResponseEntity<String>("Product created", HttpStatus.CREATED);

    }
     // PATCH for updating customer
    @PatchMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        if (!custRepo.existsById(id))
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        Optional<Product> productEnt = custRepo.findById(id);
        Product product = productEnt.get();
        productMapper.updateProductFromDto(productDTO, product);
        System.out.println(product.getId());
        custRepo.save(product);
        return new ResponseEntity<String>("Product updated", HttpStatus.OK);
    }


    // Delete
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        custRepo.deleteById(id);
        return new ResponseEntity<String>("Product deleted", HttpStatus.NO_CONTENT);
    }
}
