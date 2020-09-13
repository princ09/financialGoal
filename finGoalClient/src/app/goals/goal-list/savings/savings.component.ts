import { Component, OnInit, ViewChild } from '@angular/core';
import { GoalService } from 'src/app/shared/goal.service';
import { Goal } from 'src/app/shared/goal';
import { Saving } from 'src/app/shared/saving';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import {MatDialogRef} from '@angular/material/dialog'
import { SavingComponent } from './saving/saving.component';

@Component({
  selector: 'app-savings',
  templateUrl: './savings.component.html',
  styleUrls: ['./savings.component.css']
})
export class SavingsComponent implements OnInit {

  constructor(private goalService:GoalService,private dialog: MatDialog, public dialogRef: MatDialogRef<SavingsComponent>,) { }
  selectedGoal:Goal;
  savingList:MatTableDataSource<Saving>;
  displayedColumns: string[] = ['savingName','savingValue']
  @ViewChild(MatSort) sort:MatSort
  @ViewChild(MatPaginator) paginator: MatPaginator;
  searchKey: string;
  ngOnInit(): void {
    this.selectedGoal = this.goalService.selectedGoal;
    this.savingList = new MatTableDataSource(this.selectedGoal.savings);
    this.savingList.sort = this.sort;
    setTimeout(() => this.savingList.paginator = this.paginator);

    
  }
  

 
  onNoClick(): void {
    this.dialogRef.close();
  }
  addSaving(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "20%";
    this.dialog.open(SavingComponent,dialogConfig);
  }
}
