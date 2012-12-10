import java.util.LinkedList;


public class Barre_onglet {
	private LinkedList<Onglet> onglets;
	private int indice_onglet_courant;
	private String titre;
	
	public Barre_onglet(){
		this.onglets = new LinkedList<Onglet>();
		this.indice_onglet_courant = 0;
		this.titre = "";
	}
	
	public int getIndiceOngletCourant(){
		return this.indice_onglet_courant;
	}
	
	public void setIndiceOngletCourant(int nouvel_indice){
		// on pourrait faire un test ici 
		// pour voir si l'indice est absurde
		this.indice_onglet_courant = nouvel_indice;
		this.titre = this.onglets.get(indice_onglet_courant).getTitre();
	}
	

}
