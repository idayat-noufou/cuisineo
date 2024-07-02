import {Component} from '@angular/core';
import {CommonModule, NgIf, NgOptimizedImage} from "@angular/common";
import {AuthService} from "../../services/auth/auth.service";
import {RouterModule} from "@angular/router";
import {RecetteService} from "../../services/Recette/recette.service";
import {UtilisateurService} from "../../services/Userprofile/utilisateur.service";
import {Utilisateur} from "../../models/utilisateur";

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

  userId: string | undefined;

  utilisateur :  Utilisateur | undefined;
  constructor(private authService: AuthService, private utilisateurService: UtilisateurService) {
  }

  isLoggedIn() {
    return this.authService.isLoggedIn()
  }

  logout() {
    this.authService.doLogout();
  }

  ngOnInit(): void {
    this.utilisateurService.getUtilisateurById(this.userId).subscribe(data => {
      this.utilisateur = data;
      // @ts-ignore
        let id = this.authService.getUserProfile()?.id;
      if(id == null) {
        window.alert("pas d'utilisateur dans le token");
      }
      this.userId = id;
    });
  }

}
