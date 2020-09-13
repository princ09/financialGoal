import { Component, OnInit } from '@angular/core';
import { GoalService } from 'src/app/shared/goal.service';
import { MatDialogRef } from '@angular/material/dialog';
import { Saving } from 'src/app/shared/saving';

@Component({
  selector: 'app-saving',
  templateUrl: './saving.component.html',
  styleUrls: ['./saving.component.css']
})
export class SavingComponent implements OnInit {
  goalService:GoalService;
  constructor( goalService:GoalService,  public dialogRef: MatDialogRef<SavingComponent>) {
    this.goalService=goalService
   }

  ngOnInit(): void {
  }
  addSaving(){
    let saving:Saving = new Saving();
    if(this.goalService.savingForm.valid){
      saving.savingName = this.goalService.savingForm.get("savingName").value;
      saving.savingValue = this.goalService.savingForm.get("savingValue").value;
      saving.savingGoalId = this.goalService.selectedGoal.goalId;
      this.goalService.addSaving(saving,saving.savingGoalId);
      this.dialogRef.close();
    }
  }
  onNoClick(): void {
    this.dialogRef.close();
  }
}
