import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Order } from '../models/order';
import { VentasService } from '../services/ventas.service';

@Component({
  selector: 'app-update-modal',
  templateUrl: './update-modal.component.html',
  styleUrls: ['./update-modal.component.css']
})
export class UpdateModalComponent implements OnInit {

  order:Order = new Order();

  constructor(
    public dialogRef: MatDialogRef<UpdateModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private ventasService:VentasService) 
  { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit() {
    console.log(this.data.item);
    this.order = this.data.item;
    //this.order = this.data.item;
  }

  onSubmit(form) {
    console.log(this.order.id);
    this.ventasService.modify(this.order.id, form.value).subscribe((datos)=>{
      console.log(datos);
      console.log(datos.id);
      this.closeModal();
      
      
    });
  }

  closeModal(){
    this.dialogRef.close();
  }

}
