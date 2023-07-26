package com.barbuds.userservice.service;

import com.barbuds.userservice.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class ProductService {


    List<Product>productList=null;

    @PostConstruct
    void loadUserFromDb(){
        productList= IntStream.rangeClosed(1,100).mapToObj(i->
                Product.builder().name(String.format("product %d",i))
                        .id(i)
                        .price(i*10)
                        .description(String.format("Random product %d",i))
                        .build()
                ).collect(Collectors.toList());
    }

    public List<Product> getAllProducts() {

        return productList;
    }

    public Product getProductById(int id) {

         return productList.stream().filter(i->i.getId()==id).findFirst().orElseThrow(()->new RuntimeException(String.format("No product with id %d found!!")));
    }
}
