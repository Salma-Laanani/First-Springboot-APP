package ma.emsi.dstudentapp;

import ma.emsi.dstudentapp.Repository.ProductRepository;
import ma.emsi.dstudentapp.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SpringBootApplication
public class DstudentAppApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(DstudentAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      productRepository.save(new Product(0,"Milk", 100.0,1000));
      productRepository.save(new Product(0,"Kitkat", 100.0,2000));
      productRepository.save(new Product(0,"Milka", 100.0,30000));

      List<Product> products = productRepository.findAll();
      products.forEach(p->System.out.println(p.toString()));
      Product product = productRepository.findById(Long.valueOf(1)).get();
      System.out.println(product.getPrice());

      System.out.println("-----------------------");
      List<Product> products1= productRepository.findByNameContains("K");
      products1.forEach(p->System.out.println(p.toString()));

        System.out.println("-----------------------");
        List<Product> products2= productRepository.search("%K%");
        products2.forEach(p->System.out.println(p.toString()));



    }
}
