// @ts-ignore
import { Component } from '@angular/core';
import {ListeRecettesComponent} from "../liste-recettes/liste-recettes.component";

// @ts-ignore
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    ListeRecettesComponent,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
