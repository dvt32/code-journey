import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  printToConsole(arg) {
    console.log(arg);
  }
  
}
