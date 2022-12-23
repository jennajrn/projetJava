package ConsoCarbone;

/** L'enumeration Taille contient deux instances P et G correspondant a petite voiture et grosse voiture ainsi que l'émission necessaire a la fabrication de la voiture (4.2 pour la petite et 19 pour la grosse)
 */
public enum Taille {P(4.2),G(19);
  private final double fabrication;

  /** constructeur de l'enumeration Taille
   * @param fabrication qui correspond aux emissions necessaires aa la fabrication d'une voiture
   */
  private Taille(double fabrication){
    this.fabrication = fabrication;
  }

  /** getter de fabrication
   * @return la valeur de l'attribut fabrication
   */
  public double getFabrication(){
    return fabrication;
  }
}
