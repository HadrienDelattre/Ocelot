import java.awt.Color;
import java.awt.Image;


public class Image_web extends Element implements MotOuImage {
	private Image image;
	private String source;
	private Color bordure;
	
	public Image_web(int largeur, int hauteur, int x, int y, Image image, String source, Color bordure){
		super(largeur, hauteur, x, y);
		this.image = image;
		this.source = source;
		this.bordure = bordure;
	}
}
