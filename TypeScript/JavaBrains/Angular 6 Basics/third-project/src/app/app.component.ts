import { Component } from '@angular/core';
import { TestService } from './test.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  constructor(
    private service: TestService, 
    private http: HttpClient) 
  {
    this.service.printToConsole("Got the service!");
  }

  ngOnInit() {
    let observable = this.http.get('https://api.github.com/users/dvt32');
    observable.subscribe(
      (response) => console.log(response)
    );
  }
}
