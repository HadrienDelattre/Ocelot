import java.awt.Image;

public class ImageFond extends Fond {
	private Image image;
	private String source;
	
	/*
	 * attention
	 * A terme il faudra initialiser avec une source,
	 * faire charger la source et initialiser l'image avec ça
	 */
	public ImageFond(Image i, String s){
		this.image = i;
		this.source = s;
	}

	public String getSource() {
		return source;
	}

	public Image getImage() {
		return image;
	}
}