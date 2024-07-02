import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Recette} from "../../models/recette";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class RecetteService{
  private apiUrl = 'http://localhost:3080'; // Modifiez l'URL selon votre configuration

  constructor(private http: HttpClient, public router: Router) {}

  getRecettes(): Observable<Recette[]> {
    return this.http.get<Recette[]>(`${this.apiUrl}/recettes`);
  }

  getRecetteById(id: number): Observable<Recette> {
    return this.http.get<Recette>(`${this.apiUrl}/${id}`);
  }

  createRecette(recette: Recette): Observable<Recette> {
    return this.http.post<Recette>(this.apiUrl, recette);
  }
}
