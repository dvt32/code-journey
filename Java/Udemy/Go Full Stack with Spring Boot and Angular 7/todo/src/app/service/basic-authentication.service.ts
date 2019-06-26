import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { API_URL } from '../app.constants';

export const TOKEN = 'token';
export const AUTHENTICATED_USER = 'authenticatedUser';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {

  constructor(private http: HttpClient) { }

  executeJwtAuthenticationService(username, password) {
    return (
      this
        .http.post<any>(
          `${API_URL}/authenticate`, 
          {
            username,
            password
          }
        )
        .pipe(
          map(
            data => {
              sessionStorage.setItem(AUTHENTICATED_USER, username);
              sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
              return data;
            }
          )
        )
    );
  }

  executeAuthenticationService(username, password) {
    let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);

    let headers = new HttpHeaders(
      {
        Authorization: basicAuthHeaderString
      }
    );

    return (
      this
        .http.get<AuthenticationBean>(
          `${API_URL}/basicauth`, 
          {headers}
        )
        // if the GET request was successful, do the stuff below
        .pipe(
          map(
            data => {
              sessionStorage.setItem(AUTHENTICATED_USER, username);
              sessionStorage.setItem(TOKEN, basicAuthHeaderString);
              return data;
            }
          )
        )
    );
  }

  getAuthenticatedUser() {
    return sessionStorage.getItem(AUTHENTICATED_USER);
  }

  getAuthenticatedToken() {
    if (this.getAuthenticatedUser()) {
      return sessionStorage.getItem(TOKEN);
    }
  }
  
  isUserLoggedIn() {
    let user = sessionStorage.getItem(AUTHENTICATED_USER);
    return !(user === null);
  }

  logout() {
    sessionStorage.removeItem(AUTHENTICATED_USER);
    sessionStorage.removeItem(TOKEN);
  }
}

export class AuthenticationBean {
  constructor(public message: string) {}
}