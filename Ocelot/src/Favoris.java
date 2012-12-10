import java.util.LinkedList;


public class Favoris {
	private LinkedList<URL> urls;
	
	/*
	 * Création d'une nouvelle liste de favoris vide
	 */
	public Favoris(){
		this.urls = new LinkedList<URL>();
	}
	
	/*
	 * Création d'une nouvelle liste de favoris
	 * @param u liste de favoris que doit contenir l'objet Favoris
	 */
	public Favoris(LinkedList<URL> u){
		this.urls = u;
	}

	public LinkedList<URL> getUrls() {
		return urls;
	}

}
