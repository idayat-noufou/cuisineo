import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Utilisateur} from "../../models/utilisateur";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService{
  private apiUrl = 'http://localhost:3080'; // Modifiez l'URL selon votre configuration

  constructor(private http: HttpClient, public router: Router) {}


  getUserProfile(id: string | undefined): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(`${this.apiUrl}/${id}`);
  }
}
