package com.financialgoals.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.financialgoals.dto.Goal;
import com.financialgoals.dto.Saving;

@Entity
@Table(name = "goals")
public class GoalEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer goalId;
	private String goalName;
	private String goalDecs;
	private Integer goalTargetPrice;
	private char goalCompleted;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="saving_goal_id")
	private List<SavingEntity> savingEntities;
	
	
	
	public Integer getGoalId() {
		return goalId;
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

	public String getGoalDecs() {
		return goalDecs;
	}



	public void setGoalDecs(String goalDecs) {
		this.goalDecs = goalDecs;
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



	public List<SavingEntity> getSavingEntities() {
		return savingEntities;
	}



	public void setSavingEntities(List<SavingEntity> savingEntities) {
		this.savingEntities = savingEntities;
	}



	public Goal prepareDTO() {
		Goal goal = new Goal();
		goal.setGoalCompleted(this.getGoalCompleted());
		goal.setGoalDecs(this.getGoalDecs());
		goal.setGoalId(this.getGoalId());
		goal.setGoalName(this.getGoalName());
		goal.setGoalTargetPrice(this.getGoalTargetPrice());
		goal.setSavings(this.getSavingEntities().stream().map(savingEntity->{
			Saving saving = new Saving();
			saving.setSavingGoalId(savingEntity.getSavingGoalId());
			saving.setSavingId(savingEntity.getSavingId());
			saving.setSavingName(savingEntity.getSavingName());
			saving.setSavingValue(savingEntity.getSavingValue());
			return saving;
		}).collect(Collectors.toList()));
		return goal;
		
	}
}
