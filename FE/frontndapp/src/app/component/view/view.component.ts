import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { KhoangSan } from 'src/app/khoangsan';
import { ServicesService } from 'src/app/services/services.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent {
  id!: number
  employee!: KhoangSan
  constructor(private route: ActivatedRoute, private employeService: ServicesService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.employee = new KhoangSan();
    this.employeService.getEmployeeById(this.id).subscribe( data => {
      this.employee = data;
    });
  }
}
