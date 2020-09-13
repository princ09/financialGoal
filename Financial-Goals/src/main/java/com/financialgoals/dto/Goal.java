package com.financialgoals.dto;

import java.util.ArrayList;
import java.util.List;

import com.financialgoals.entity.GoalEntity;
import com.financialgoals.entity.SavingEntity;


public class Goal {

	private Integer goalId;
	private String goalName;
	private String goalDecs;
	private Integer goalTargetPrice;
	private char goalCompleted;
	private List<Saving> savings;
	
	
	
	public Integer getGoalId() {
		return goalId;
	}
	public String getGoalDecs() {
		return goalDecs;
	}



	public void setGoalDecs(String goalDecs) {
		this.goalDecs = goalDecs;
	}


	public void setGoalId(Integer goalId) {
		this.goalId = goalId;
	}



	public String getGoalName() {
		return goalName;
	}



	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}




	public Integer getGoalTargetPrice() {
		return goalTargetPrice;
	}



	public void setGoalTargetPrice(Integer goalTargetPrice) {
		this.goalTargetPrice = goalTargetPrice;
	}



	public char getGoalCompleted() {
		return goalCompleted;
	}



	public void setGoalCompleted(char goalCompleted) {
		this.goalCompleted = goalCompleted;
	}




	public List<Saving> getSavings() {
		return savings;
	}



	public void setSavings(List<Saving> savings) {
		this.savings = savings;
	}



	public GoalEntity prepareGoalEntity() {
		GoalEntity goalEntity = new GoalEntity();
		goalEntity.setGoalCompleted('N');
		goalEntity.setGoalDecs(this.getGoalDecs());
		goalEntity.setGoalName(this.getGoalName());
		goalEntity.setGoalTargetPrice(this.getGoalTargetPrice());
		goalEntity.setSavingEntities(new ArrayList<SavingEntity>());
		return goalEntity;
	}
}
