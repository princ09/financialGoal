import { Component, OnInit, ViewChild } from '@angular/core';
import { GoalService } from 'src/app/shared/goal.service';
import { Goal } from 'src/app/shared/goal';
import {MatTableDataSource} from '@angular/material/table'
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { GoalComponent } from '../goal/goal.component';
import { SavingsComponent } from './savings/savings.component';
@Component({
  selector: 'app-goal-list',
  templateUrl: './goal-list.component.html',
  styleUrls: ['./goal-list.component.css']
})
export class GoalListComponent implements OnInit {
     
  inCompleteGoal:Goal[]=[];
  goalList:MatTableDataSource<Goal>;
  displayedColumns: string[] = ['goalName','goalDecs','goalTargetPrice',"actions"]
  @ViewChild(MatSort) sort:MatSort
  @ViewChild(MatPaginator) paginator: MatPaginator;
  searchKey: string;

  constructor(private goalService:GoalService, private dialog: MatDialog,
    ) { }

  ngOnInit(): void {
    setInterval(()=>{
      this.goalService.getGoals().subscribe(
        data=>{
          if(data.length==0){
            this.goalService.notifier.notify("warning","No Goal Added");
          }
          this.goalList =  new MatTableDataSource(data);
          this.goalList.sort = this.sort;
          this.goalList.paginator = this.paginator;
  
        });
    },1000)
    
     
     
  }
  onSearchClear() {
    this.searchKey = "";
    this.applyFilter();
  }

  applyFilter() {
    this.goalList.filter = this.searchKey.trim().toLowerCase();
  }
  onCreate() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(GoalComponent,dialogConfig);
  }
  openSaving(goal:Goal){
    this.goalService.selectedGoal = goal;
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "50%";
    this.dialog.open(SavingsComponent,dialogConfig);
    console.log(goal);
  }
  removeGoal(goal:Goal){
    this.goalService.deleteGoal(goal.goalId);
    this.ngOnInit();
   
  }
}
