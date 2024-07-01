import {Component, OnInit} from '@angular/core';
import {Recette} from "../../models/recette";
import {RecetteService} from "../../services/Recette/recette.service";

// @ts-ignore
@Component({
  selector: 'liste-recettes',
  standalone: true,
  imports: [],
  templateUrl: './liste-recette.component.html',
  styleUrl: './liste-recette.component.css'
})
export class ListeRecettesComponent implements OnInit {
  recettes: Recette[] = [];

  constructor(private recetteService: RecetteService) { }

  ngOnInit(): void {
    this.recetteService.getRecettes().subscribe(data => {
      this.recettes = data;
    });
  }
}
