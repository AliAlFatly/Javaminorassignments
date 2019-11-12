import { AppPage } from './app.po';
import { browser, logging, by, element } from 'protractor';
import {httpMock} from "./http.mock";
import construct = Reflect.construct;
import {TestBed} from "@angular/core/testing";
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {AppComponent} from "../../src/app/app.component";

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations:[httpMock]
    })
    page = new AppPage();
  });

  it('should display "Hello, world!"', () => {
    page.navigateTo();
    let p = element(by.id("response"));
    expect(p).toContain('Hello, world!');
  });

  it(`should make a rest api call to http://localhost:4200 and receive {"greeting" : "Hello, world!"`, ()=>{
    const fixture = TestBed.createComponent(httpMock);
    const http = fixture.debugElement.componentInstance;
    expect(http.get("http://localhost:8080/home")).toContain('Hello, world!');
  })
  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
