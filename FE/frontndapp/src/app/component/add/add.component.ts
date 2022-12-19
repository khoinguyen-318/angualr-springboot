import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { KhoangSan } from 'src/app/khoangsan';
import { ServicesService } from 'src/app/services/services.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent {
  employee: KhoangSan = new KhoangSan();
  constructor(private employeeService: ServicesService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe( data =>{
      console.log(data);
      this.goToEmployeeList();
    },
    error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
}
