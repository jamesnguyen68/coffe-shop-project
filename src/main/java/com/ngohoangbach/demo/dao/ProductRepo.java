package com.ngohoangbach.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngohoangbach.demo.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
