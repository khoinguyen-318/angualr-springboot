import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { KhoangSan } from '../khoangsan';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  private baseURL = "http://localhost:8080/api/v1/khoangsan";

  constructor(private httpClient: HttpClient) { }

  getEmployeesList(): Observable<KhoangSan[]>{
    return this.httpClient.get<KhoangSan[]>(`${this.baseURL}`);
  }

  createEmployee(employee: KhoangSan): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, employee);
  }

  getEmployeeById(id: number): Observable<KhoangSan>{
    return this.httpClient.get<KhoangSan>(`${this.baseURL}/${id}`);
  }

  updateEmployee(id: number, employee: KhoangSan): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
