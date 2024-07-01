import {Component} from '@angular/core';
import {NgIf} from "@angular/common";
import {AuthService} from "../../services/auth/auth.service";
import {RouterModule} from "@angular/router";

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    NgIf,
    RouterModule
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  constructor(private authService: AuthService) {
  }

  isLoggedIn() {
    return this.authService.isLoggedIn()
  }

  logout() {
    this.authService.doLogout();
  }

  ngOnInit(): void {
  }

}
