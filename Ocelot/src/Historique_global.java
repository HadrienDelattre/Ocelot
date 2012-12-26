import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

public class Historique_global {
	private static LinkedList<URL> urls;

	public Historique_global(){
		this.urls = new LinkedList<URL>();
	}
	
	public static void ajouterUrl(URL u){
		// parcours de la liste des urls deja  enregistres
		
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
			// si u n'est pas deja  present dans l'historique global
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
		String addresseSauvegarde = "historique_global.data";
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
			System.out.println("Erreur au cours de la sauvegarde de l'historique global");
			ioe.printStackTrace();
		}
	}
	
	/*
	 * Permet de charger l'historique global depuis un fichier
	 */
	public static void charger() throws IOException, ParseException {
		String addresseSauvegarde = "historique_global.data";
		InputStream is=new FileInputStream(addresseSauvegarde); 
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		
		// lecture du fichier
		
		String currentLine = br.readLine();
		while(currentLine != null) {
			System.out.println("ligne courante"+currentLine);
			String[] url_ligne = currentLine.split("\t");
			String titre = url_ligne[0];
			System.out.println("titre=\t"+titre);			
			String url = url_ligne[1];
			System.out.println("url=\t"+url);
			
			String date_test = url_ligne[2];
			System.out.println("date=\t"+date_test);
			// conversion de la date dans le fichier en objet date
			Date date = new Date();			
			try {
				
				DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
				date =  df.parse(url_ligne[2]);  
		
		        } 
			catch (Exception e) 
			{ 
				System.out.println("Erreur de lecture d'une date lors du chargement de l'historique global");
				e.printStackTrace(); 
			}
			currentLine = br.readLine();
		/*	try {
				date = date.;
//					DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
//					date = (Date)formatter.parse(br.readLine());
			} catch(ParseException pe) {
				System.out.println("Erreur de lecture d'une date lors du chargement de l'historique global");
				pe.printStackTrace();
			}*/
			int statut = Integer.parseInt(url_ligne[3]);
			
			// ajout de l'URL
			urls.add(new URL(url, titre, date, statut));
		}
		br.close();
		
	}
	
	public LinkedList<URL> getUrls() {
		return urls;
	}
	
	//Test de l'historique global
	public static void main(String[] args) throws IOException, ParseException{
		urls = new LinkedList<URL>();
		File addresseSauvegarde = new File("historique_global.data");
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