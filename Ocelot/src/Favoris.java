import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Locale;


public class Favoris {
	private static LinkedList<URL> urls;
	
	/*
	 * Cr√©ation d'une nouvelle liste de favoris vide
	 */
	public Favoris(){
		this.urls = new LinkedList<URL>();
	}
	
	/*
	 * Cr√©ation d'une nouvelle liste de favoris
	 * @param u liste de favoris que doit contenir l'objet Favoris
	 */
	public Favoris(LinkedList<URL> u){
		this.urls = u;
	}

	public LinkedList<URL> getUrls() {
		return urls;
	}
	
	public static void ajouterUrl(URL u){
		// parcours de la liste des urls deja† enregistres
		
		if (!urls.isEmpty())	
		{
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
			// si u n'est pas deja† present dans l'historique global
			if(urlNotFound)
			{
				urls.add(u);
			}
		}
		
		else
		{
			urls.add(u);
		}
		
	}
	
	/*
	 * Permet de sauvegarder l'historique global dans un fichier
	 */
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
				date =  df.parse(url_ligne[2]);  
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
	
	//Test de l'historique global
		public static void main(String[] args) throws IOException, ParseException{
			urls = new LinkedList<URL>();
			File addresseSauvegarde = new File("favoris.data");
			addresseSauvegarde.delete();
			Date date_actuelle = new Date();
			URL test = new URL("test_url","test_nom",date_actuelle,1);
			URL test2 = new URL("google.com","google moteur de recherche",date_actuelle,0);
			URL test3 = new URL("test_url","test_nom",date_actuelle,1);
			//test de la fonction ajouterUrl et verification url identique
			ajouterUrl(test);
			ajouterUrl(test2);
			ajouterUrl(test3);
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
