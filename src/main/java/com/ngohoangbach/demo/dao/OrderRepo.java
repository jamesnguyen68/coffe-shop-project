package com.ngohoangbach.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngohoangbach.demo.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
