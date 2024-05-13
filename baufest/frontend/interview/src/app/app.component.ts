import { Component, OnInit } from '@angular/core';
import { StudentService } from './services/student.service';
import { Observable } from 'rxjs';
import { Student } from './model/student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'interview';

  students$: Observable<Student[]> | null = null;

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.students$ = this.studentService.getStudents();
  }
  
}
