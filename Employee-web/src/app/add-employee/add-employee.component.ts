import { Component, OnInit } from '@angular/core';
import { HttpClientService, Employee } from '../service/httpclient.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  user: Employee = new Employee("","","","","","");
  genders: string[] = ['Male', 'Female', 'others'];
  endDate:Date = new Date();
  public empForm: FormGroup;
  constructor(
    private httpClientService: HttpClientService,
    private formBuilder: FormBuilder
  ) {
    this.empForm = formBuilder.group({
      fname: ['', [Validators.required]],
      lname: ['', [Validators.required]],
      department: ['', [Validators.required]],
      dateofbirth:['',[]],
      gender:['',[Validators.required]]
    });
   }

  ngOnInit() {
    
  }

  createEmployee(): void {
    this.httpClientService.createEmployee(this.empForm.value)
        .subscribe( data => {
          alert("Employee created successfully.");
        });
    this.httpClientService.createEmployee(this.empForm.value)
    this.empForm.reset();
  };
  isInvalidAndDirty(field: string) {
    const ctrl = this.empForm.get(field);
    return !ctrl.valid && ctrl.dirty;
  }

  hasError(field: string, error: string) {
    const ctrl = this.empForm.get(field);
    return ctrl.dirty && ctrl.hasError(error);
  }
}