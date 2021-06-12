package com.ngohoangbach.demo.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngohoangbach.demo.entity.Statistic;

public interface StatisticRepo extends JpaRepository<Statistic, LocalDate>{

}
