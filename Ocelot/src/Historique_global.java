import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	private LinkedList<URL> urls;

	public Historique_global(){
		try {
			charger();
		} catch (IOException | ParseException e) {
			this.urls = new LinkedList<URL>();
			e.printStackTrace();
		}
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
	public void charger() throws IOException, ParseException {
		String addresseSauvegarde = "historique_global.data";
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
			System.out.println("Erreur de lecture d'une date lors du chargement de l'historique global");
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
	
	/*
	 * Effacer l'historique global,
	 * aussi bien la variable que le fichier
	 */
	public void effacer() {
		// effaçage des URLs
		this.urls = new LinkedList<URL>();
		// effaçage du fichier :
		// on ouvre le fichier en écriture et on le referme
		// sans rien écrire dedans.
		String addresseSauvegarde = "historique_global.data";
		try {
			FileOutputStream fos = new FileOutputStream(addresseSauvegarde);
			fos.close();
			} catch(IOException e) {
				System.out.println("Une erreur est survenue lors de l'effaçage du fichier de l'historique global");
				e.printStackTrace();
			}
	}
	
	public LinkedList<URL> getUrls() {
		return urls;
	}
}