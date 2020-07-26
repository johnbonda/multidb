package com.jb.multidb.controller;

import com.jb.multidb.db1.User;
import com.jb.multidb.db1.UserRepository;
import com.jb.multidb.db2.Product;
import com.jb.multidb.db2.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String hello() {
        return "Hello world";
    }

    @PostMapping("/user")
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @PostMapping("/product")
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
