import {Component} from '@angular/core';
import {CommonModule, NgIf, NgOptimizedImage} from "@angular/common";
import {AuthService} from "../../services/auth/auth.service";
import {RouterModule} from "@angular/router";

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    NgOptimizedImage,
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  userId: string = "1jzk";

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
