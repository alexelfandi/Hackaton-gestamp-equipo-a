import {Component, OnInit, ViewChild, ChangeDetectorRef} from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { InfoModalComponent } from '../info-modal/info-modal.component';
import { VentasService } from '../services/ventas.service';
import { UpdateModalComponent } from './../update-modal/update-modal.component';
import { AddModalComponent } from './../add-modal/add-modal.component';


export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

var ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
];

const ELEMENT_DATA_CONST: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
];


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})

export class TableComponent implements OnInit {

  filterData;
  displayedColumns: string[] = ['OrderID', 'Region', 'OrderDate', 'OrderPriority', 'action'];
  dataSource;
  arrayVentas = [];
  arrayVentas_Conts = [];


  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(public dialog: MatDialog,private changeDetectorRefs: ChangeDetectorRef, private servicioVentas: VentasService) { }

  ngOnInit() {

    try {
      this.servicioVentas.getFirsts().subscribe((datos) =>{
        this.arrayVentas = datos;
        this.dataSource = new MatTableDataSource(this.arrayVentas);
        this.arrayVentas_Conts = datos;

        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
        console.log(this.arrayVentas);
      });
    } catch (error) {
      console.log(error);
      
    }

  }

  openDialog(selectedItem): void {
    const dialogRef = this.dialog.open(InfoModalComponent, {
      width: '400px',
      data: { item: selectedItem }
    });
  }

  updateItem(selectedItem): void {
    const dialogRef = this.dialog.open(UpdateModalComponent, {
      width: '500px',
      height: '600px',
      data: { item: selectedItem }
    }).afterClosed().subscribe((datos)=>{
      console.log(datos);

      this.servicioVentas.getFirsts().subscribe((datos) =>{
        this.arrayVentas = datos;
        this.dataSource = new MatTableDataSource(this.arrayVentas);
        this.arrayVentas_Conts = datos;

        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
        console.log(this.arrayVentas);
      });
      
    });

    
  }

  addItem(): void {
    const dialogRef = this.dialog.open(AddModalComponent, {
      width: '500px',
      height: '600px',
    });
  }

  deleteItem(item){
    console.log("Deleting " + item);
    this.servicioVentas.delete(item.id).subscribe((datos) => {
      console.log(datos);
      this.servicioVentas.getFirsts().subscribe((datos) =>{
        this.arrayVentas = datos;
        this.dataSource = new MatTableDataSource(this.arrayVentas);
        this.arrayVentas_Conts = datos;

        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
        console.log(this.arrayVentas);
      });
    });
  }

  refresh() {
    this.dataSource = new MatTableDataSource<any>(this.filterData);
  }

  search(term: string) {
    if(!term) {
      this.filterData = this.arrayVentas_Conts;
      this.refresh();
    } else {
      this.filterData = this.arrayVentas_Conts.filter(x => 
         x.Region.trim().toLowerCase().includes(term.trim().toLowerCase())
      );
      this.arrayVentas = this.filterData;
      this.refresh();
    }    
  }

}