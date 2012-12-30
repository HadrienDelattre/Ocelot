import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;


public class Favoris {
	private LinkedList<URL> urls;
	
	/*
	 * Création d'une nouvelle liste de favoris vide
	 */
	public Favoris(){
		// TODO autochargement des favoris
		this.urls = new LinkedList<URL>();
	}
	
	/*
	 * Création d'une nouvelle liste de favoris
	 * @param u liste de favoris que doit contenir l'objet Favoris
	 */
	public Favoris(LinkedList<URL> u){
		this.urls = u;
	}
	
	/*
	 * Ajoute un favoris à la liste.
	 * Si le favoris existe déjà dans la liste un est simplement
	 * mis à jour.
	 */
	public void ajouterFavoris(URL urlNouveau){
		boolean favorisExisteDeja = false;

		// iteration sur tout les favoris
		ListIterator<URL> urlIter = this.getUrls().listIterator();
		while(!favorisExisteDeja && urlIter.hasNext()){
			URL currentUrl = urlIter.next();
			// si l'url à ajouter existe déjà dans les favoris
			if(currentUrl.getUrl() == urlNouveau.getUrl()){
				favorisExisteDeja = true;
				// actualisation de l'URL
				currentUrl.setDate(urlNouveau.getDate());
				currentUrl.setTitre(urlNouveau.getTitre());
				currentUrl.setStatut(urlNouveau.getStatut());
			}
		}
		// si à la fin de la recherche, l'URL n'a pas été
		// trouvé parmis les favoris déjà existants ;
		if(!favorisExisteDeja){
			this.urls.add(urlNouveau);
		}
	}
	
	/*
	 * Effacer les favoris,
	 * aussi bien la variable que le fichier
	 */
	public void effacer() {
		// effaçage des URLs
		this.urls = new LinkedList<URL>();
		// effaçage du fichier :
		// on ouvre le fichier en écriture et on le referme
		// sans rien écrire dedans.
		String addresseSauvegarde = "favoris.data";
		try {
			FileOutputStream fos = new FileOutputStream(addresseSauvegarde);
			fos.close();
			} catch(IOException e) {
				System.out.println("Une erreur est survenue lors de l'effaçage du fichier des favoris");
				e.printStackTrace();
			}
	}
	
	
	public LinkedList<URL> getUrls() {
		return urls;
	}

}