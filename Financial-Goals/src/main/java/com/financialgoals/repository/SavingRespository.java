package com.financialgoals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financialgoals.entity.SavingEntity;

public interface SavingRespository extends JpaRepository<SavingEntity, Integer> {

}
