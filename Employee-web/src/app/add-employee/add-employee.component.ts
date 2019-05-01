import { Component, OnInit } from '@angular/core';
import { HttpClientService, Employee } from '../service/httpclient.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  user: Employee = new Employee("","","","");
  public empForm: FormGroup;
  constructor(
    private httpClientService: HttpClientService,
    private formBuilder: FormBuilder
  ) {
    this.empForm = formBuilder.group({
      empId: ['', [Validators.required]],
      name: ['', [Validators.required]],
      designation: ['', [Validators.required]],
      salary: ['', [Validators.required]]
    });
   }

  ngOnInit() {
    
  }

  createEmployee(): void {
    this.httpClientService.createEmployee(this.empForm.value)
        .subscribe( data => {
          alert("Employee created successfully.");
        });

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