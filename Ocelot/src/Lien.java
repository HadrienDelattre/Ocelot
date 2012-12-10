import java.util.LinkedList;


public class Lien extends Element{
	private boolean visite;
	private LinkedList<MotOuImage> elements;
	
	public Lien(int largeur, int hauteur, int x, int y, MotOuImage element){
		super(largeur, hauteur, x, y);
		this.elements = new LinkedList<MotOuImage>();
		this.elements.add(element);
		this.visite = false;
	}

	/*
	 * Répond à la question "le lien a-t-il déjà été visité?"
	 */
	public boolean isVisite() {
		return visite;
	}
	
	/*
	 * Indique au lien qu'il a été visité
	 */
	public void visiter(){
		this.visite = true;
	}
	
	/*
	 * Indique au lien qu'il n'a pas été visité
	 */
	public void oublier(){
		this.visite = false;
	}


	public LinkedList<MotOuImage> getElements() {
		return elements;
	}
}