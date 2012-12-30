import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Barre_adresse extends JTextField {
	private URL url;
	private boolean visibilite;
	
	public Barre_adresse(URL u, int l){
		super(u.getUrl(), l);
		this.url = u;
		this.visibilite = true;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	/*
	 * Répond à la question "la barre d'adresse est-elle active?"
	 */
	public boolean estActive() {
		return visibilite;
	}

	public void activer() {
		this.visibilite = true;
		this.setEnabled(true);
	}
	
	public void desactiver() {
		this.visibilite = false;
		this.setEnabled(false);
	}
}