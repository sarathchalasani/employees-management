import { TestBed } from '@angular/core/testing';
import { HttpClientService } from './httpclient.service';
import { HttpClientTestingModule,HttpTestingController } from '@angular/common/http/testing';


describe('HttpclientService', () => {
  let service:HttpClientService;
  let mockService:HttpTestingController;
  beforeEach(() => {
  TestBed.configureTestingModule({
    imports:[HttpClientTestingModule],
    providers:[HttpClientService]
  });
  service=TestBed.get(HttpClientService);
  mockService=TestBed.get(HttpTestingController);
});
it('test create emp', () => {
  const testData=[{"empId":8,"name":"AAA","designation":"SE","salary":4400.0}];
  service.createEmployee(testData);
  service.getEmployees().subscribe(posts=>{
    expect(posts.length).toBe(1);
  });
  
});
  it('should be created', () => {
    const service: HttpClientService = TestBed.get(HttpClientService);
    expect(service).toBeTruthy();
  });
  
});
