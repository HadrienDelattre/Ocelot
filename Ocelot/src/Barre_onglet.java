import java.util.LinkedList;
import java.util.ListIterator;


public class Barre_onglet {
	private LinkedList<Onglet> onglets;
	private int indice_onglet_courant;
	private int idDernierOnglet;
	private Fenetre_page_web fenetre_page_web;
	
	public Barre_onglet(Fenetre_page_web fenetre_page_web){
		this.onglets = new LinkedList<Onglet>();
		this.indice_onglet_courant = 0;
		this.idDernierOnglet = 0;
		this.fenetre_page_web = fenetre_page_web;
	}
	
	public int getIndiceOngletCourant(){
		return this.indice_onglet_courant;
	}
	
	public void setIndiceOngletCourant(int nouvel_indice){
		// on pourrait faire un test ici 
		// pour voir si l'indice est absurde
		this.indice_onglet_courant = nouvel_indice;
	}
	
	/*
	 * Renvoit l'onglet courant
	 */
	public Onglet ongletCourant(){
		return this.onglets.get(indice_onglet_courant);
	}
	
	/*
	 * Crée un nouvel onglet et l'ajoute à la liste des onglets de la barre
	 */
	public void creerOnglet(Page_Web page_web){
		this.onglets.add(new Onglet(page_web, this.idDernierOnglet));
		this.idDernierOnglet++;
		this.indice_onglet_courant = onglets.size();
	}
	
	/*
	 * supprime un onglet
	 */
	public void detruireOnglet(){
		this.onglets.remove(indice_onglet_courant);
		if(indice_onglet_courant > onglets.size()){
			indice_onglet_courant = onglets.size()-1;
		}
		String url = this.ongletCourant().pageActuelle().getUrl();
		if(url.matches("^http")){
			// charger_page(url)
		} else {
			// selectionner_page(url)
		}
		/* todo ;
		 * si on veut pouvoir charger et selectionner des pages,
		 * il faut que la barre d'onglet ai une référence vers la fenetre_page_web
		 * de la fenetre à laquelle elle est rattachée
		 */
	}
	
	/*
	 * selectionne un onglet
	 */
	public void selectionnerOnglet(int id_onglet){
		int i;
		for(i=0;i<onglets.size();i++){
			Onglet o = onglets.get(i);
			if(o.getId() == id_onglet){
				this.indice_onglet_courant = i;
			}
		}
		String url = this.ongletCourant().pageActuelle().getUrl();
		if(url.matches("^http")){
			// fenetre_page_web.charger_page(url)
		} else {
			// fenetre_page_web.selectionner_page(url)
		}
	}
}