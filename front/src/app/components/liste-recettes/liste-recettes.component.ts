import { Component } from '@angular/core';
import {RecetteService} from "../../services/Recette/recette.service";
import {Recette} from "../../models/recette";
import {RouterModule} from "@angular/router";
import {CommonModule, NgFor} from "@angular/common";

@Component({
  selector: 'app-liste-recettes',
  standalone: true,
  imports: [NgFor, RouterModule],
  templateUrl: './liste-recettes.component.html',
  styleUrl: './liste-recettes.component.css'
})
export class ListeRecettesComponent {
  recettes: Recette[] = [];

  constructor(private recetteService: RecetteService) { }

  ngOnInit(): void {
    this.recetteService.getRecettes().subscribe(data => {
      this.recettes = data;
    });
  }
}
