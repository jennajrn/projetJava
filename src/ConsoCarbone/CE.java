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

  /** methode permettant de convertir une chaîne de caractere en objet CE
   * @param s qui est une chaine de caractere A,B,C,D,E ou F a convertir en objet CE
   * @return un objet de type CE correspondant a la chaine de caractere s prise en argument
   * @throws ErrVal afin de s'assurer que la chaine de caractere prise en argument corresponde bien à A,B,C,D,E ou F
   */
  public static CE value(String s) throws ErrVal{
    if (!s.equals("A") && !s.equals("B") && !s.equals("C") && !s.equals("D") && !s.equals("E") && !s.equals("F") && !s.equals("G")){
      throw new ErrVal("La chaine de caractère prise en argument doit être A,B,C,D,E,F ou G mais est " + s);
    }
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
