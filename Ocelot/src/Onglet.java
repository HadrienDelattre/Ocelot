public class Onglet {
    Historique_local historique_local;
    String titre;
    int id_onglet;
    
    public Onglet(String titre, int id_onglet){
    	this.titre = titre;
    	this.id_onglet = id_onglet;
    	this.historique_local = new Historique_local();
    }
    
    /*
     * Renvoit la page courante de l'historique de l'onglet
     */
    public Page_Web pageActuelle(){
    	return(this.historique_local.pageActuelle());
    }
    
    /*
     * Renvoit le titre de la page actuelle
     */
    public String getTitre(){
    	return this.historique_local.pageActuelle().getTitre();
    }
}