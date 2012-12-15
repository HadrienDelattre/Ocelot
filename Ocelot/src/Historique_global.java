import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	/*
	 * Permet de sauvegarder l'historique global dans un fichier
	 */
	public void sauver() {
		String addresseSauvegarde = "historique_global.data";
		try {
			FileWriter fw = new FileWriter(addresseSauvegarde, true);
			BufferedWriter output = new BufferedWriter(fw);
			
			// écriture des urls
			ListIterator<URL> urlIterator = urls.listIterator();
			while(urlIterator.hasNext())
			{
				URL currentUrl = urlIterator.next();
				// chaque url est écrit sur plusieurs lignes dans un ordre précis
				output.write(currentUrl.getUrl());
				output.newLine();
				output.flush();
				output.write(currentUrl.getTitre());
				output.newLine();
				output.flush();
				output.write(currentUrl.getDate().toString());
				output.newLine();
				output.flush();
				output.write(currentUrl.getStatut());
				output.newLine();
				output.flush();
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
		FileInputStream fs = new FileInputStream(addresseSauvegarde);
		DataInputStream in = new DataInputStream(fs);
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(ir);
		
		// lecture du fichier
		String currentLine = br.readLine();
		try{
			while(currentLine != null) {
				String url = currentLine;
				String titre = br.readLine();
				// conversion de la date dans le fichier en objet date
				Date date = new Date();
				try {
					DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
					date = (Date)formatter.parse(br.readLine());
				} catch(ParseException pe) {
					System.out.println("Erreur de lecture d'une date lors du chargement de l'historique global");
					pe.printStackTrace();
				}
				int statut = Integer.parseInt(br.readLine());
				
				// ajout de l'URL
				this.urls.add(new URL(url, titre, date, statut));
			}
		} catch (IOException ioe) {
			System.out.println("Erreur au cours du chargement de l'historique global");
			ioe.printStackTrace();
		}
		
	}
	
	public LinkedList<URL> getUrls() {
		return urls;
	}
}