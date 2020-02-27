import { Component, OnInit, Inject } from '@angular/core';
import { Order } from '../models/order';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { VentasService } from '../services/ventas.service';

@Component({
  selector: 'app-add-modal',
  templateUrl: './add-modal.component.html',
  styleUrls: ['./add-modal.component.css']
})
export class AddModalComponent implements OnInit {

  order:Order = new Order();

  constructor(public dialogRef: MatDialogRef<AddModalComponent>, private orderService: VentasService) 
  { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit() {
    
  }

  onSubmit(form) {
    console.log(form.value);
    this.orderService.add(form.value).subscribe((datos) => {
      console.log(datos);
      this.closeModal();
      
    })
  }

  closeModal(){
    this.dialogRef.close();
  }

}
