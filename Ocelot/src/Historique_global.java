import java.util.LinkedList;
import java.util.ListIterator;

public class Historique_global {
	private LinkedList<URL> urls;
	
	public Historique_global(){
		this.urls = new LinkedList<URL>();
	}
	
	public void ajouterUrl(URL u){
		// parcours de la liste des urls déjà enregistrés
		ListIterator<URL> i = urls.listIterator();
		boolean urlNotFound = true;
		while(i.hasNext() && urlNotFound)
		{
			URL currentUrl = i.next();
			if(currentUrl.getUrl() == u.getUrl())
			{
				currentUrl.update(u);
				urlNotFound = false;
			}
		}
		// si u n'est pas déjà présent dans l'historique global
		if(urlNotFound)
		{
			urls.add(u);
		}
	}
}
