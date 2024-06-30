import { Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {TestAuthComponent} from "./components/test-auth/test-auth.component";
import {LoginComponent} from "./components/login/login.component";
import {authGuard} from "./services/auth/auth.guard";
import {SignupComponent} from "./components/signup/signup.component";

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  // { path: '**', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'testAuth', component: TestAuthComponent,  canActivate: [authGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
];
