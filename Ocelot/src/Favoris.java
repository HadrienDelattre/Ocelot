import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
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
	
	public static void sauver() {
		String addresseSauvegarde = "favoris.data";
		try {
			FileWriter fw = new FileWriter(addresseSauvegarde, true);
			BufferedWriter output = new BufferedWriter(fw);

			// Ecriture des urls
			ListIterator<URL> urlIterator = urls.listIterator();
			while(urlIterator.hasNext())
			{
				URL currentUrl = urlIterator.next();
				output.write(currentUrl.toString()+"\n");
			}
			output.close();
		} catch(IOException ioe) {
			System.out.println("Erreur au cours de la sauvegarde des favoris");
			ioe.printStackTrace();
		}
}
	
	/*
* Permet de charger l'historique global depuis un fichier
*/
public static void charger() throws IOException, ParseException {
	String addresseSauvegarde = "favoris.data";
	InputStream is=new FileInputStream(addresseSauvegarde);
	InputStreamReader isr=new InputStreamReader(is);
	BufferedReader br=new BufferedReader(isr);

	// lecture du fichier

	String currentLine = br.readLine();
	while(currentLine != null) {
		System.out.println("ligne courante\t"+currentLine);
		String[] url_ligne = currentLine.split("\t");
		String titre = url_ligne[0];
		System.out.println("titre=\t"+titre);	
		String url = url_ligne[1];
		System.out.println("url=\t"+url);
		String date_test = url_ligne[2];

		// conversion de la date dans le fichier en objet date
		Date date = new Date();	
		try {

			DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
			date = df.parse(url_ligne[2]);
			System.out.println("date=\t"+date);
		}
		catch (Exception e)
		{
			System.out.println("Erreur de lecture d'une date lors du chargement des favoris");
e.printStackTrace();
		}
		currentLine = br.readLine();
		int statut = Integer.parseInt(url_ligne[3]);
		System.out.println("statut=\t"+statut);
		// ajout de l'URL
		urls.add(new URL(url, titre, date, statut));
	}
	br.close();
}


	
	public LinkedList<URL> getUrls() {
		return urls;
	}

	
	public static void main(String[] args) throws IOException, ParseException{
urls = new LinkedList<URL>();
File addresseSauvegarde = new File("favoris.data");
addresseSauvegarde.delete();
Date date_actuelle = new Date();
URL test = new URL("test_url","test_nom",date_actuelle,1);
URL test2 = new URL("google.com","google moteur de recherche",date_actuelle,0);
URL test3 = new URL("test_url","test_nom",date_actuelle,1);
//test de la fonction ajouterUrl et verification url identique
ajouterFavoris(test);
ajouterFavoris(test2);
ajouterFavoris(test3);
for (int i=0;i<urls.size();i++)
{
System.out.println(urls.get(i).toString());

}
//test de la fonction sauver
sauver();
//vider la liste
urls.clear();
//test de la fonction charger
charger();
for (int i=0;i<urls.size();i++)
{
System.out.println(urls.get(i).toString());

}

}
}