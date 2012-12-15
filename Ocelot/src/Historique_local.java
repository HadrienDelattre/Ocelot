import java.util.LinkedList;

public class Historique_local {
    private int indice_page_actuelle;
    private LinkedList<Page_Web> pages_web;
    
    /*
     * Initialisation d'un historique local vide
     */
    public Historique_local(){
    	this.indice_page_actuelle = 0;
    	this.pages_web = new LinkedList<Page_Web>();
    }
    
    /*
     * Renvoit la page web courante
     */
    public Page_Web pageActuelle(){
    	return(pages_web.get(this.indice_page_actuelle));
    }
    
    /*
     * Permet d'ajouter une nouvelle page web à l'historique
     * @param p page web à ajouter
     */
    public void ajouterPage(Page_Web p){
    	if(fin()) { // si on est sur la dernière page de l'historique
    		pages_web.add(p);
    	} else { // si on se trouve à l'interieur de l'historique
    		// amputation de l'historique
    		pages_web = (LinkedList<Page_Web>) pages_web.subList(0, indice_page_actuelle+1);
    		// ajout de la nouvelle page sur le moignon
    		pages_web.add(p);
    	}
    	indice_page_actuelle++;
    }
    
    /*
     * Décrémente l'indice de la page actuelle
     * et renvoit la nouvelle page actuelle
     */
    public Page_Web pagePrecedente(){
    	if(!debut()){
    		this.indice_page_actuelle--;
    	}
    	return(pageActuelle());
    }
    
    /*
     * Incrémente l'indice de la page actuelle
     * et renvoit la nouvelle page actuelle
     */
    public Page_Web pageSuivante(){
    	if(!fin()) {
    		this.indice_page_actuelle++;
    	}
    	return(pageActuelle());
    }
    
    /*
     * Répond à la question "la page web actuelle est-elle la dernière de cet historique?"
     */
    public boolean fin(){
    	return(indice_page_actuelle == pages_web.size()-1);
    }
    
    /*
     * Répond à la question "la page web actuelle est-elle la première de cet historique?"
     */
    public boolean debut(){
    	return(indice_page_actuelle == 0);
    }
}