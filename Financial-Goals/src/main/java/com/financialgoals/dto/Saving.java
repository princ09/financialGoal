package com.financialgoals.dto;

import com.financialgoals.entity.SavingEntity;

public class Saving {
	private Integer savingId;
	private String savingName;
	private Integer savingValue;
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
	public SavingEntity prepareSavingEntity() {
		SavingEntity savingEntity = new SavingEntity();
		savingEntity.setSavingGoalId(this.getSavingGoalId());
		savingEntity.setSavingName(this.getSavingName());
		savingEntity.setSavingValue(this.getSavingValue());
		return savingEntity;
	}
}
