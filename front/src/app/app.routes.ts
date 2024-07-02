import { Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {TestAuthComponent} from "./components/test-auth/test-auth.component";
import {LoginComponent} from "./components/login/login.component";
import {authGuard} from "./services/auth/auth.guard";
import {SignupComponent} from "./components/signup/signup.component";
import {ListeRecettesComponent} from "./components/liste-recettes/liste-recettes.component";
import {RecetteDetailComponent} from "./components/recette-detail/recette-detail.component";

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  // { path: '**', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'recettes', component: ListeRecettesComponent },
  { path: 'recettes/:id', component: RecetteDetailComponent },
  { path: 'testAuth', component: TestAuthComponent,  canActivate: [authGuard] },
  { path: 'userProfile/:id', component: TestAuthComponent,  canActivate: [authGuard] },
];
