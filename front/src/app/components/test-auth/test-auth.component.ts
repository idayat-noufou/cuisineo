import {Component} from '@angular/core';
import {AuthService} from "../../services/auth/auth.service";

@Component({
  selector: 'app-test-auth',
  standalone: true,
  imports: [],
  templateUrl: './test-auth.component.html',
  styleUrl: './test-auth.component.css'
})
export class TestAuthComponent {

  constructor(private authService: AuthService) {
  }

  logout() {
    this.authService.doLogout();
  }
}
