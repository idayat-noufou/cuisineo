import { Component } from '@angular/core';
import {CommonModule} from "@angular/common";
import {ActivatedRoute} from "@angular/router";
import {UtilisateurService} from "../../services/Userprofile/utilisateur.service";
import {Utilisateur} from "../../models/utilisateur";

@Component({
  selector: 'app-user-profile',
  standalone: true,
    imports: [
      CommonModule
    ],
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent {
  utilisateur: Utilisateur | undefined;

  constructor(
    private route: ActivatedRoute,
    private utilisateurService: UtilisateurService
  ) { }
  ngOnInit(): void {
    const id = String(this.route.snapshot.paramMap.get('id'));
    this.utilisateurService.getUtilisateurById(id).subscribe((data: any) => {
      this.utilisateur = data;
    });
  }
}
