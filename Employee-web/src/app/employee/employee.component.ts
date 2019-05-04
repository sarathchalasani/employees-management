import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClientService, Employee } from '../service/httpclient.service';
import { MatTableDataSource,MatPaginator,MatSort } from '@angular/material';
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  dataSource:MatTableDataSource<Employee>;
  displayedColumns: string[] = ['empId', 'fname', 'lname', 'department','dateofbirth','gender','actions'];
  index: number;
  id: number;
  constructor(
    private httpClientService:HttpClientService
  ) { }
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {
     this.httpClientService.getEmployees().subscribe(
      response =>this.handleSuccessfulResponse(response),
     );
  }

handleSuccessfulResponse(response)
{
    this.dataSource= new MatTableDataSource(response);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
}

applyFilter(filterValue: string) {
  this.dataSource.filter = filterValue.trim().toLowerCase();

  if (this.dataSource.paginator) {
    this.dataSource.paginator.firstPage();
  }
}


deleteEmployee(employee: Employee): void {
  this.httpClientService.deleteEmployee(employee)
    .subscribe( data => {
     this.ngOnInit();
  })
};


private refreshTable() {
  // Refreshing table using paginator
  // Thanks yeager-j for tips
  // https://github.com/marinantonio/angular-mat-table-crud/issues/12
  this.paginator._changePageSize(this.paginator.pageSize);
}
}