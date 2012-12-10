import java.awt.Color;

public class CouleurFond extends Fond {
	private Color couleur;
	
	public CouleurFond(Color c){
		this.couleur = c;
	}

	public Color getCouleur() {
		return couleur;
	}
}
