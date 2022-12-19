package ConsoCarbone;

/** L'enumeration CE contient sept instances qui correspondent aux differentes classes energetiques qu'un logement peut avoir ainsi que le coefficient multiplicatif alphaCE auquel la classe energetique est associee
 */
public enum CE {A(0.005),B(0.01),C(0.02),D(0.035),E(0.055),F(0.08),G(0.1);
  private final double alphaCE;

  /** constructeur de l'enumeration CE
   * @param alphaCE qui est le coefficient multiplicatif dependant de la classe energetique du logement
   */
  private CE(double alphaCE){
    this.alphaCE = alphaCE;
  }

  /** getter de alphaCE
   * @return la valeur de l'attribut alphaCE
   */
  public double getAlphaCE(){
    return alphaCE;
  }

  public static CE value(String s){
    if (s.equals("A")){
      return CE.A;
    }
    else if (s.equals("B")){
      return CE.B;
    }
    else if (s.equals("C")){
      return CE.C;
    }
    else if (s.equals("D")){
      return CE.D;
    }
    else if (s.equals("E")){
      return CE.E;
    }
    else if (s.equals("F")){
      return CE.F;
    }
    else{
      return CE.G;
    }
  }
}
