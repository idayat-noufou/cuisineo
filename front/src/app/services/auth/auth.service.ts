import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {SignupRequest} from "../../models/requests/signupRequest";
import {catchError, Observable, throwError} from "rxjs";
import {LoginRequest} from "../../models/requests/loginRequest";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  endpoint: string = 'http://localhost:3080';
  headers = new HttpHeaders().set('Content-Type', 'application/json');
  currentUser = {};

  constructor(private http: HttpClient, public router: Router) {
  }

  // Sign-up
  signUp(user: SignupRequest): Observable<any> {
    let api = `${this.endpoint}/auth/signup`;
    return this.http.post(api, user).pipe(catchError(this.handleError));
  }

  // Sign-in
  login(user: LoginRequest) {
    return this.http
      .post<any>(`${this.endpoint}/auth/login`, user).subscribe(res => {
        localStorage.setItem('access_token', res.token);
        this.router.navigate(["/home"])
        // this.getUserProfile(res._id).subscribe((res) => {
        //   this.currentUser = res;
        //   this.router.navigate(['user-profile/' + res.msg._id]);
        // });
      });
  }

  getToken() {
    return localStorage.getItem('access_token');
  }

  isLoggedIn(): boolean {
    let authToken = localStorage.getItem('access_token');
    return authToken !== null;
  }

  doLogout() {
    let removeToken = localStorage.removeItem('access_token');
    if (removeToken == null) {
      this.router.navigate(['login']);
    }
  }

  // // User profile
  // getUserProfile(id: any): Observable<any> {
  //   let api = `${this.endpoint}/user-profile/${id}`;
  //   return this.http.get(api, { headers: this.headers }).pipe(
  //     map((res) => {
  //       return res || {};
  //     }),
  //     catchError(this.handleError)
  //   );
  // }
  // Error
  handleError(error: HttpErrorResponse) {
    let msg = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      msg = error.error.message;
    } else {
      // server-side error
      msg = `Error Code: ${error.status}\nMessage: ${error.message}`;
      if (error.status === 409) {
        msg = 'L\'email existe déjà';
      }
    }
    return throwError(() => new Error(msg));
  }

  public deconnecter() {
    localStorage.removeItem('access_token');
  }
}
