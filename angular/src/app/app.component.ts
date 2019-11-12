import {Component, Inject, Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
@Injectable()
export class AppComponent {
  constructor(private http : HttpClient){}
  response;

  ngOnInit(){
    this.getData().subscribe(d => {
      this.response = d;
    })
    console.log(this.getData())
  }

  getData(){
    return this.http.get('http://localhost:8080/home');
  }
}
