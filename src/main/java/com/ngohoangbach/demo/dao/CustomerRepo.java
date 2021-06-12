package com.ngohoangbach.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngohoangbach.demo.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
