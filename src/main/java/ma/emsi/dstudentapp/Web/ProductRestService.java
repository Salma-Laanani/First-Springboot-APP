package ma.emsi.dstudentapp.Web;

import ma.emsi.dstudentapp.Repository.ProductRepository;
import ma.emsi.dstudentapp.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    ProductRepository productRepo;

    @GetMapping("/products")
   public  List<Product> products(){
        return productRepo.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable Long id){
        return productRepo.findById(id).get();
    }
}
