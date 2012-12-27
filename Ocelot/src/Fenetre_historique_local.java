public class Fenetre_historique_local {
	  private boolean visibilite;
	  
	  public Fenetre_historique_local(){
		  this.visibilite = false;
	  }
	  
	  public void activer(Historique_local h){
		  // gerer l'affichage de l'historique local
		  this.visibilite = true;
	  }
	  
	  public void desactiver(){
		  this.visibilite = false;
	  }
}
