package com.financialgoals.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.financialgoals.dto.Saving;

@Entity
@Table(name = "goal_savings")
public class SavingEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer savingId;
	private String savingName;
	private Integer savingValue;
	@Column(name="saving_goal_id")
	private Integer savingGoalId;
	
	public Integer getSavingId() {
		return savingId;
	}

	public void setSavingId(Integer savingId) {
		this.savingId = savingId;
	}

	public String getSavingName() {
		return savingName;
	}

	public void setSavingName(String savingName) {
		this.savingName = savingName;
	}

	public Integer getSavingValue() {
		return savingValue;
	}

	public void setSavingValue(Integer savingValue) {
		this.savingValue = savingValue;
	}

	public Integer getSavingGoalId() {
		return savingGoalId;
	}

	public void setSavingGoalId(Integer savingGoalId) {
		this.savingGoalId = savingGoalId;
	}

	public Saving prepareDTO() {
		Saving saving = new Saving();
		saving.setSavingGoalId(this.getSavingGoalId());
		saving.setSavingId(this.getSavingId());
		saving.setSavingName(this.getSavingName());
		saving.setSavingValue(this.getSavingValue());
		return saving;
	}
}
