import java.util.LinkedList;


public class Barre_onglet {
	private LinkedList<Onglet> onglets;
	private int indice_onglet_courant;
	private int idDernierOnglet;
	
	public Barre_onglet(){
		this.onglets = new LinkedList<Onglet>();
		this.indice_onglet_courant = 0;
		this.idDernierOnglet = 0;
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
}