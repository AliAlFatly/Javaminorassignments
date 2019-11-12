import {Component, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class httpMock {
  constructor(private http : HttpClient){}
  get = function(url:string){
    return
  }
}
