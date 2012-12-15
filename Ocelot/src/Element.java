
public abstract class Element {
	private int largeur;
	private int hauteur;
	private int x;
	private int y;
	
	public Element(int largeur, int hauteur, int x, int y){
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}
}
