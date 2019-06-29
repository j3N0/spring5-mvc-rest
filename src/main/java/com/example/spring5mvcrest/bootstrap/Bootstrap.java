package com.example.spring5mvcrest.bootstrap;

import com.example.spring5mvcrest.domain.Category;
import com.example.spring5mvcrest.domain.Customer;
import com.example.spring5mvcrest.repositories.CategoryRepository;
import com.example.spring5mvcrest.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();

        Customer mike = new Customer();
        mike.setId(1L);
        mike.setFirstName("Micheal");
        mike.setLastName("Weston");

        Customer sam = new Customer();
        sam.setId(2L);
        sam.setFirstName("Sam");
        sam.setLastName("Axe");

        customerRepository.save(mike);
        customerRepository.save(sam);

        System.out.println("Customers Loaded: " + customerRepository.count());

    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Categories Loaded: " + categoryRepository.count());
    }
}
