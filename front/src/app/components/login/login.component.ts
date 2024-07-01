import {Component} from '@angular/core';
import {RouterModule} from "@angular/router";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth/auth.service";
import {LoginRequest} from "../../models/requests/loginRequest";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required])
  });

  constructor(private authService: AuthService) {
  }

  onSubmit() {
    const email = this.loginForm.get('email')?.value;
    const password = this.loginForm.get('password')?.value;
    if (!email || !password) {
      console.error("L'email et le mot de passe ne doivent pas être vide")
      return;
    }
    if (!this.loginForm.valid ) {
      console.error("Le formulaire n'est pas valide");
      return;
    }
    let user: LoginRequest = {
      email:email,
      password: password
    }
    this.authService.login(user);
  }

}
