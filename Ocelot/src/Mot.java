import java.awt.Color;


public class Mot extends Element implements MotOuImage{
	String caracteres;
	String fonte;
	boolean graisse;
	boolean italique;
	int corps;
	Color couleur;
	
	public Mot(int largeur, int hauteur, int x, int y, String caracteres, String fonte, boolean graisse, boolean italique, int corps, Color couleur){
		super(largeur, hauteur, x, y);
		this.caracteres = caracteres;
		this.fonte = fonte;
		this.graisse = graisse;
		this.italique = italique;
		this.corps = corps;
		this.couleur = couleur;
	}
}
