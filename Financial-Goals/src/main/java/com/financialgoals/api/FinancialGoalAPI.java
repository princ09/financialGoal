package com.financialgoals.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.financialgoals.dto.Goal;
import com.financialgoals.dto.Saving;
import com.financialgoals.service.FinancialGoalService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/financialGoal")
public class FinancialGoalAPI {
	@Autowired
	private FinancialGoalService financialGoalService;
	@Autowired
	private Environment environment;
	@GetMapping("/getGoals")
	public ResponseEntity<List<Goal>> getGoals(){
		try {
			return new ResponseEntity<List<Goal>>(financialGoalService.getGoals(), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
	
	@DeleteMapping("/deleteGoal/{goalId}")
	public ResponseEntity<String> deleteGoal(@PathVariable("goalId") Integer goalId) {
		financialGoalService.deleteGoal(goalId);
		return new ResponseEntity<String>(environment.getProperty("API.SUCCESS"),HttpStatus.OK);
	}
	
	@PostMapping("/addGoal")
	public ResponseEntity<Goal> addGoal(@RequestBody Goal goal){
		try {
			return new ResponseEntity<Goal>(financialGoalService.addGoal(goal), HttpStatus.CREATED);
		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()));
		}
	}
	@PostMapping("/addSaving/{goalId}")
	public  ResponseEntity<Goal> addSaving(@PathVariable("goalId") Integer goalId,@RequestBody Saving saving){
		try {
			return new ResponseEntity<Goal>(financialGoalService.addSaving(goalId, saving), HttpStatus.CREATED);
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()));
		}

	}
}
