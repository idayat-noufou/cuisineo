import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RecetteService } from "../../services/Recette/recette.service";
import { Recette } from "../../models/recette";

@Component({
  selector: 'app-recette-detail',
  templateUrl: './recette-detail.component.html',
  standalone: true,
  styleUrls: ['./recette-detail.component.css']
})
export class RecetteDetailComponent implements OnInit {
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
