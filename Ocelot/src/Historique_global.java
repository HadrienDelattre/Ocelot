import java.util.LinkedList;

public class Historique_global {
	private LinkedList<URL> urls;
	
	public Historique_global(){
		this.urls = new LinkedList<URL>();
	}
	
	public void ajouterUrl(URL u){
		this.urls.add(u);
	}
}
