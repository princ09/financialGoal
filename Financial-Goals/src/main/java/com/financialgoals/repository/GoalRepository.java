package com.financialgoals.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.financialgoals.entity.GoalEntity;

public interface GoalRepository extends JpaRepository<GoalEntity , Integer> {
	public GoalEntity findByGoalNameAndGoalTargetPrice(String goalName , Integer goalTargetPrice);
}
