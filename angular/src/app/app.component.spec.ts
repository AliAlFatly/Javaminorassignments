import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {AppPage} from "../../e2e/src/app.po";
import {by, element} from "protractor";
import {inject} from "@angular/core";

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  }));


  it("should create the app", () =>{
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  })

  it(`AppComponent.getData should return {"greeting" : "Hello, world!"} `, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    let data = app.getData().body;
    console.log(data)
    expect(data).toContain('Hello, world!');
  });

});
