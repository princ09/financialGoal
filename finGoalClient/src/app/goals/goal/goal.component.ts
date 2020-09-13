import { Component, OnInit } from '@angular/core';
import { GoalService } from 'src/app/shared/goal.service';
import { Goal } from 'src/app/shared/goal';
import {MatDialogRef} from '@angular/material/dialog'
import { Router } from '@angular/router';
import { GoalListComponent } from '../goal-list/goal-list.component';
@Component({
  selector: 'app-goal',
  templateUrl: './goal.component.html',
  styleUrls: ['./goal.component.css']
})
export class GoalComponent implements OnInit {
  goalService:GoalService;
  constructor( goalService:GoalService,  public dialogRef: MatDialogRef<GoalComponent>,
    private router:Router) {
    this.goalService=goalService
   }

  ngOnInit(): void {
  }
  onClear(){
    this.goalService.form.reset();
  }
  addGoal(){
    let goal:Goal = new Goal();
    if(this.goalService.form.valid){
      goal.goalName = this.goalService.form.get("goalName").value;
      goal.goalDecs = this.goalService.form.get("goalDecs").value;
      goal.goalTargetPrice = this.goalService.form.get("goalTargetPrice").value;
      goal.goalCompleted = "N";
      this.goalService.addGoal(goal);
      this.dialogRef.close();
    }
    

  }
  onNoClick(): void {
    this.dialogRef.close();
  }
}
