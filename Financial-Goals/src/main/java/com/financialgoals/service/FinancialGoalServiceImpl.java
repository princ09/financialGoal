package com.financialgoals.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financialgoals.dto.Goal;
import com.financialgoals.dto.Saving;
import com.financialgoals.entity.GoalEntity;
import com.financialgoals.entity.SavingEntity;
import com.financialgoals.repository.GoalRepository;
import com.financialgoals.repository.SavingRespository;
import com.financialgoals.validator.FinancialGoalValidator;
@Service
public class FinancialGoalServiceImpl implements FinancialGoalService {
	@Autowired
	private GoalRepository goalRepository;
	@Autowired 
	private SavingRespository savingRepository;
	
	@Override
	public Goal addGoal(Goal goal) throws Exception {
		FinancialGoalValidator.validateGoal(goal);
		GoalEntity goalEntity = goalRepository.findByGoalNameAndGoalTargetPrice(goal.getGoalName(), goal.getGoalTargetPrice());
		if(goalEntity!=null)
			throw new Exception("FinancialGoalService.GOAL_ALREADY_EXISTS");
		goalEntity = goalRepository.save(goal.prepareGoalEntity());
		return goalEntity.prepareDTO();
	}

	@Override
	public void deleteGoal(Integer goal_id) {
		goalRepository.deleteById(goal_id);

	}

	@Override
	public Goal addSaving(Integer goal_id, Saving saving) throws Exception {
		GoalEntity goalEntity = null;
		FinancialGoalValidator.validateSaving(saving);
		Optional<GoalEntity> goalEntityOptional = goalRepository.findById(goal_id);
		if(goalEntityOptional.isPresent()) {
			goalEntity = goalEntityOptional.get();
		}else {
			throw new Exception("FinancialGoalService.GOAL_ABSENT");
		}
			
			
		
		savingRepository.save(saving.prepareSavingEntity());
		int savingSum = 0;
		for(SavingEntity savingEntity:goalEntity.getSavingEntities()) {
			savingSum+=savingEntity.getSavingValue();
		}
		if(savingSum>=goalEntity.getGoalTargetPrice())
			goalEntity.setGoalCompleted('Y');
		return goalRepository.save(goalEntity).prepareDTO();
	
		
	}

	@Override
	public List<Goal> getGoals() throws Exception {
		List<GoalEntity> goalEntities = goalRepository.findAll();
		List<Goal> goals = goalEntities.stream().map(goalEntity->{
			return goalEntity.prepareDTO();
		}).collect(Collectors.toList());
		if(goals.isEmpty())
			throw new Exception("FinancialGoalService.NO_GOAL_ADDED");
		return goals;
	}

}
