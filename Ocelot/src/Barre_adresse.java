public class Barre_adresse {
	private URL url;
	private boolean visibilite;
	
	public Barre_adresse(URL u){
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
	}
	
	public void desactiver() {
		this.visibilite = false;
	}
}
