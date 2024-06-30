import { Component } from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {AuthService} from "../../services/auth/auth.service";
import {SignupRequest} from "../../models/requests/signupRequest";

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {

  signupForm = new FormGroup({
    nom: new FormControl(''),
    prenom: new FormControl(''),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required])
  });

  constructor(private authService: AuthService) {
  }

  onSubmit() {
    const email = this.signupForm.get('email')?.value;
    const password = this.signupForm.get('password')?.value;
    if (!email || !password) {
      console.error("L'email et le mot de passe ne doivent pas être vide")
      return;
    }
    if (!this.signupForm.valid ) {
      console.error("Le formulaire n'est pas valide");
      return;
    }
    let user: SignupRequest = {
      nom: this.signupForm.get('nom')?.value ?? null,
      prenom: this.signupForm.get('prenom')?.value ?? null,
      email:email,
      password: password
    }
    this.authService.signUp(user).subscribe((res) => {
      this.authService.login({email: email, password: password});
    });
  }
}
