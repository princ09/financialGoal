import { Injectable } from '@angular/core';
import {FormGroup,FormControl, Validators} from '@angular/forms'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Goal } from './goal';
import { Saving } from './saving';
import { NotifierService } from 'angular-notifier';


@Injectable({
  providedIn: 'root'
})
export class GoalService {
  notifier: NotifierService;
  goals:Goal[];
  completedGoal:Goal[]=[];
  inCompleteGoal:Goal[]=[];
  form:FormGroup = new FormGroup({
    goalName: new FormControl('' , [Validators.required, Validators.pattern('[A-Za-z0-9 ]+')]),
    goalDecs : new FormControl('',[Validators.required, Validators.pattern('[A-Za-z0-9 ]+')]),
    goalTargetPrice: new FormControl('',[Validators.required,Validators.pattern('[0-9]+')]),
    goalCompleted: new FormControl('N')
    
  })

  savingForm:FormGroup = new FormGroup({
    savingName: new FormControl('' , [Validators.required, Validators.pattern('[A-Za-z0-9 ]+')]),
    savingValue: new FormControl('',[Validators.required,Validators.pattern('[0-9]+')]),
    
  })
  selectedGoal: Goal;
  constructor(private httpClient: HttpClient,notifier: NotifierService) {
    this.notifier = notifier;
   }
  ngOnInit(){
       
     }
  getGoals():Observable<Goal[]>{
    return this.httpClient.get<Goal[]>("http://localhost:8808/FinancialGoals/financialGoal/getGoals");
  }
  addGoal(goal:Goal){
    console.log("called Service")
    this.httpClient.post<Goal>("http://localhost:8808/FinancialGoals/financialGoal/addGoal",goal).subscribe(
      data=>{
        this.inCompleteGoal.push(data);
        this.notifier.notify("success", "You are awesome!You Added a Goal : "+data.goalName+"!!");

      },
      error => this.notifier.notify("error", error.error.message)
    );
  }
  addSaving(saving:Saving , goalId:number){
    let returnGoal:Goal;
    this.httpClient.post<Goal>("http://localhost:8808/FinancialGoals/financialGoal/addSaving/"+goalId,saving).subscribe(
      data=>{returnGoal = data;
      this.notifier.notify("success", "You are awesome!You Added a Saving");},
      error => this.notifier.notify("error", error.error.message)

    );
    this.inCompleteGoal.push(returnGoal);

  }
  deleteGoal(goalId:number){
    this.httpClient.delete("http://localhost:8808/FinancialGoals/financialGoal/deleteGoal/"+goalId).subscribe(
      data=>this.notifier.notify("success", "You are awesome!You Added a Saving"),
    );
    this.notifier.notify("success", "Goal Removed!!")
  }
  selectGoal(goal:Goal){
    this.selectedGoal=goal;
  }
}
