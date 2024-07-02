import { Component } from '@angular/core';
import {CommonModule} from "@angular/common";
import {Recette} from "../../models/recette";
import {ActivatedRoute} from "@angular/router";
import {RecetteService} from "../../services/Recette/recette.service";

@Component({
  selector: 'app-recette-detail',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './recette-detail.component.html',
  styleUrl: './recette-detail.component.css'
})
export class RecetteDetailComponent {
  recette: Recette | undefined;

  constructor(
    private route: ActivatedRoute,
    private recetteService: RecetteService
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.recetteService.getRecetteById(id).subscribe((data: any) => {
      this.recette = data;
    });
  }
}
