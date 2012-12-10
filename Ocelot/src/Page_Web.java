import java.awt.Color;
import java.util.Date;
import java.util.LinkedList;


public class Page_Web extends URL{
	LinkedList<Element> elements;
	Fond fond;
	Color couleur;
	boolean a_jour;
	
	public Page_Web(String u, String t, Date d, int statut, LinkedList<Element> e, Fond f, Color c){
		super(u, t, d, statut);
		this.elements = e;
		this.fond = f;
		this.couleur = c;
	}
}
