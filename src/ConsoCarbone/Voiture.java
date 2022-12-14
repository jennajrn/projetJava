package ConsoCarbone;

/** Un objet Voiture est un Transport qui calcule l’empreinte carbone concernant les déplacements en voiture
@author Jenna JOURNO Shana BAROUKH
@version 1.0
*/
public class Voiture extends Transport{
  private boolean possede;
  private Taille taille;
  private int amortissement; //positif

  public void setPossede(boolean possede){
    this.possede = possede;
    if (possede == true){
      setImpact((super.distance * 1.93 * 0.0001) + (taille.getFabrication() / this.amortissement));
    }
    else{
      setImpact(0);
    }
  }

  public boolean getPossede(){
    return possede;
  }

  public void setTaille(Taille taille){
    this.taille = taille;
    if (possede == true){
      setImpact((super.distance * 1.93 * 0.0001) + (taille.getFabrication() / this.amortissement));
    }
    else{
      setImpact(0);
    }
  }

  public Taille getTaille(){
    return taille;
  }

  public void setDistance(int distance){
    if (distance < 0){
      System.out.println("erreur le nombre de kilomètres parcourus par an doit être positif");
			distance = 0;
    }
    super.distance = distance;
    if (possede == true){
      setImpact((super.distance*1.93*0.0001)+(taille.getFabrication()/this.amortissement));
    }
    else{
      setImpact(0);
    }
  }

  public int getDistance(){
    return distance;
  }

  public void setAmortissement(int amortissement){
    if (amortissement < 0){
      System.out.println("erreur durée de conservation du véhicule doit être positif");
			amortissement = 0;
    }
    this.amortissement = amortissement;
    if (possede == true){
      setImpact((super.distance*1.93*0.0001)+(taille.getFabrication()/this.amortissement));
    }
    else{
      setImpact(0);
    }
  }

  public int getAmortissement(){
    return amortissement;
  }

  @Override
  public String toString(){
		if(possede==false){
      return "L’utilisateur.rice. ne possède pas de voiture alors l'impact des déplacements de l’utilisateur.rice sera de 0" + "\n";
    }
    else if (taille==Taille.P){
      return "Quand l’utilisateur.rice. possède une petite voiture, que le nombre de kilomètres parcourus est " + super.distance + " par an et que la durée de conservation du véhicule est " + this.amortissement + ", l'impact de ces déplacements est " + getImpact() + " TCO2eq. id=" + super.id + "\n";
    }
    else{
      return "Quand l’utilisateur.rice. possède une grande voiture, que le nombre de kilomètres parcourus est " + super.distance + " par an et que la durée de conservation du véhicule est " + this.amortissement + ", l'impact de ces déplacements est " + getImpact() + " TCO2eq. id=" + super.id + "\n";
    }
	}

  //Constructeurs

  public Voiture(){
    this(false, Taille.P, 0, 0);
  }

  public Voiture(boolean possede, Taille taille, int distance, int amortissement){
    super();
    if (distance < 0){
      System.out.println("erreur le nombre de kilomètres parcourus par an doit être positif");
			distance = 0;
    }
    if (amortissement < 0){
      System.out.println("erreur durée de conservation du véhicule doit être positif");
			amortissement = 0;
    }
    this.possede = possede;
    this.taille = taille;
    super.distance = distance;
    this.amortissement = amortissement;
    if (possede == true){
      setImpact((super.distance*1.93*0.0001)+(taille.getFabrication()/this.amortissement));
    }
    else{
      setImpact(0);
    }
  }
}
