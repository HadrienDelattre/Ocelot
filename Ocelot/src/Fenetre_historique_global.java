
public class Fenetre_historique_global {
  private boolean visibilite;
  private Historique_global historique_global;
  
  public Fenetre_historique_global(){
	  this.visibilite = false;
	  this.historique_global = new Historique_global();
  }
  
  public void activer(){
	  this.visibilite = true;
  }
  
  public void desactiver(){
	  this.visibilite = false;
  }
}
