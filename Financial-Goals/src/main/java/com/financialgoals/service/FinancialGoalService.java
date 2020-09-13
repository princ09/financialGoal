package com.financialgoals.service;

import java.util.List;

import com.financialgoals.dto.Goal;
import com.financialgoals.dto.Saving;

public interface FinancialGoalService {
	Goal addGoal(Goal goal) throws Exception;
	void deleteGoal(Integer goal_id);
	Goal addSaving(Integer goal_id , Saving saving) throws Exception;
	List<Goal> getGoals() throws Exception;
	
}
