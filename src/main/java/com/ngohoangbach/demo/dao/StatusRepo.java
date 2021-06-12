package com.ngohoangbach.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngohoangbach.demo.entity.Status;

public interface StatusRepo extends JpaRepository<Status, Integer>{

}
