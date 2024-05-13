import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../model/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  URL = '/api/student';

  constructor(private http: HttpClient) { }

  public getStudents(): Observable<Student[]> | null {
    return this.http.get<Student[]>(`${this.URL}`);
  }
}
