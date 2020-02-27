import { Component, OnInit, Inject } from '@angular/core';
import { Order } from '../models/order';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-modal',
  templateUrl: './add-modal.component.html',
  styleUrls: ['./add-modal.component.css']
})
export class AddModalComponent implements OnInit {

  order:Order = new Order();

  constructor(public dialogRef: MatDialogRef<AddModalComponent>) 
  { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit() {
    
  }

  onSubmit(form) {
    console.log(form.value);

  }

  closeModal(){
    this.dialogRef.close();
  }

}
