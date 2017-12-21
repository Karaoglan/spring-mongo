package com.springmvc.mongoweb.dao;

import com.springmvc.mongoweb.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
    @Override
    Product findOne(String id);

    @Override
    void delete(String deleted);
}
