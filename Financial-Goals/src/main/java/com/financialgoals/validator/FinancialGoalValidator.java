package com.financialgoals.validator;

import com.financialgoals.dto.Goal;
import com.financialgoals.dto.Saving;

public class FinancialGoalValidator {
	public static void validateGoal(Goal goal) throws Exception {
		if(!validateGoalName(goal.getGoalName()))
			throw new Exception("FinancialGoalValidator.INVALID_GOAL_NAME");
		if(!validateGoalTargetPrice(goal.getGoalTargetPrice()))
			throw new Exception("FinancialGoalValidator.INVALID_GOAL_TARGET_PRICE");
	}
	private static boolean validateGoalName(String goal_name) {
		if(goal_name.matches("[A-Za-z0-9 ]+"))
			return true;
		return false;
	}
	private static boolean validateGoalTargetPrice(int goal_target_value) {
		if(goal_target_value>0)
			return true;
		return false;
	}
	public static void validateSaving(Saving saving) throws Exception {
		if(!validateSavingValue(saving.getSavingValue()))
			throw new Exception("FinancialGoalValidator.INVALID_SAVING_VALUE");
	}
	private static boolean validateSavingValue(int savingValue) {
		if(savingValue>0)
			return true;
		return false;
	}
}
