export interface Recette {
  id: number,
  instruction: string,
  nb_personnes: number,
  temps: number,
  titre: string,
  utilisateur_id: bigint
}
