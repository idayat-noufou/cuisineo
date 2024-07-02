import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RecetteService } from "../../services/Recette/recette.service";
import { Recette } from "../../models/recette";

@Component({
  selector: 'recette-create',
  templateUrl: './recette-create.component.html',
  standalone: true,
  styleUrls: ['./recette-create.component.css']
})
export class RecetteCreateComponent {
  recette: Recette = {
    id: 0,
    titre: '',
    nb_personnes: 0,
    temps: 0,
    instruction: '',
    utilisateur_id: 0,
  };

  constructor(
    private recetteService: RecetteService,
    private router: Router
  ) { }

  createRecette(): void {
    this.recetteService.createRecette(this.recette).subscribe(() => {
      this.router.navigate(['/recettes']);
    });
  }
}
