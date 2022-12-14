package ConsoCarbone;

public enum Taille {P(4.2),G(19);
  private final double fabrication;

  /** constructeur de l'enumeration Taille
   * @param fabrication qui correspond aux emissions necessaires à la fabrication d'une voiture
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
